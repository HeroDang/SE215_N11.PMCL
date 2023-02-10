package vn.uit.dhomestay.models;

import java.io.Serializable;

public class HomestayModel implements Serializable {
    private String name;
    private int numStar;
    private int numComt;
    private int price;

    public HomestayModel(String name, int numStar, int numComt, int price) {
        this.name = name;
        this.numStar = numStar;
        this.numComt = numComt;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumStar() {
        return numStar;
    }

    public void setNumStar(int numStar) {
        this.numStar = numStar;
    }

    public int getNumComt() {
        return numComt;
    }

    public void setNumComt(int numComt) {
        this.numComt = numComt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
