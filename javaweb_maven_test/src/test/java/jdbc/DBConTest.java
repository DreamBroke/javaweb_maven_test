package jdbc;

import junit.framework.TestCase;

import org.junit.Test;

public class DBConTest extends TestCase {

    @Test
    public void testGetConnection() {
        assertNotNull(DBCon.GetConnection());
    }
    
}
