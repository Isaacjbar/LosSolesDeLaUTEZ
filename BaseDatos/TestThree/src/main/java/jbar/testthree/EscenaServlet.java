package jbar.testthree;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/escena")
public class EscenaServlet extends HttpServlet {
    private Escena escena;

    @Override
    public void init() throws ServletException {
        super.init();
        escena = new Escena();
        escena.addScene("A");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verificar si se ha actualizado la lista de escenas
        if (request.getSession().getAttribute("escenasUpdated") != null) {
            request.getSession().removeAttribute("escenasUpdated");
            request.setAttribute("escenas", escena.getEscenas());
        }
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("escenaId");

        if (answer != null && !answer.isEmpty()) {
            int length = answer.length();
            char lastChar = answer.charAt(length - 1);

            if (lastChar == 'A' || lastChar == 'B') {
                escena.addScene(answer + "1");
                escena.addScene(answer + "2");
            } else {
                escena.addScene(answer + "A");
                escena.addScene(answer + "B");
            }

            // Indicar que las escenas se han actualizado correctamente
            request.getSession().setAttribute("escenasUpdated", true);

            // Redirigir al usuario a la misma URL (/escena) para evitar reenvío del formulario
            response.sendRedirect(request.getContextPath() + "/escena");
        }
    }
}
