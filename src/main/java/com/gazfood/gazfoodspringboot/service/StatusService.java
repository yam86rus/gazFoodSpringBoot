package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatuses();

    void saveStatus(Status status);

    Status getStatus(int id);

    void deleteStatus(int id);

    long getCountStatuses();
}