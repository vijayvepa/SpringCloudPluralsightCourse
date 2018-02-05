package com.example.fastpassclient;

import java.math.BigDecimal;

public class FastPassCustomer {
    public String fastPassId;
    public String customerFullName;
    public String fastPassPhone;
    public BigDecimal currentBalance;


    @SuppressWarnings("unused")
    public FastPassCustomer(){
        //constructor for deserialization
    }

    public FastPassCustomer(String fastPassId, String customerFullName, String fastPassPhone, BigDecimal currentBalance){
        this.fastPassId = fastPassId;
        this.customerFullName = customerFullName;
        this.fastPassPhone = fastPassPhone;
        this.currentBalance = currentBalance;
    }
}
