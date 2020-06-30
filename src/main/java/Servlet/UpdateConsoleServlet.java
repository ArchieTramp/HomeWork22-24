package Servlet;

import DAO.ConsoleDao;
import Pojo.NewGameConsole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateConsoleServlet extends HttpServlet {
    private ConsoleDao consoleDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String consoleID = req.getParameter("id");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String model = req.getParameter("model");
        String price = req.getParameter("price");
        String includeGames = req.getParameter("includeGames");
        String company = req.getParameter("company");
        NewGameConsole newGameConsole = new NewGameConsole(null, name, model, Integer.valueOf(price), Integer.valueOf(includeGames), company);
        consoleDao.upgradeConsole(Integer.valueOf(consoleID));

        resp.sendRedirect(req.getContextPath() + "/allconsoles");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String consoleID = req.getParameter("id");
        if (consoleID == null) {
            throw new ServletException("ID NULL");
        }
        NewGameConsole newGameConsole = consoleDao.upgradeConsole(Integer.valueOf(consoleID));
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
        req.setAttribute("PageBody", "updateconsole.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }


    @Override
    public void init() throws ServletException {
        consoleDao = (ConsoleDao) getServletContext().getAttribute("dao");
        super.init();
    }
}
