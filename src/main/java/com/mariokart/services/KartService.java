package com.mariokart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariokart.dto.KartRequest;
import com.mariokart.entities.Kart;
import com.mariokart.entities.KartType;
import com.mariokart.repositories.KartRepository;
import com.mariokart.repositories.KartTypeRepository;

@Service
public class KartService {

    @Autowired
    private KartRepository kartRepository;

    @Autowired
    private KartTypeRepository kartTypeRepository;

    public Kart addKart(KartRequest request) {

        // find the kart type by ID
        KartType karttype = kartTypeRepository.findById(request.getKartTypeId())
                .orElseThrow(() -> new RuntimeException("Kart type not found"));

        // create the kart
        Kart kart = new Kart();
        kart.setSlug(request.getSlug());
        kart.setName(request.getName());
        kart.setDescription(request.getDescription());
        kart.setKartType(karttype);

        return kartRepository.save(kart);

    }

}
