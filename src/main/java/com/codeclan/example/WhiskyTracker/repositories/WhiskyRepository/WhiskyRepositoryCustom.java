package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findWhiskeyByYear(int year);
    List<Whisky> findWhiskyByRegion(String region);
    List<Whisky> findWhiskyViaDistilleryViaAge(String name, int age);
}
