package mx.edu.utez.pruebagit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import mx.edu.utez.pruebagit.utils.GmailSender;
import mx.edu.utez.pruebagit.utils.SimpleRandomStringGenerator;

import java.io.IOException;

@WebServlet(name = "RecuperacionServlet", value = "/recupera")
public class RecuperacionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1) Checar que el correo exista en la base de datos
        String correo = req.getParameter("correo");
        UserDao dao = new UserDao();
        Boolean existe = dao.getOne(correo);
        if (existe==true) {
            System.out.println("El usuario existe");
            // Sí existe el correo en la BD
            // 2) Generar el código único para el usuario e insertarlo en la BD (Clase)
            SimpleRandomStringGenerator generator = new SimpleRandomStringGenerator();
            String cody = generator.generateRandomString(20);

            // 3 Actualizar el cody del usuario del email
            dao.updateWithEmail(correo, cody);

            // 3) Generar y enviar el correo electrónico (Clase)
            try {
                GmailSender gs = new GmailSender();
                gs.sendMail(correo, "Reestablece tu contraseña",
                        "<a href='http://localhost:8080/pruebaGit_war/recupera?codigo="
                                + cody + "'>Restablecer contraseña</a>"
                );
            } catch (Exception e) {
                e.printStackTrace();
                req.getSession().setAttribute("mensaje", "Error al enviar el correo");
                resp.sendRedirect("index.jsp");
                return;
            }

        } else {
            // No existe
            req.getSession().setAttribute("mensaje", "El correo no está registrado");
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codyLink = req.getParameter("codigo");
        String codyBD ="";
        UserDao dao = new UserDao();
        Boolean codigoExiste = dao.codeExist(codyLink);
        if (codigoExiste) {
            System.out.println("El codgo existe");
            resp.sendRedirect("ReestablecerContra.jsp?cody=" + codyLink);
        }else {
            System.out.println("El codgo no existe");
        }
    }
}
