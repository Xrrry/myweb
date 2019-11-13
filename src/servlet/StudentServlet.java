package servlet;

import bean.Students;
import dao.StudentDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        if("delete".equals(method)) {
            deleteStudent(request,response);
        }
        else if("toUpdate".equals(method)) {
            toUpdateStudent(request,response);
        }
        else if("update".equals(method)) {
            updateStudent(request,response);
        }
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String path = request.getContextPath();
        StudentDao sdao = new StudentDao();
        if(sdao.deleteStudent(id)){
            response.sendRedirect(path + "/view/students.jsp");
        }
        else{
            request.getSession().setAttribute("message","删除失败,存在外键");
            response.sendRedirect(path + "/view/error.jsp");
        }
    }
    private void toUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String path = request.getContextPath();
        StudentDao sdao = new StudentDao();
        Students s = sdao.getStudent(id);
        request.getSession().setAttribute("student",s);
        response.sendRedirect(path + "/view/Ustudent.jsp");
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String path = request.getContextPath();
        StudentDao sdao = new StudentDao();
        Students s = sdao.getStudent(id);
        request.getSession().setAttribute("student",s);
        response.sendRedirect(path + "/view/Ustudent.jsp");
    }
}
