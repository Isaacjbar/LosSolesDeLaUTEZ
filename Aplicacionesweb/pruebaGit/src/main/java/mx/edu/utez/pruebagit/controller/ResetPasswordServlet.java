package mx.edu.utez.pruebagit.controller;

import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "ResetPasswordServlet", value = "/reset")
public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String codigo = request.getParameter("cody");
        if(newPassword == null || codigo == null) {
            System.out.println("No puedes tener campos vacios");
        }else{
            UserDao userDao = new UserDao();
            Boolean funciono = userDao.updatePassword(codigo, newPassword);
            if(funciono == true){
                response.sendRedirect("index.jsp");
                System.out.println("FUNCIONOOO");
            }else{
                System.out.println("NO FUNCIONO TITE");
            }
        }

    }
}
