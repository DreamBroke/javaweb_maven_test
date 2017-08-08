package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commodity;
import dao.CommodityDAO;

public class AddCommodityServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -1335636978667424021L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.equals("")) {
            CommodityDAO commodityDAO = new CommodityDAO();
            Commodity commodity = commodityDAO.getCommodityById(id);
            req.setAttribute("commodity", commodity);
        }
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("commodity.id");
        String price = req.getParameter("commodity.price");
        String quantity = req.getParameter("commodity.quantity");
        String name = req.getParameter("commodity.name");
        CommodityDAO commodityDAO = new CommodityDAO();
        commodityDAO.insertToCommodity(id, name, price, quantity);
        resp.sendRedirect("../hello");
    }

}
