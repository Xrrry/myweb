package servlet;

import bean.Subjects;
import dao.GradeDao;
import dao.SubjectDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SubjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        if("delete".equals(method)) {
            deleteStudent(request,response);
        }
        else if("toUpdate".equals(method)) {
            toUpdateSubject(request,response);
        }
        else if("update".equals(method)) {
            updateSubject(request,response);
        }
        else if("insert".equals(method)) {
            insertSubject(request,response);
        }
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String path = request.getContextPath();
        SubjectDao sdao = new SubjectDao();
        sdao.deleteSubject(id);
        response.sendRedirect(path + "/view/subjects.jsp");
    }
    private void toUpdateSubject(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id");
        String path = request.getContextPath();
        SubjectDao sdao = new SubjectDao();
        Subjects s = sdao.getSubject(id);
        request.getSession().setAttribute("subject",s);
        response.sendRedirect(path + "/view/Usubject.jsp");
    }
    private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getContextPath();
        HttpSession session = request.getSession();
        Subjects s = new Subjects();
        SubjectDao sdao = new SubjectDao();
        GradeDao gdao = new GradeDao();
        Subjects subjects = (Subjects) session.getAttribute("subject");
        String GradeNO = String.valueOf(subjects.getSubjectNo());
        s.setSubjectName(transform("name",request));
        s.setClassHour(Long.parseLong(request.getParameter("hour")));
        String gradename = transform("gradename",request);
        s.setGradeName(gradename);
        s.setGradeNo(Long.parseLong(gdao.getGradeNO(gradename)));
        if(sdao.updateSubject(GradeNO,s)){
            response.sendRedirect(path +"/view/subjects.jsp");
        }
        else{
            request.getSession().setAttribute("message","更新失败");
            response.sendRedirect(path + "/view/error.jsp");
        }
    }
    private String transform(String n, HttpServletRequest request) throws UnsupportedEncodingException {
        String a = request.getParameter(n);
        byte[] source = a.getBytes("ISO8859-1");
        return new String(source, "UTF-8");
    }
    private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subjects s = new Subjects();
        SubjectDao sdao = new SubjectDao();
        GradeDao gdao = new GradeDao();
        String path = request.getContextPath();
        s.setSubjectName(transform("name",request));
        s.setClassHour(Long.parseLong(request.getParameter("hour")));
        String gradename = transform("gradename",request);
        s.setGradeName(gradename);
        s.setGradeNo(Long.parseLong(gdao.getGradeNO(gradename)));
        if(sdao.insertSubject(s)){
            response.sendRedirect(path + "/view/subjects.jsp");
        }
        else{
            request.getSession().setAttribute("message","添加失败");
            response.sendRedirect(path + "/view/error.jsp");
        }
    }
}
