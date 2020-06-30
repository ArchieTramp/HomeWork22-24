package Servlet;

import DAO.ConsoleDao;
import Pojo.NewGameConsole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class ShowAllConsolesServlet extends HttpServlet {
    private ConsoleDao consoleDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<NewGameConsole> consoles = consoleDao.getAllConsole();
        req.setAttribute("consoles", consoles);
        req.setAttribute("PageTitle", "Consoles");
        req.setAttribute("PageBody", "allconsoles.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);

    }

    @Override
    public void init() throws ServletException {
        consoleDao = (ConsoleDao) getServletContext().getAttribute("dao");
        super.init();
    }
}
