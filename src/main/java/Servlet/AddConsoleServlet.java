package Servlet;


import DAO.ConsoleDao;
import Pojo.NewGameConsole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddConsoleServlet extends HttpServlet {
    private ConsoleDao consoleDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New Consoles");
        req.setAttribute("PageBody", "form.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String model = req.getParameter("model");
        String price = req.getParameter("price");
        String includeGames = req.getParameter("includeGames");
        String company = req.getParameter("company");
        NewGameConsole newGameConsole = new NewGameConsole(null, name, model, Integer.valueOf(price), Integer.valueOf(includeGames), company);
        consoleDao.addConsole(newGameConsole);

        resp.sendRedirect(req.getContextPath() + "/allconsoles");

    }

    @Override
    public void init() throws ServletException {
        consoleDao = (ConsoleDao) getServletContext().getAttribute("dao");
        super.init();
    }
}
