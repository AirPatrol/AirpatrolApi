/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import model.Manufacturer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sjors
 */
public class resoursesTest {
    
    public resoursesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListOfManufacturers method, of class resourses.
     */
    @Test
    public void testGetListOfManufacturers() throws Exception {
        System.out.println("getListOfManufacturers");
        resourses instance = new resourses();
        //List<Manufacturer> expResult = null;
        List<Manufacturer> result = instance.getListOfManufacturers();
        //assertEquals(expResult, result);
        for(Manufacturer man : result)
        {
            System.out.println(man.toString());
        }
    }

    /**
     * Test of getManufacturerByMac method, of class resourses.
     */
    @Test
    public void testGetManufacturerByMac() throws NamingException, SQLException {
        System.out.println("getManufacturerByMac");
        String mac = "";
        resourses instance = new resourses();
        Manufacturer expResult = null;
        Manufacturer result = instance.getManufacturerByMac(mac);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareGetManufacturerURL method, of class resourses.
     */
    @Test
    public void testPrepareGetManufacturerURL() throws Exception {
        System.out.println("prepareGetManufacturerURL");
        String mac = "";
        resourses instance = new resourses();
        URL expResult = null;
        URL result = instance.prepareGetManufacturerURL(mac);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
