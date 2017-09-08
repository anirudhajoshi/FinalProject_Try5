package com.example.aniru.myapplication.backend;
import com.example.MyJokes;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    private MyJokes jokes;

    JokeBean(){ jokes = new MyJokes();}

    public String getJoke(){
        return jokes.tellJoke();
    }

}