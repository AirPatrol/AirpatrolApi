/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        dataSource.setPassword("supergeheim1");
        dataSource.setServerName("192.168.35.50");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("airpatrol");
        conn = dataSource.getConnection();
    }
    
    public boolean testConnection() throws SQLException{
        return conn.isValid(10000);
    }
    
    public List<String> getAllMacAddresses() throws SQLException{
        
        ArrayList<String> mac = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT DESTINCT mac FROM device");
        
        while (rs.next()){
            mac.add(rs.getString(1));
        }
        
        stmt.close();
        return mac;
    }
}
