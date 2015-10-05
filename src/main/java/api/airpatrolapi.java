/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import database.DatabaseHandler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Daan
 */

@Path("/airpatrol")
public class airpatrolapi {
    
    @GET
    @Produces("application/json")
    public String Test(){
        return "Hallo";
    }
    
    @GET
    @Produces("application/json")
    @Path("/mac")
    public String getMacAddresses(){
        try {
            DatabaseHandler h = new DatabaseHandler();
            Gson gson = new Gson();
            return gson.toJson(h.getAllMacAddresses());
        } catch (NamingException ex) {
            Logger.getLogger(airpatrolapi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(airpatrolapi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
