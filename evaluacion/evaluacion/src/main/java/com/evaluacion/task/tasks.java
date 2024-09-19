package com.evaluacion.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evaluacion.service.emailService;
import com.evaluacion.service.tareaService;

@Component
public class tasks {
    @Autowired
    private tareaService data;

    @Autowired
    private emailService email;

    

}
