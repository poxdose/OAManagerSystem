package com.qf.service;

import com.qf.mapper.HeadTeacherMapper;
import com.qf.pojo.Student;
import com.qf.pojo.Zhoubao;
import com.qf.pojo.ZhoubaoTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

@Service
public class HeadTeacherServiceImpl implements HeadTeacherService{

    @Autowired
    private HeadTeacherMapper headTeacherMapper;

    public HeadTeacherMapper getHeadTeacherMapper() {
        return headTeacherMapper;
    }

    public void setHeadTeacherMapper(HeadTeacherMapper headTeacherMapper) {
        this.headTeacherMapper = headTeacherMapper;
    }

    @Override
    public int TeacherUpdateUpwd(String uname, String upwd) {
        return headTeacherMapper.TeacherUpdateUpwd(uname,upwd);
    }

    @Override
    public List<ZhoubaoTeacher> WeekPaperPoint() {
        return headTeacherMapper.WeekPaperPoint();
    }

    @Override
    public int saveStudent(Student student) {
        return headTeacherMapper.saveStudent(student);
    }

    @Override
    public int deleteStudent(int sid) {
        return headTeacherMapper.deleteStudent(sid);
    }

    @Override
    public int updateStudent(Student student) {
        return headTeacherMapper.updateStudent(student);
    }

    @Override
    public List<Student> getUserList() {
        return headTeacherMapper.getUserList();
    }

    @Override
    public Student getStudentBySid(int sid) {
        return headTeacherMapper.getStudentBySid(sid);
    }

    public  String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
