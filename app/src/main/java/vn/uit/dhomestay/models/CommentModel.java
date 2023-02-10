package vn.uit.dhomestay.models;

import java.io.Serializable;

public class CommentModel implements Serializable {
    private String name;
    private int numStar;
    private String day;
    private String comment;

    public CommentModel(String name, int numStar, String day, String comment) {
        this.name = name;
        this.numStar = numStar;
        this.day = day;
        this.comment = comment;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
