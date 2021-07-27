package com.example.retrofitapicalls.model;

public class Data {

    //value
    private int userId;
    private int id;
    private String title;
    /*
    @SerializedName("completed")
    private boolean status;
    */
    private boolean completed;

    //getters
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
    //no need setters because we dont set data
}
