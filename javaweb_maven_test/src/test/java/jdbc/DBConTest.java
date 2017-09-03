package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;

public class DBConTest extends TestCase {

    @Test
    public void testGetConnection() {
        Connection conn = DBCon.GetConnection();
        try {
            assertNotNull(conn.createStatement().executeQuery("select * from commodity"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
