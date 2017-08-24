package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ControlDB;
import jdbc.DBClose;
import jdbc.DBCon;
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

    public void insertToCommodity(String id, String name, String price, String quantity) {
        String sql = "insert into commodity values(?,?,?,?)";
        Connection conn = DBCon.GetConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            if (id != null && !id.equals("")) {
                ps.setString(1, id);
            } else {
                ps.setString(1, null);
            }
            ps.setString(2, name);
            ps.setString(3, price);
            ps.setString(4, quantity);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(ps, conn);
        }
    }
    
    public void updateCommodityById(String id, String name, String price, String quantity) {
        String sql = "update commodity set name=?,price=?,quantity=? where id=?";
        Connection conn = DBCon.GetConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, quantity);
            ps.setString(4, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(ps, conn);
        }
    }

    public void deleteConmmodityById(String id) {
        String sql = "delete from commodity where id = " + id;
        ControlDB.executeUpdate(sql);
    }

}
