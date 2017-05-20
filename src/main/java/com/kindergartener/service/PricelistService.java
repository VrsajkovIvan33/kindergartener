package com.kindergartener.service;

import com.kindergartener.model.Category;
import com.kindergartener.model.Institution;
import com.kindergartener.model.Pricelist;
import com.kindergartener.model.WorkType;

import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/15/2017.
 */

public interface PricelistService {

    Pricelist findById(Long id);

    List<Pricelist> findCurrentByCategoryAndInstitution(Category category, Institution institution);

    Pricelist save(Pricelist pricelist);

}
