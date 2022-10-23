/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author Electronica
 */
public abstract class Publication {
    
    protected String Bname,Bauthor,Bversion;
    protected int Stock,Time,Bid;
    protected double Bprice;
    protected boolean avilability;

    public Publication(String Bname, String Bauthor, String Bversion, int Stock, int Bid, double Bprice) {
        this.Bname = Bname;
        this.Bauthor = Bauthor;
        this.Bversion = Bversion;
        this.Stock = Stock;
        this.Bid = Bid;
        this.Bprice = Bprice;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public String getBauthor() {
        return Bauthor;
    }

    public void setBauthor(String Bauthor) {
        this.Bauthor = Bauthor;
    }

    public String getBversion() {
        return Bversion;
    }

    public void setBversion(String Bversion) {
        this.Bversion = Bversion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public int getBid() {
        return Bid;
    }

    public void setBid(int Bid) {
        this.Bid = Bid;
    }

    public double getBprice() {
        return Bprice;
    }

    public void setBprice(double Bprice) {
        this.Bprice = Bprice;
    }

    public boolean isAvilability() {
        return avilability;
    }

    public void setAvilability(boolean avilability) {
        this.avilability = avilability;
    }

    
}
