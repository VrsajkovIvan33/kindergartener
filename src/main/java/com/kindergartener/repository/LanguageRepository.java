package com.kindergartener.repository;

import com.kindergartener.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/14/2017.
 */

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findById(Long id);

    List<Language> findAll();

}
