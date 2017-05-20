package com.kindergartener.service.impl;

import com.kindergartener.model.Justification;
import com.kindergartener.model.JustificationType;
import com.kindergartener.repository.JustificationRepository;
import com.kindergartener.service.JustificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hp on 5/13/2017.
 */

@Service
@Transactional
public class JpaJustificationService implements JustificationService {

    @Autowired
    private JustificationRepository justificationRepository;

    @Override
    public Justification findById(Long id) {
        return justificationRepository.findById(id);
    }

    @Override
    public Justification save(Justification justification) {
        return justificationRepository.save(justification);
    }

    @Override
    public void remove(Long id) {
        justificationRepository.delete(id);
    }
}
