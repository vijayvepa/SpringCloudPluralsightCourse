package com.example.fastpassservice;

import com.example.fastpassclient.FastPassContract;
import com.example.fastpassclient.FastPassCustomer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class FastPassController implements FastPassContract {
    List<FastPassCustomer> customers = new ArrayList<FastPassCustomer>();

    public FastPassController(){
        customers.add(new FastPassCustomer("100", "Richard Seroter", "555-333-4444", new BigDecimal(12.5)));
        customers.add(new FastPassCustomer("101", "Jason Salmond", "555-333-6666", new BigDecimal(13.5)));
        customers.add(new FastPassCustomer("102", "Lisa Szpunar", "555-333-7777", new BigDecimal(14.5)));
    }

    @RequestMapping(path="/fastpass", params = {"fastpassid"})
    public FastPassCustomer getFastPassById(@RequestParam("fastpassid") String fastPassId){
        Predicate<FastPassCustomer> p = c->c.fastPassId.equals(fastPassId);
        FastPassCustomer customer = customers.stream().filter(p).findFirst().get();

        return customer;
    }

    @RequestMapping(path="/fastpass", params = {"fastpassphone"})
    public FastPassCustomer getFastPassByPhone(@RequestParam("fastpassphone") String fastPassPhone){
        Predicate<FastPassCustomer> p = c->c.fastPassPhone.equals(fastPassPhone);
        FastPassCustomer customer = customers.stream().filter(p).findFirst().get();

        return customer;
    }

}
