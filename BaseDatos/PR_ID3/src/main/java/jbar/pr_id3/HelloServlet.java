package jbar.pr_id3;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private List<Item> items = new ArrayList<>();
    private int idCounter = 1;

    public void init() {
        // Do any initialization here
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (title != null && !title.isEmpty() && description != null && !description.isEmpty()) {
            Item newItem = new Item(idCounter++, title, description);
            items.add(newItem);
        }

        response.sendRedirect("hello-servlet");
    }

    public static class Item {
        private int id;
        private String title;
        private String description;

        public Item(int id, String title, String description) {
            this.id = id;
            this.title = title;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}
