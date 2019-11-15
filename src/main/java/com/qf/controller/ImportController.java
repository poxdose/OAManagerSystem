package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.service.HeadTeacherService;
import com.qf.service.ImportService;
import com.qf.util.ExcelUtils;
import com.qf.util.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ImportController {

    @Autowired
    private ImportService importService;

    @Autowired
    private HeadTeacherService headTeacherService;


    @RequestMapping("upload")
    public String uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            System.out.println(lo);
            Student student = new Student();
            student.setSname(lo.get(0).toString());
            student.setSage((int)NumberUtils.tranPointNum(0,Double.parseDouble(lo.get(1).toString())));
            student.setSsex(lo.get(2).toString());
            student.setCid((int)NumberUtils.tranPointNum(0,Double.parseDouble(lo.get(3).toString())));
            headTeacherService.saveStudent(student);
        }
        return "上传成功";
    }

    @RequestMapping("daorudaochu")
    public String daorudaochu() {
        return "daorudaochu";
    }

    /**
     * 导出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Student> list = headTeacherService.getUserList();

        //excel标题
        String[] title = {"姓名", "年龄", "性别", "班级"};

        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";

        String [][] content = new String[list.size()][4];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Student obj = list.get(i);
            content[i][0] = obj.getSname();
            content[i][1] = String.valueOf(obj.getSage());
            content[i][2] = obj.getSsex();
            content[i][3] = String.valueOf(obj.getCid());
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}