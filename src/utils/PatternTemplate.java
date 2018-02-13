/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author LapasovFG.VCRP this class is used for retrieving pattern of regex
 * from property file
 */
public class PatternTemplate {


    public static String getPatternTemplate(String patternkey) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("myprop.properties"));
        } catch (IOException e) {
            System.out.println("Could not open Config file");
        }
        String patterntemplate=properties.getProperty(patternkey);
//        System.out.println("pattern"+patterntemplate);
        return patterntemplate;
    }

}
