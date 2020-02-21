package com.spintech.testtask.service.impl;

import com.spintech.testtask.repository.ShowRepository;
import com.spintech.testtask.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;
}
