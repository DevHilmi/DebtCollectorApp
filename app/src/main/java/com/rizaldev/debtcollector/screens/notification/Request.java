package com.rizaldev.debtcollector.screens.notification;

/**
 * Created by devel on 5/12/2017.
 */

public class Request {

    private String name;

    private String debt;



    public Request(String name, String debt){

        this.name = name;


        this.debt = debt;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getName() {

        return name;

    }



    public String getDebt() {

        return debt;

    }

}