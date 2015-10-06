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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    final List<Manufacturer> getManufacturerByMac() throws SQLException {
        
        ArrayList<Manufacturer> m = new ArrayList();
        HashMap<String, Integer> hm = new HashMap();
        
        for (String s : DBhandler.getAllMacAddresses()){
            JSONObject jsonManufacturer = null;
            try {
                URL url = prepareGetManufacturerURL(s);
                HttpURLConnection getManufacturer = (HttpURLConnection) url.openConnection();
                getManufacturer.setRequestMethod("GET");
                System.out.println(getManufacturer.getURL());
                String code = String.valueOf(getManufacturer.getResponseCode());
                System.out.println("HTTP Error code " + code);
                if(getManufacturer.getResponseCode() == 204 )
                {
                    if (hm.get("other") != null){
                        hm.put("other", hm.get("other") + 1);
                    }
                    else
                    {
                        hm.put("other",1);
                    }
                }
                else
                {
                    InputStream is = getManufacturer.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        JSONArray jsA = new JSONArray(line);
                        String manu = jsA.getJSONObject(0).getString("company");

                        if (hm.get(manu) != null){
                            hm.put(manu, hm.get(manu) + 1);
                        }
                        else
                        {
                            hm.put(manu,1);
                        }
                    }
                }
            } catch (IOException | JSONException ex) {
                System.out.println(ex.getMessage());
                return m;
            }
        }
        
        System.out.println(hm.size());
        
        while (hm.entrySet().iterator().hasNext()){
            Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>)hm.entrySet().iterator().next();
            hm.remove(pair.getKey());
            m.add(new Manufacturer(pair.getKey(),pair.getValue()));
        }
        
        return m;
    }

    final URL prepareGetManufacturerURL(String mac) throws MalformedURLException {
        //voorbeeld: http://www.macvendorlookup.com/api/v2/38-aa-3c-b4-7e-df
        StringBuilder getManufacturerURL = new StringBuilder();
        getManufacturerURL.append("http://www.macvendorlookup.com/api/v2/");
        getManufacturerURL.append(mac);
        return new URL(getManufacturerURL.toString());
    }

}
