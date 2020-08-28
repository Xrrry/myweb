package bean;


import lombok.Data;

@Data
public class Scores {

  private long scoreId;
  private long studentNo;
  private long subjectNo;
  private long score;
  private java.util.Date examDate;
  private String StudentName;
  private String SubjectName;

}
