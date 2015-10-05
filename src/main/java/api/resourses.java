/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import database.DatabaseHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.Manufacturer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sjors
 */
public final class resourses {

    DatabaseHandler DBhandler;

    public resourses() throws NamingException, SQLException {
        this.DBhandler = new DatabaseHandler();
    }

    public final List<Manufacturer> getListOfManufacturers() throws SQLException {
        //List<String> macs = DBhandler.getAllMacAddresses();
        
        //tijdelijk, totdat de MACS in de database wel kloppen
        List<String> macs = new ArrayList<>();
        macs.add("38aa3cb47edf");
        
        List<Manufacturer> manufacturers = new ArrayList<>();
        if (!macs.isEmpty()) {
            for (String mac : macs) {
                Manufacturer man = getManufacturerByMac(mac);
                if (man != null) {
                    if (manufacturers.contains(man)) {
                        manufacturers.get(manufacturers.indexOf(man)).addOneToAmount();
                    } else {
                        manufacturers.add(man);
                    }
                }
            }
        }
        return manufacturers;
    }

    final Manufacturer getManufacturerByMac(String mac) {
        JSONObject jsonManufacturer = null;
        try {
            URL url = prepareGetManufacturerURL(mac);
            HttpURLConnection getManufacturer = (HttpURLConnection) url.openConnection();
            getManufacturer.setRequestMethod("GET");
            System.out.println(getManufacturer.getURL());
            String code = String.valueOf(getManufacturer.getResponseCode());
            System.out.println("HTTP Error code " + code);
            if(getManufacturer.getResponseCode() == 204)
            {
             return new Manufacturer("other", 0);   
            }
                 
            InputStream is = getManufacturer.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                JSONArray jsA = new JSONArray(line);
                jsonManufacturer = new JSONObject(jsA.getJSONObject(0));           
            }
        } catch (IOException | JSONException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        System.out.println("company" + jsonManufacturer.get("company"));
            return new Manufacturer(jsonManufacturer.get("company").toString(), 0);

    }

    final URL prepareGetManufacturerURL(String mac) throws MalformedURLException {
        //voorbeeld: http://www.macvendorlookup.com/api/v2/38-aa-3c-b4-7e-df
        StringBuilder getManufacturerURL = new StringBuilder();
        getManufacturerURL.append("http://www.macvendorlookup.com/api/v2/");
        getManufacturerURL.append(mac);
        return new URL(getManufacturerURL.toString());
    }

}
