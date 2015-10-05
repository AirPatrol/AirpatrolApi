/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import database.DatabaseHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import model.Manufacturer;

/**
 *
 * @author Daan
 */

@Path("/airpatrol")
public class airpatrolapi {
    
    @GET
    @Produces("application/json")
    public Response Test(){
        //return "Hallo";
        return Response.ok()
                .entity("hallo")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .allow("OPTIONS").build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/mac")
    public Response getMacAddresses(){
        try {
            DatabaseHandler h = new DatabaseHandler();
            Gson gson = new Gson();
            
            return Response.ok()
                .entity(gson.toJson(h.getAllMacAddresses()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .allow("OPTIONS").build();
            
        } catch (NamingException ex) {
            Logger.getLogger(airpatrolapi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(airpatrolapi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Response.serverError().build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/manufacturer")
    public Response getManufacturers(){
        Gson gson = new Gson();
        List<Manufacturer> m = new ArrayList<>();
        m.add(new Manufacturer("SAMSUNG", 100));
        m.add(new Manufacturer("APPLE", 74));
        m.add(new Manufacturer("NOKIA", 23));
        m.add(new Manufacturer("HTC", 56));
        m.add(new Manufacturer("CRACKBERRY", 1));
        m.add(new Manufacturer("XIAOMI", 66));
        m.add(new Manufacturer("YOTAPHONE", 17));
        
        return Response.ok()
                .entity(gson.toJson(m))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .allow("OPTIONS").build();
    }
}
