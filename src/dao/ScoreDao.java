package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Scores;

public class ScoreDao extends BaseDao{
    public Scores getScore(int id){
        String sql = "select * from scores where ScoreID = " + id;
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
        }
        return score;
    }
    public ArrayList<Scores> getScoreList(){
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
                ret.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
}
