package com.kindergartener.service;

import com.kindergartener.model.Institution;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface InstitutionService {

    Institution findById(Long id);

    List<Institution> findByName(String name);

    Institution save(Institution institution);
}
