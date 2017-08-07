package jdbc;

import java.util.List;

import model.Commodity;
import dao.CommodityDAO;

public class Test {

    public static void main(String[] args) {
        CommodityDAO commodityDAO = new CommodityDAO();
        List<Commodity> list = commodityDAO.getAllCommodity();
        for(Commodity c : list){
            System.out.println(c.getName());
        }
    }

}
