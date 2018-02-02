/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author LapasovFG.VCRP
 */
public class PayerInfo {
    
    private int dorogasost;

    private String dotpnaz;

    private String payernum;

    private int tarif;

    private String repmonth;

    private String iskltarif;

    private String pog_vxod_stan;

    private String lengthiness;

    private List<Sent> listsents;

    /**
     * Get the value of listsents
     *
     * @return the value of listsents
     */
    public List<Sent> getListsents() {
        return listsents;
    }

    /**
     * Set the value of listsents
     *
     * @param listsents new value of listsents
     */
    public void setListsents(List<Sent> listsents) {
        this.listsents = listsents;
    }

    /**
     * Get the value of lengthiness
     *
     * @return the value of lengthiness
     */
    public String getLengthiness() {
        return lengthiness;
    }

    /**
     * Set the value of lengthiness
     *
     * @param lengthiness new value of lengthiness
     */
    public void setLengthiness(String lengthiness) {
        this.lengthiness = lengthiness;
    }

    /**
     * Get the value of pog_vxod_stan
     *
     * @return the value of pog_vxod_stan
     */
    public String getPog_vxod_stan() {
        return pog_vxod_stan;
    }

    /**
     * Set the value of pog_vxod_stan
     *
     * @param pog_vxod_stan new value of pog_vxod_stan
     */
    public void setPog_vxod_stan(String pog_vxod_stan) {
        this.pog_vxod_stan = pog_vxod_stan;
    }

    /**
     * Get the value of iskltarif
     *
     * @return the value of iskltarif
     */
    public String getIskltarif() {
        return iskltarif;
    }

    /**
     * Set the value of iskltarif
     *
     * @param iskltarif new value of iskltarif
     */
    public void setIskltarif(String iskltarif) {
        this.iskltarif = iskltarif;
    }

    /**
     * Get the value of repmonth
     *
     * @return the value of repmonth
     */
    public String getRepmonth() {
        return repmonth;
    }

    /**
     * Set the value of repmonth
     *
     * @param repmonth new value of repmonth
     */
    public void setRepmonth(String repmonth) {
        this.repmonth = repmonth;
    }

    /**
     * Get the value of tarif
     *
     * @return the value of tarif
     */
    public int getTarif() {
        return tarif;
    }

    /**
     * Set the value of tarif
     *
     * @param tarif new value of tarif
     */
    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    /**
     * Get the value of payernum
     *
     * @return the value of payernum
     */
    public String getPayernum() {
        return payernum;
    }

    /**
     * Set the value of payernum
     *
     * @param payernum new value of payernum
     */
    public void setPayernum(String payernum) {
        this.payernum = payernum;
    }

    /**
     * Get the value of dotpnaz
     *
     * @return the value of dotpnaz
     */
    public String getDotpnaz() {
        return dotpnaz;
    }

    /**
     * Set the value of dotpnaz
     *
     * @param dotpnaz new value of dotpnaz
     */
    public void setDotpnaz(String dotpnaz) {
        this.dotpnaz = dotpnaz;
    }

    /**
     * Get the value of dorogasost
     *
     * @return the value of dorogasost
     */
    public int getDorogasost() {
        return dorogasost;
    }

    /**
     * Set the value of dorogasost
     *
     * @param dorogasost new value of dorogasost
     */
    public void setDorogasost(int dorogasost) {
        this.dorogasost = dorogasost;
    }

    
}
