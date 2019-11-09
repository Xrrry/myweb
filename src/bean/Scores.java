package bean;


public class Scores {

  private long scoreId;
  private long studentNo;
  private long subjectNo;
  private long score;
  private java.sql.Timestamp examDate;


  public long getScoreId() {
    return scoreId;
  }

  public void setScoreId(long scoreId) {
    this.scoreId = scoreId;
  }


  public long getStudentNo() {
    return studentNo;
  }

  public void setStudentNo(long studentNo) {
    this.studentNo = studentNo;
  }


  public long getSubjectNo() {
    return subjectNo;
  }

  public void setSubjectNo(long subjectNo) {
    this.subjectNo = subjectNo;
  }


  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }


  public java.sql.Timestamp getExamDate() {
    return examDate;
  }

  public void setExamDate(java.sql.Timestamp examDate) {
    this.examDate = examDate;
  }

}
