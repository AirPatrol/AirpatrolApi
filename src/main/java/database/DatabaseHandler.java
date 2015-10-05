/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Daan
 */
public class DatabaseHandler {
    
    private Connection conn;
    
    public DatabaseHandler() throws NamingException, SQLException{
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("fontys");
        dataSource.setServerName("192.168.221.193");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("airpatrol");
        conn = dataSource.getConnection();
    }
    
    public boolean testConnection() throws SQLException{
        return conn.isValid(10000);
    }
}
