/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfilewithregex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.PayerInfo;
import model.SMGS;
import model.Sent;
import utils.PatternTemplate;

/**
 *
 * @author LapasovFG.VCRP
 */
public class ReadFileWithRegex {

    private String filepath;

    private String headerpattern;

    private String bodypattern;

    /**
     * Get the value of bodypattern
     *
     * @return the value of bodypattern
     */
    public String getBodypattern() {
        return bodypattern;
    }

    /**
     * Set the value of bodypattern
     *
     * @param bodypattern new value of bodypattern
     */
    public void setBodypattern(String bodypattern) {
        this.bodypattern = bodypattern;
    }

    /**
     * Get the value of headerpattern
     *
     * @return the value of headerpattern
     */
    public String getPattern() {
        return headerpattern;
    }

    /**
     * Set the value of headerpattern
     *
     * @param pattern new value of headerpattern
     */
    public void setPattern(String pattern) {
        this.headerpattern = pattern;
    }

    /**
     * Get the value of filepath
     *
     * @return the value of filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * Set the value of filepath
     *
     * @param filepath new value of filepath
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
  
    public void readstroke() throws FileNotFoundException, IOException {
        String headerpatt = getPattern();
        String bodypatt=getBodypattern();
        String destfile = getFilepath();
        // The RE headerpattern
        Pattern hp = Pattern.compile(headerpatt);
        Pattern bp = Pattern.compile(bodypatt);
        // A FileReader (see the I/O chapter)
//        BufferedReader r = new BufferedReader(new FileReader(destfile));
        FileInputStream fis=new FileInputStream(new File(destfile));
        BufferedReader r = new BufferedReader(new InputStreamReader(fis,"CP866"));

        // For each line of input, try matching in it.
        String line;
        int sum = 0;
        int sumlines = 0;
//        int smgs=0;
        SMGS smgs = null;
        List<SMGS> listsmgs=new ArrayList();
        List<Sent> listsents=new ArrayList();
        int countpayerinfo=0;
        while ((line = r.readLine()) != null) {
            // For each match in the line, extract and print it.
            
//            sumlines++;
//            Matcher m = patt.matcher(line);
//            while (m.find()) {
//                sum++;
//                System.out.println(m.group(3));
//            }
//            if(line.contains("СМГС")){
//                smgs++;
//                System.out.println(line);
//           
//
//                
//            }
            if(line.contains("СМГС")){
                System.out.println(line);
                smgs=new SMGS();
                continue;
            }
            //head matcher
            Matcher m = hp.matcher(line);
            PayerInfo payerinfo = null;
            
            while (m.find()) {
                payerinfo=new PayerInfo();
                payerinfo.setDorogasost(Integer.parseInt(m.group(1)));
                payerinfo.setDotpnaz(m.group(2));
                payerinfo.setPayernum(m.group(3));
                payerinfo.setTarif(Integer.parseInt(m.group(4)));
                payerinfo.setRepmonth(m.group(5));
                payerinfo.setIskltarif(m.group(6));
                payerinfo.setPog_vxod_stan(m.group(7));
                payerinfo.setLengthiness(m.group(8));
                countpayerinfo++;
//                listsmgs.add(smgs);
            }
            
            Matcher mbody=bp.matcher(line);
            Sent sent=null;
            while(mbody.find()){
                sent=new Sent();
                sent.setStanotpr(mbody.group(1));
                sent.setNumotpr(mbody.group(2));
                sent.setDprdm(mbody.group(3));
                sent.setNumvag(mbody.group(4));
                sent.setWeight(mbody.group(5));
                sent.setNumpervedom(mbody.group(6));
                sent.setDmper(mbody.group(7));
                sent.setActualweight(mbody.group(8));
                sent.setCalcweight(mbody.group(9));
                sent.setNumposclassetc(mbody.group(10));
                sent.setFees(mbody.group(11));
                sent.setSborgalabatermez(mbody.group(12));
                sent.setAddsbors(mbody.group(13));
                sent.setAddsbors(mbody.group(14));
                sent.setTotal(mbody.group(15));
                
            }
            if(payerinfo!=null &&smgs!=null){
                
            }
//            listsents.add(sent);
//            payerinfo.setListsents(listsents);
//            smgs.setPayerinfo(payerinfo);
//            listsmgs.add(smgs);
            
        }
        
//        System.out.println("smgs="+smgs);
//        System.out.println("sum= " + sum);
//        System.out.println("sumlines= " + sumlines);
        System.out.println("leng: "+listsmgs.size());
        System.out.println("count payerinfo: "+countpayerinfo);
    }

    public static void main(String[] args) throws IOException {
        ReadFileWithRegex rfreg = new ReadFileWithRegex();
        rfreg.setFilepath("F132");
//        rfreg.setPattern(PatternTemplate.getPatternTemplate("regexpattern"));
//        rfreg.readstroke();
        rfreg.setPattern(PatternTemplate.getPatternTemplate("headerpattern"));
        rfreg.setBodypattern(PatternTemplate.getPatternTemplate("regexpattern"));
        rfreg.readstroke();
    }

}
