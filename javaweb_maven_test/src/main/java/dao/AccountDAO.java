package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.ControlDB;

public class AccountDAO {

    public boolean isRightAccount(String[] args) {
        String sql = "select * from account where username = ? and password = ?";
        ResultSet rs = null;
        rs = ControlDB.executeQuery(sql, args);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
}
