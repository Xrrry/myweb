package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Subjects;

public class SubjectDao extends BaseDao{
    public Subjects getSubject(String id){
        String sql = "select * from subjects where SubjectNO = '" + id + "'";
        Subjects subject = null;
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                subject = new Subjects();
                subject.setSubjectNo(resultSet.getInt("SubjectNo"));
                subject.setSubjectName(resultSet.getString("SubjectName"));
                subject.setClassHour(resultSet.getInt("ClassHour"));
                subject.setGradeNo(resultSet.getInt("GradeNo"));
                subject.setGradeName(resultSet.getString("GradeName"));
                return subject;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subject;
    }
    public ArrayList<Subjects> getSubjectList(){
        ArrayList<Subjects> ret = new ArrayList<Subjects>();
        String sql = "select * from subjects";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Subjects s = new Subjects();
                s.setSubjectNo(resultSet.getInt("SubjectNo"));
                s.setSubjectName(resultSet.getString("SubjectName"));
                s.setClassHour(resultSet.getInt("ClassHour"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGradeName(resultSet.getString("GradeName"));
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
    public ArrayList<Subjects> searchSubject(String info){
        ArrayList<Subjects> ret = new ArrayList<Subjects>();
        String value = "SubjectNO='" + info + "' or SubjectName like '%" + info + "%' or ClassHour='"
                + info + "' or GradeNO='" + info + "' or GradeName like '%" + info + "%'";
        String sql = "select * from subjects where " + value;
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Subjects s = new Subjects();
                s.setSubjectNo(resultSet.getInt("SubjectNo"));
                s.setSubjectName(resultSet.getString("SubjectName"));
                s.setClassHour(resultSet.getInt("ClassHour"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGradeName(resultSet.getString("GradeName"));
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
    public ArrayList<Subjects> getTSubjectList(String gradeno){
        ArrayList<Subjects> ret = new ArrayList<Subjects>();
        String sql = "select * from subjects where GradeNO = '" + gradeno + "'";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Subjects s = new Subjects();
                s.setSubjectNo(resultSet.getInt("SubjectNo"));
                s.setSubjectName(resultSet.getString("SubjectName"));
                s.setClassHour(resultSet.getInt("ClassHour"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGradeName(resultSet.getString("GradeName"));
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
    public boolean deleteSubject(String subjectno) {
        String sql = "delete from subjects where SubjectNO = '" + subjectno + "'";
        try {
            return update(sql);
        }
        finally {
            closeCon();
        }
    }
    public boolean updateSubject(String subjectno, Subjects s) {
        String sql = "update subjects set SubjectName = '" + s.getSubjectName() + "', ClassHour = '" + s.getClassHour() +
                "',GradeNO='" + s.getGradeNo() + "',GradeName='" + s.getGradeName() + "' where SubjectNO='" + subjectno + "'";
        try{
            return update(sql);
        }finally {
            closeCon();
        }
    }
    public boolean insertSubject(Subjects s) {
        String value = "('" + s.getSubjectName() + "','" + s.getClassHour() + "','" + s.getGradeNo() + "','" + s.getGradeName() + "')";
        String sql = "insert into subjects (SubjectName,ClassHour,GradeNO,GradeName) values " + value;
        try {
            return update(sql);
        }finally {
            closeCon();
        }
    }
}
