package Servlet;

import DAO.ConsoleDao;
import Pojo.NewGameConsole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteConsoleServlet extends HttpServlet {

    private ConsoleDao consoleDao;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String consoleID = req.getParameter("id");
        if (consoleID == null) {
            throw new ServletException("ID NULL");
        }
        NewGameConsole newGameConsole = consoleDao.deleteConsole(Integer.valueOf(consoleID));
        if (newGameConsole == null) {
            resp.setStatus(404);
            req.setAttribute("PageTitle", "Consoles");
            req.setAttribute("PageBody", "notfound.jsp");
            req.getRequestDispatcher("/layout.jsp")
                    .forward(req, resp);
            return;
        }
        req.setAttribute("console", newGameConsole);
        req.setAttribute("PageTitle", "Consoles");
        req.setAttribute("PageBody", "deleteconsole.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        consoleDao = (ConsoleDao) getServletContext().getAttribute("dao");
        super.init();
    }
}
