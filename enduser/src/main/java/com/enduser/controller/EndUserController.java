package com.enduser.controller;

import com.enduser.service.EnduserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endUser")
public class EndUserController {

    @Autowired
    public  EnduserService enduserService;

    @GetMapping("getLocation")
    public List<String> getLocation()
    {
        return enduserService.getReceivedMessages();
    }
}
