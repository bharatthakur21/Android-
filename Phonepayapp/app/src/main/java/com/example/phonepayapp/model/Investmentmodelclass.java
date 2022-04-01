package com.example.phonepayapp.model;

public class Investmentmodelclass {


    int bankimage;
    String bankname;
    String bankqualityvalue;

    public Investmentmodelclass(int bankimage, String bankname, String bankqualityvalue, String bankreturn, String banklreturnpersent, String bankreturndate, String bankminamount) {
        this.bankimage = bankimage;
        this.bankname = bankname;
        this.bankqualityvalue = bankqualityvalue;
        this.bankreturn = bankreturn;
        this.banklreturnpersent = banklreturnpersent;
        this.bankreturndate = bankreturndate;
        this.bankminamount = bankminamount;

    }

    String bankreturn;
    String banklreturnpersent;

    public int getBankimage() {
        return bankimage;
    }

    public void setBankimage(int bankimage) {
        this.bankimage = bankimage;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankqualityvalue() {
        return bankqualityvalue;
    }

    public void setBankqualityvalue(String bankqualityvalue) {
        this.bankqualityvalue = bankqualityvalue;
    }

    public String getBankreturn() {
        return bankreturn;
    }

    public void setBankreturn(String bankreturn) {
        this.bankreturn = bankreturn;
    }

    public String getBanklreturnpersent() {
        return banklreturnpersent;
    }

    public void setBanklreturnpersent(String banklreturnpersent) {
        this.banklreturnpersent = banklreturnpersent;
    }

    public String getBankreturndate() {
        return bankreturndate;
    }

    public void setBankreturndate(String bankreturndate) {
        this.bankreturndate = bankreturndate;
    }

    public String getBankminamount() {
        return bankminamount;
    }

    public void setBankminamount(String bankminamount) {
        this.bankminamount = bankminamount;
    }

    String bankreturndate;
    String bankminamount;




}
