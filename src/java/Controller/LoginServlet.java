/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.UserDTO;
/**
 *
 * @author linh2
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String username = "";
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie cookie : cookies) {
                    if(!cookie.getValue().isEmpty()){
                        username = cookie.getValue();
                    }
                }
            }
            if(username.isEmpty()){
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                request.setAttribute("USERNAME", username);
                request.getRequestDispatcher("Detail.jsp").forward(request, response);
            }
            
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        
        UserDAO dao = new UserDAO();        
        UserDTO user = dao.login(username, password);
        if (user == null) {
            request.setAttribute("ERRORMESSAGE","Username or password is not correct");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if(remember!= null){
        Cookie cookie = new Cookie("username",user.getUserName());
        cookie.setMaxAge(2*24*60*60);
        response.addCookie(cookie);
        }
        request.setAttribute("USERNAME", user.getUserName());
        request.getRequestDispatcher("Detail.jsp").forward(request, response);
    }
}
