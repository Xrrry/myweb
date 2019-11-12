package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Students;
import bean.Teachers;

public class TeacherDao extends BaseDao{
    public Teachers getTeacher(int id){
        String sql = "select * from teachers where TeacherNO = '" + id + "'";
        Teachers teachers = null;
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                teachers = new Teachers();
                teachers.setTeacherNo(resultSet.getInt("TeacherNO"));
                teachers.setTeacherName(resultSet.getString("TeacherName"));
                teachers.setGradeNo(resultSet.getInt("GradeNO"));
                String sql1 = "select GradeName from grades where GradeNO = '" + resultSet.getInt("GradeNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    teachers.setGradeName(rs1.getString("GradeName"));
                }
                return teachers;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return teachers;
    }
    public ArrayList<Teachers> getTeacherList(){
        ArrayList<Teachers> ret = new ArrayList<Teachers>();
        String sql = "select * from teachers";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Teachers t = new Teachers();
                t.setTeacherNo(resultSet.getInt("TeacherNO"));
                t.setTeacherName(resultSet.getString("TeacherName"));
                t.setGradeNo(resultSet.getInt("GradeNO"));
                String sql1 = "select GradeName from grades where GradeNO = '" + resultSet.getInt("GradeNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    t.setGradeName(rs1.getString("GradeName"));
                }
                ret.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
}
