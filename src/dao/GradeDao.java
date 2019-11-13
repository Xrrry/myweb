package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Grades;

public class GradeDao extends BaseDao{
    public Grades getGrade(String id){
        String sql = "select * from grades where GradeNO = '" + id + "'";
        Grades grade = null;
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                grade = new Grades();
                grade.setGradeName(resultSet.getString("GradeName"));
                grade.setGradeNo(resultSet.getInt("GradeNo"));
                return grade;
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
        return grade;
    }
    public ArrayList<Grades> getGradeList() throws SQLException {
        ArrayList<Grades> ret = new ArrayList<Grades>();
        String sql = "select * from grades";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Grades s = new Grades();
                s.setGradeName(resultSet.getString("GradeName"));
                s.setGradeNo(resultSet.getInt("GradeNo"));
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
    public boolean deleteGrade(String gradeno) {
        String sql = "delete from grades where GradeNO = '" + gradeno + "'";
        try {
            return update(sql);
        }
        finally {
            closeCon();
        }
    }
    public boolean updateGrade(String gradeno, Grades s) {
        String sql = "update grades set GradeName = '" + s.getGradeName() + "' where GradeNO = '" + gradeno + "'";
        try{
            return update(sql);
        }finally {
            closeCon();
        }
    }
}
