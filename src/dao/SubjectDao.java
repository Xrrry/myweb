package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Subjects;

public class SubjectDao extends BaseDao{
    public Subjects getSubject(int id){
        String sql = "select * from subjects where SubjectID = '" + id + "'";
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
}
