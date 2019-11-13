package servlet;

import bean.Teachers;
import dao.TeacherDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class TeacherServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        if("delete".equals(method)) {
            deleteTeacher(request,response);
        }
        else if("toUpdate".equals(method)) {
            toUpdateTeacher(request,response);
        }
        else if("update".equals(method)) {
            updateTeacher(request,response);
        }
    }
    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String path = request.getContextPath();
        TeacherDao tdao = new TeacherDao();
        tdao.deleteTeacher(id);
        response.sendRedirect(path + "/view/teachers.jsp");
    }
    private void toUpdateTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id");
        String path = request.getContextPath();
        TeacherDao tdao = new TeacherDao();
        Teachers t = tdao.getTeacher(id);
        request.getSession().setAttribute("teacher",t);
        response.sendRedirect(path + "/view/Uteacher.jsp");
    }
    private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getContextPath();
        HttpSession session = request.getSession();
        Teachers t = new Teachers();
        TeacherDao tdao = new TeacherDao();
        Teachers teachers = (Teachers) session.getAttribute("teacher");
        String TeacherNO = String.valueOf(teachers.getTeacherNo());
        t.setTeacherName(transform("name",request));
        System.out.println(t.getTeacherName());
        if(tdao.updateTeacher(TeacherNO,t)){
            response.sendRedirect(path +"/view/teachers.jsp");
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
}
