package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/{year}")
    public List<Whisky> findWhiskeyByYear(@PathVariable int year) {
        return whiskyRepository.findWhiskeyByYear(year);
    }

    @GetMapping(value = "/region/{region}")
    public List<Whisky> findWhiskyByRegion(@PathVariable String region) {
        return whiskyRepository.findWhiskyByRegion(region);
    }

    @GetMapping(value = "/{name}/{age}")
    public List<Whisky> findWhiskyViaDistilleryViaAge(@PathVariable String name, @PathVariable int age) {
        return whiskyRepository.findWhiskyViaDistilleryViaAge(name, age);
    }

}
