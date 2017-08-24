package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commodity;
import dao.CommodityDAO;

public class JavaWebPageServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 2874100059291626590L;
    private CommodityDAO commodityDAO = new CommodityDAO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("method") != null && req.getParameter("method").equals("delete")) {
            commodityDAO.deleteConmmodityById(req.getParameter("id"));
            resp.sendRedirect("hello");
            return;
        }
        List<Commodity> list = null;
        if (req.getParameter("id") != null && !req.getParameter("id").equals("")) {
            list = commodityDAO.getAllCommodity(req.getParameter("id"));
        } else {
            list = commodityDAO.getAllCommodity();
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/first.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
