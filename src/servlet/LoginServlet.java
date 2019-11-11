package servlet;

import dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("servlet初始化");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String path = request.getContextPath();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        session.setAttribute("account",account);
        String code = request.getParameter("code");
        String randStr = (String)session.getAttribute("randStr");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        LoginDao ldao = new LoginDao();
        System.out.println(account);
        System.out.println(code);
        if(ldao.Validate(account,password)==1) {
            System.out.println('1');
            if(!code.equals(randStr)) {
                response.sendRedirect(path + "/view/login.jsp?flag=1");
            }
            else {
                response.sendRedirect(path + "/view/students.jsp");
            }
        }
        else {
            System.out.println('2');
            response.sendRedirect(path + "/view/login.jsp?flag=2");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }

    public void destroy() {
        super.destroy();
    }
}
