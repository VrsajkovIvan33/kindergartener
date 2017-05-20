package com.kindergartener.service.impl;

import com.kindergartener.model.Category;
import com.kindergartener.model.Institution;
import com.kindergartener.model.Pricelist;
import com.kindergartener.model.WorkType;
import com.kindergartener.repository.PricelistRepository;
import com.kindergartener.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/15/2017.
 */

@Service
@Transactional
public class JpaPricelistService implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public Pricelist findById(Long id) {
        return pricelistRepository.findById(id);
    }

    @Override
    public List<Pricelist> findCurrentByCategoryAndInstitution(Category category, Institution institution) {
        return pricelistRepository.findByCategoryAndInstitutionAndUntilDate(category, institution, null);
    }

    @Override
    public Pricelist save(Pricelist pricelist) {
        return pricelistRepository.save(pricelist);
    }
}
