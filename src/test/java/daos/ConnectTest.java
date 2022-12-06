package daos;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class ConnectTest {
    @Test
    public void getConnectTest(){
        Connection connection = Connect.getConnection();
        Assert.assertNotNull(connection);
    }
}
