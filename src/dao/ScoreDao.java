package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Scores;

public class ScoreDao extends BaseDao{
    public Scores getScore(int id) throws SQLException {
        String sql = "select * from scores where ScoreID = '" + id + "'";
        Scores score = null;
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                score = new Scores();
                score.setScoreId(resultSet.getInt("ScoreId"));
                score.setStudentNo(resultSet.getInt("StudentNO"));
                score.setSubjectNo(resultSet.getInt("SubjectNo"));
                score.setScore(resultSet.getInt("Score"));
                score.setExamDate(resultSet.getDate("ExamDate"));
                return score;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeCon();
            if(resultSet!=null) resultSet.close();
        }
        return score;
    }
    public ArrayList<Scores> getScoreList() throws SQLException {
        ArrayList<Scores> ret = new ArrayList<Scores>();
        String sql = "select * from scores";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Scores s = new Scores();
                s.setScoreId(resultSet.getInt("ScoreId"));
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setSubjectNo(resultSet.getInt("SubjectNo"));
                s.setScore(resultSet.getInt("Score"));
                s.setExamDate(resultSet.getDate("ExamDate"));
                String sql1 = "select UserName from students where StudentNO = '" + resultSet.getInt("StudentNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    s.setStudentName(rs1.getString("UserName"));
                }
                String sql2 = "select SubjectName from subjects where SubjectNO = '" + resultSet.getInt("SubjectNO") + "'";
                ResultSet rs2 = query(sql2);
                if(rs2.next()) {
                    s.setSubjectName(rs2.getString("SubjectName"));
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
    public ArrayList<Scores> getTScoreList(String gradeno) throws SQLException {
        ArrayList<Scores> ret = new ArrayList<Scores>();
        String sql = "select * from scores,students where scores.StudentNO = students.StudentNO and students.GradeNO = '" + gradeno + "'";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Scores s = new Scores();
                s.setScoreId(resultSet.getInt("ScoreId"));
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setSubjectNo(resultSet.getInt("SubjectNo"));
                s.setScore(resultSet.getInt("Score"));
                s.setExamDate(resultSet.getDate("ExamDate"));
                String sql1 = "select UserName from students where StudentNO = '" + resultSet.getInt("StudentNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    s.setStudentName(rs1.getString("UserName"));
                }
                String sql2 = "select SubjectName from subjects where SubjectNO = '" + resultSet.getInt("SubjectNO") + "'";
                ResultSet rs2 = query(sql2);
                if(rs2.next()) {
                    s.setSubjectName(rs2.getString("SubjectName"));
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
    public ArrayList<Scores> getPScoreList(String studentno) throws SQLException {
        ArrayList<Scores> ret = new ArrayList<Scores>();
        String sql = "select * from scores,students where scores.StudentNO = students.StudentNO and students.StudentNO = '" + studentno + "'";
        ResultSet resultSet = query(sql);
        try {
            while(resultSet.next()){
                Scores s = new Scores();
                s.setScoreId(resultSet.getInt("ScoreId"));
                s.setStudentNo(resultSet.getInt("StudentNO"));
                s.setSubjectNo(resultSet.getInt("SubjectNo"));
                s.setScore(resultSet.getInt("Score"));
                s.setExamDate(resultSet.getDate("ExamDate"));
                String sql1 = "select UserName from students where StudentNO = '" + resultSet.getInt("StudentNO") + "'";
                ResultSet rs1 = query(sql1);
                if(rs1.next()) {
                    s.setStudentName(rs1.getString("UserName"));
                }
                String sql2 = "select SubjectName from subjects where SubjectNO = '" + resultSet.getInt("SubjectNO") + "'";
                ResultSet rs2 = query(sql2);
                if(rs2.next()) {
                    s.setSubjectName(rs2.getString("SubjectName"));
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
    public boolean deleteScore(String scoreid) {
        String sql = "delete from scores where ScoreID = '" + scoreid + "'";
        try {
            return update(sql);
        }
        finally {
            closeCon();
            return false;
        }
    }
}
