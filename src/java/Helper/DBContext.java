/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;

/**
 *
 * @author linh2
 */
public class DBContext {
     public Connection getConnection() throws Exception{
        String server = "NHAT_LINH\\MAYAO";
       String user ="sa";
       String password = "1234";
       String db = "LoginDB";
       int port = 1433;
       SQLServerDataSource ds = new SQLServerDataSource();
       ds.setUser(user);
       ds.setPassword(password);
       ds.setDatabaseName(db);
       ds.setServerName(server);
       ds.setPortNumber(port);
        Connection con = ds.getConnection();
        return con;
}
}
