package jdbc;

import junit.framework.TestCase;

import org.junit.Test;

public class ControlDBTest extends TestCase {
    
    @Test
    public void testExecuteQuery() {
        assertNotNull(ControlDB.executeQuery("select * from commodity"));
    }
    
    @Test
    public void testExecuteQueryArgs() {
        String[] account = {"admin", "123456"};
        assertNotNull(ControlDB.executeQuery("select * from account where username = ? and password = ?", account));
    }
    
    @Test
    public void testExecuteUpdate() {
        assertEquals(1, ControlDB.executeUpdate("update commodity SET name = 'A' where id = 1"));
    }
    
    @Test
    public void testExecuteUpdateArgs() {
        String[] account = {"admin", "123456"};
        assertEquals(1, ControlDB.executeUpdate("update account SET username = ?,password = ? where id = 1", account));
    }
} 