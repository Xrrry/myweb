package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Students;

public class StudentDao extends BaseDao{
    public Students getStudent(String id){
        String sql = "select * from students where StudentNO = '" + id + "'";
        Students student = null;
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                student = new Students();
                student.setStudentNo(resultSet.getInt("StudentNO"));
                student.setUserName(resultSet.getString("UserName"));
                student.setPassword(resultSet.getString("password"));
                student.setEmail(resultSet.getString("Email"));
                student.setPhone(resultSet.getString("Phone"));
                student.setIdCardNo(resultSet.getString("IdCardNo"));
                student.setAddress(resultSet.getString("Address"));
                student.setGradeNo(resultSet.getInt("GradeNo"));
                student.setGender(resultSet.getInt("Gender"));
                return student;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return student;
    }
    public ArrayList<Students> getStudentList(){
        ArrayList<Students> ret = new ArrayList<Students>();
        String sql = "select * from students";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Students s = new Students();
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setUserName(resultSet.getString("UserName"));
                s.setPassword(resultSet.getString("password"));
                s.setEmail(resultSet.getString("Email"));
                s.setPhone(resultSet.getString("Phone"));
                s.setIdCardNo(resultSet.getString("IdCardNo"));
                s.setAddress(resultSet.getString("Address"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGender(resultSet.getInt("Gender"));
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    public ArrayList<Students> getTStudentList(String gradeno) {
        ArrayList<Students> ret = new ArrayList<Students>();
        String sql = "select * from students where GradeNO = '" + gradeno + "'";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Students s = new Students();
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setUserName(resultSet.getString("UserName"));
                s.setPassword(resultSet.getString("password"));
                s.setEmail(resultSet.getString("Email"));
                s.setPhone(resultSet.getString("Phone"));
                s.setIdCardNo(resultSet.getString("IdCardNo"));
                s.setAddress(resultSet.getString("Address"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGender(resultSet.getInt("Gender"));
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
    public boolean deleteStudent(String studentno) {
        String sql = "delete from students where StudentNO = '" + studentno + "'";
        return update(sql);
    }
}
