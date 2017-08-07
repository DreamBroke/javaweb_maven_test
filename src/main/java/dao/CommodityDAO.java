package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ControlDB;
import model.Commodity;

public class CommodityDAO {

    public ArrayList<Commodity> getAllCommodity(){
        ResultSet rs = null;
        String sql = "select * from commodity";
        ControlDB c = new ControlDB();
        rs = c.executeQuery(sql);
        ArrayList<Commodity> al = new ArrayList<Commodity>();
        Commodity com = null;
        try {
            while (rs.next()) {
                com = new Commodity();
                com.setId(rs.getInt("id"));
                com.setName(rs.getString("name"));
                com.setPrice(rs.getDouble("price"));
                com.setQuantity(rs.getInt("quantity"));
                al.add(com);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
    
}
