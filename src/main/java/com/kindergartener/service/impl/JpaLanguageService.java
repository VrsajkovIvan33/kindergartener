package com.kindergartener.service.impl;

import com.kindergartener.model.Language;
import com.kindergartener.repository.LanguageRepository;
import com.kindergartener.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/14/2017.
 */

@Service
@Transactional
public class JpaLanguageService implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language findById(Long id) {
        return languageRepository.findById(id);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }
}
