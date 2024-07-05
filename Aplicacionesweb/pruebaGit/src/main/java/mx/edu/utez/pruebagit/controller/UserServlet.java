package mx.edu.utez.pruebagit.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/sign_in")
public class UserServlet extends HttpServlet {
    //init, destroy y doPost y/o doGet

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Aqui se va a conectar la base de datos para obtener un usuario
        //y en dado caso de que exista mandarlo al sistema (otra vista)

        String user_name = req.getParameter("user_name");
        String pass = req.getParameter("pass");
        UserDao dao = new UserDao();
        User u = dao.getOne(user_name, pass);

        String ruta = "index.jsp";
        if(u.getUser_name() != null) {
            // Que el usuario SI existe en la base de datos
            ruta = "bienvenido.jsp";
        } else {
            //Que el usuario No existe
            HttpSession sesion = req.getSession();
            sesion.setAttribute("mensaje", "El usuario no existe en la BD");
        }

        resp.sendRedirect(ruta);
    }

    public void destroy() {

    }

    public void init() throws ServletException {

    }
}
