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
                student.setEmail(resultSet.getString("Email"));
                student.setPhone(resultSet.getString("Phone"));
                student.setIdCardNo(resultSet.getString("IdCardNo"));
                student.setAddress(resultSet.getString("Address"));
                student.setGradeNo(resultSet.getInt("GradeNo"));
                student.setGender(resultSet.getInt("Gender"));
                String sql1 = "select GradeName from grades where GradeNO = '" + resultSet.getInt("GradeNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    student.setGradeName(rs1.getString("GradeName"));
                }
                return student;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeCon();
            if(resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }
    public ArrayList<Students> getStudentList() throws SQLException {
        ArrayList<Students> ret = new ArrayList<Students>();
        String sql = "select * from students";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Students s = new Students();
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setUserName(resultSet.getString("UserName"));
                s.setEmail(resultSet.getString("Email"));
                s.setPhone(resultSet.getString("Phone"));
                s.setIdCardNo(resultSet.getString("IdCardNo"));
                s.setAddress(resultSet.getString("Address"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGender(resultSet.getInt("Gender"));
                String sql1 = "select GradeName from grades where GradeNO = '" + resultSet.getInt("GradeNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    s.setGradeName(rs1.getString("GradeName"));
                }
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeCon();
            if(resultSet!=null) resultSet.close();
        }
        return ret;
    }

    public ArrayList<Students> getTStudentList(String gradeno) throws SQLException {
        ArrayList<Students> ret = new ArrayList<Students>();
        String sql = "select * from students where GradeNO = '" + gradeno + "'";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Students s = new Students();
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setUserName(resultSet.getString("UserName"));
                s.setEmail(resultSet.getString("Email"));
                s.setPhone(resultSet.getString("Phone"));
                s.setIdCardNo(resultSet.getString("IdCardNo"));
                s.setAddress(resultSet.getString("Address"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
                s.setGender(resultSet.getInt("Gender"));
                String sql1 = "select GradeName from grades where GradeNO = '" + resultSet.getInt("GradeNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    s.setGradeName(rs1.getString("GradeName"));
                }
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeCon();
            if(resultSet!=null) resultSet.close();
        }
        return ret;
    }
    public boolean deleteStudent(String studentno) {
        String sql = "delete from students where StudentNO = '" + studentno + "'";
        try {
             return update(sql);
        } finally {
            closeCon();
        }
    }
    public boolean updateStudent(String studentno, Students s) {
        String sql = "update students set UserName = '" + s.getUserName() + "',Email = '" + s.getEmail() +
                "',Phone='" + s.getPhone() + "',IdCardNO='" + s.getIdCardNo() + "',Address='" + s.getAddress()+
                "',Gender='" + s.getGender() + "',GradeNO='" + s.getGradeNo() + "' where StudentNO = '" + studentno + "'";
        try{
            return update(sql);
        }finally {
            closeCon();
        }
    }
    public boolean insertStudent(Students s) {
        String values = "('" + s.getUserName() + "','" + s.getEmail() + "','" + s.getPhone() + "','" + s.getIdCardNo() + "','"
                + s.getAddress() + "','" + s.getGradeNo() + "','" + s.getGender() + "')";
        String sql = "insert into students (UserName,Email,Phone,IdCardNO,Address,GradeNO,Gender) values " + values;
        try {
            return update(sql);
        }finally {
            closeCon();
        }
    }
}
