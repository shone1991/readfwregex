/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelexport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.PayerInfo;
import model.SMGS;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

/**
 *
 * @author LapasovFG.VCRP
 */
public class ExcelReport {

    private String input_file;

    private String output_file;

    private List<SMGS> smgslists;

    /**
     * Get the value of smgslist
     *
     * @return the value of smgslist
     */
    public List<SMGS> getListSmgs() {
        return smgslists;
    }

    /**
     * Set the value of smgslist
     *
     * @param string new value of smgslist
     */
    public void setListSmgs(List<SMGS> string) {
        this.smgslists = string;
    }

    /**
     * Get the value of output_file
     *
     * @return the value of output_file
     */
    public String getOutput_file() {
        return output_file;
    }

    /**
     * Set the value of output_file
     *
     * @param output_file new value of output_file
     */
    public void setOutput_file(String output_file) {
        this.output_file = output_file;
    }

    /**
     * Get the value of input_file
     *
     * @return the value of input_file
     */
    public String getInput_file() {
        return input_file;
    }

    /**
     * Set the value of input_file
     *
     * @param input_file new value of input_file
     */
    public void setInput_file(String input_file) {
        this.input_file = input_file;
    }

    public void generateReport() throws IOException {
        try (InputStream is = Files.newInputStream(Paths.get(input_file));) {
            try (OutputStream os = new FileOutputStream(output_file)) {
                Context context = new Context();
                context.putVar("smgslists", smgslists);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            } catch (FileNotFoundException ex) {
//                Logger.getLogger(JavaJxlsExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void generateReport(List<PayerInfo> payerinfos) throws IOException {
        try (InputStream is = Files.newInputStream(Paths.get(input_file));) {
            try (OutputStream os = new FileOutputStream(output_file)) {
                Context context = new Context();
                context.putVar("payerinfos", payerinfos);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            } catch (FileNotFoundException ex) {
//                Logger.getLogger(JavaJxlsExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
