package com.kindergartener.repository;

import com.kindergartener.model.Category;
import com.kindergartener.model.Institution;
import com.kindergartener.model.Pricelist;
import com.kindergartener.model.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/15/2017.
 */

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

    Pricelist findById(Long id);

    List<Pricelist> findByCategoryAndInstitutionAndUntilDate(Category category, Institution institution, Date untilDate);

}
