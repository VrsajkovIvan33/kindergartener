package com.kindergartener.service;

import com.kindergartener.model.Language;

import java.util.List;

/**
 * Created by Hp on 5/14/2017.
 */

public interface LanguageService {

    Language findById(Long id);

    List<Language> findAll();

    Language save(Language language);

}
