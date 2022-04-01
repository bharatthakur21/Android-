package com.example.phonepayapp.model;

public class Historymodeldataclass {
    int historyimg;
    String paidto;
    String paidamount;
    String paidloaction;
    String paidtime;
    String creditto;

    public Historymodeldataclass() {
    }

    public int getHistoryimg() {
        return historyimg;
    }

    public void setHistoryimg(int historyimg) {
        this.historyimg = historyimg;
    }

    public String getPaidto() {
        return paidto;
    }

    public void setPaidto(String paidto) {
        this.paidto = paidto;
    }

    public String getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(String paidamount) {
        this.paidamount = paidamount;
    }

    public String getPaidloaction() {
        return paidloaction;
    }

    public void setPaidloaction(String paidloaction) {
        this.paidloaction = paidloaction;
    }

    public String getPaidtime() {
        return paidtime;
    }

    public void setPaidtime(String paidtime) {
        this.paidtime = paidtime;
    }

    public String getCreditto() {
        return creditto;
    }

    public void setCreditto(String creditto) {
        this.creditto = creditto;
    }

    public Historymodeldataclass(int historyimg, String paidto, String paidamount, String paidloaction, String paidtime, String creditto) {
        this.historyimg = historyimg;
        this.paidto = paidto;
        this.paidamount = paidamount;
        this.paidloaction = paidloaction;
        this.paidtime = paidtime;
        this.creditto = creditto;
    }

}
