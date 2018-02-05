package com.example.fastpassconsole;

import com.example.fastpassclient.FastPassContract;
import com.example.fastpassclient.FastPassCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FastPassWebController {

    @Autowired
    public FastPassContract fastPassContract;

    @RequestMapping(path = "/customerdetails", params = {"fastpassid"})
    public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {

        FastPassCustomer customer = fastPassContract.getFastPassById(fastpassid);
        m.addAttribute("customer", customer);

        return "console";
    }

}
