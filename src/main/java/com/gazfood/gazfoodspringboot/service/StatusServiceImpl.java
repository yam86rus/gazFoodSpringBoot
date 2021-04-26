package com.gazfood.gazfoodspringboot.service;


import com.gazfood.gazfoodspringboot.dao.StatusRepository;
import com.gazfood.gazfoodspringboot.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatuses() {
        List<Status> allStatuses = statusRepository.findAll();
        return allStatuses;
    }

    @Override
    public void saveStatus(Status status) {
        statusRepository.save(status);
    }

    @Override
    public Status getStatus(int id) {
        Status status = null;
        Optional<Status> optional = statusRepository.findById(id);
        if (optional.isPresent()) {
            status = optional.get();
        }
        return status;
    }

    @Override
    public void deleteStatus(int id) {
        statusRepository.deleteById(id);
    }

    @Override
    public long getCountStatuses() {
        return statusRepository.count();
    }


}
