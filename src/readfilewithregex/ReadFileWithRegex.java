/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfilewithregex;

import excelexport.ExcelReport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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

//    public void getListSMGS() throws FileNotFoundException, IOException {
    public List<SMGS> getListSMGS() throws FileNotFoundException, IOException {
        String headerpatt = getPattern();
        String bodypatt = getBodypattern();
        String destfile = getFilepath();
        // The RE headerpattern
        Pattern hp = Pattern.compile(headerpatt);
        Pattern bp = Pattern.compile(bodypatt);
        // A FileReader (see the I/O chapter)
//        BufferedReader r = new BufferedReader(new FileReader(destfile));
        FileInputStream fis = new FileInputStream(new File(destfile));
        BufferedReader r = new BufferedReader(new InputStreamReader(fis, "CP866"));

        // For each line of input, try matching in it.
        String line;
        SMGS smgs = null;
        PayerInfo payerinfo = null;
        List<SMGS> listsmgs = new ArrayList();
        List<Sent> listsents = null;
        while ((line = r.readLine()) != null) {
            if (line.contains("СМГС")) {
                smgs = new SMGS();
                listsmgs.add(smgs);
                continue;
            }
            //head matcher
            Matcher m = hp.matcher(line);

            while (m.find()) {
                payerinfo = new PayerInfo();
                payerinfo.setDorogasost(Integer.parseInt(m.group(1)));
                payerinfo.setDotpnaz(m.group(2));
                payerinfo.setPayernum(m.group(3));
                payerinfo.setTarif(Integer.parseInt(m.group(4)));
                payerinfo.setRepmonth(m.group(5));
                payerinfo.setIskltarif(m.group(6));
                payerinfo.setPog_vxod_stan(m.group(7));
                payerinfo.setLengthiness(m.group(8));
                listsents = new ArrayList();
                payerinfo.setListsents(listsents);
                listsmgs.get(listsmgs.size() - 1).setPayerinfo(payerinfo);
            }

            Matcher mbody = bp.matcher(line);
            while (mbody.find()) {
                Sent sent = new Sent();
                sent.setStanotpr(mbody.group(2));
                sent.setNumotpr(mbody.group(3));
                sent.setDprdm(mbody.group(4));
                sent.setNumvag(mbody.group(5));
                sent.setWeight(mbody.group(6));
                sent.setNumpervedom(mbody.group(7));
                sent.setDmper(mbody.group(8));
                sent.setActualweight(mbody.group(9));
                sent.setCalcweight(mbody.group(10));
                sent.setNumposclassetc(mbody.group(11));
                sent.setFees(mbody.group(12));
                sent.setSborgalabatermez(mbody.group(13));
                sent.setAddsbors(mbody.group(14));
                sent.setAddsbors(mbody.group(15));
                sent.setTotal(mbody.group(16));
                listsmgs.get(listsmgs.size() - 1).getPayerinfo().getListsents().add(sent);
            }
        }
//        System.out.println("leng: " + listsmgs.size());
//        for (Sent sent : listsmgs.get(2).getPayerinfo().getListsents()) {
//            System.out.println(sent.getNumvag());
//        }
        return listsmgs;
    }

    public static void main(String[] args) throws IOException {
        final long startTime = System.nanoTime();
        ReadFileWithRegex rfreg = new ReadFileWithRegex();
        rfreg.setFilepath("F132");
        rfreg.setPattern(PatternTemplate.getPatternTemplate("headerpattern"));
        rfreg.setBodypattern(PatternTemplate.getPatternTemplate("regexpattern"));
//        System.out.println(rfreg.getListSMGS().size());
        ExcelReport exc=new ExcelReport();
        exc.setInput_file("input.xls");
        exc.setOutput_file("output.xls");
//        exc.setListSmgs(rfreg.getListSMGS());
        List<PayerInfo> payerinfos=new ArrayList();
        for(SMGS smgs:rfreg.getListSMGS()){
            payerinfos.add(smgs.getPayerinfo());
        }
        exc.generateReport(payerinfos);
//        exc.generateReport();
        System.out.println("process time: "+TimeUnit.SECONDS.convert((System.nanoTime() - startTime), TimeUnit.NANOSECONDS)+"sec/ "+(System.nanoTime() - startTime)+" nanosec");
//        rfreg.getListSMGS();
    }

}
