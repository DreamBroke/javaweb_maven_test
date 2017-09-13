package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commodity;
import dao.CommodityDAO;

@WebServlet(name="UpdateCommodityServlet", urlPatterns="/hello/update")
public class UpdateCommodityServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 8457637237604586592L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommodityDAO commodityDAO = new CommodityDAO();
        Commodity commodity = commodityDAO.getCommodityById(req.getParameter("id"));
        req.setAttribute("commodity", commodity);
        req.setAttribute("method", "Update");
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
        commodityDAO.updateCommodityById(id, name, price, quantity);
        resp.sendRedirect("../hello");
    }
    
}
