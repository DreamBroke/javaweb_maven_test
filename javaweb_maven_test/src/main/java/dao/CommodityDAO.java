package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ControlDB;
import model.Commodity;

public class CommodityDAO {

    public ArrayList<Commodity> getAllCommodity() {
        ResultSet rs = null;
        String sql = "select * from commodity";
        rs = ControlDB.executeQuery(sql);
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

    public ArrayList<Commodity> getAllCommodity(String id) {
        ResultSet rs = null;
        String sql = "select * from commodity where id = " + id;
        rs = ControlDB.executeQuery(sql);
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

    public Commodity getCommodityById(String id) {
        ResultSet rs = null;
        String sql = "select * from commodity where id = " + id;
        rs = ControlDB.executeQuery(sql);
        Commodity com = null;
        try {
            if (rs.next()) {
                com = new Commodity();
                com.setId(rs.getInt("id"));
                com.setName(rs.getString("name"));
                com.setPrice(rs.getDouble("price"));
                com.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return com;
    }

    public int insertToCommodity(String id, String name, String price, String quantity) {
        String sql = "insert into commodity values(?,?,?,?)";
        String args[] = {id, name, price, quantity};
        int affectedRow = ControlDB.executeUpdate(sql, args);
        return affectedRow;
    }
    
    public int updateCommodityById(String id, String name, String price, String quantity) {
        String sql = "update commodity set name=?,price=?,quantity=? where id=?";
        String args[] = {name, price, quantity, id};
        int affectedRow = ControlDB.executeUpdate(sql, args);
        return affectedRow;
    }

    public int deleteConmmodityById(String id) {
        String sql = "delete from commodity where id = " + id;
        int affectedRow = ControlDB.executeUpdate(sql);
        return affectedRow;
    }

}
