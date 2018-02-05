package com.example.fastpassclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "fastpass-service")
public interface FastPassContract {

    @RequestMapping(path="/fastpass", params = {"fastpassid"}, method = RequestMethod.GET)
     FastPassCustomer getFastPassById(@RequestParam("fastpassid") String fastPassId);

    @RequestMapping(path="/fastpass", params = {"fastpassphone"}, method = RequestMethod.GET)
    public FastPassCustomer getFastPassByPhone(@RequestParam("fastpassphone") String fastPassPhone);
}
