package org.hw1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {
    private List<Product> list;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<h3>Форма для добавления</h3>");
        resp.getWriter().println("<form method='post'>");

        resp.getWriter().println("Введите id: <input type='number' name='id'>");
        resp.getWriter().println("<br>Введите наименование: <input type='text' name='name'>");
        resp.getWriter().println("<br>Введите цену: <input type='number' name='cost'>");

        resp.getWriter().println("<br><input type='submit'>");

        resp.getWriter().println("</form>");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String cost = req.getParameter("cost");

        if (id != null && id != ""
        && name != null && name != ""
        && cost != null && cost != "") {
            Product product = new Product(Integer.parseInt(id), name, Float.parseFloat(cost));
            list.add(product);
        }

        for (Product p : list) {
                resp.getWriter().println("<p>" + p.toString() +"</p>");
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
