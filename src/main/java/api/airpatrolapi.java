/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

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
}
