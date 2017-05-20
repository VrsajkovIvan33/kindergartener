package com.kindergartener.service;

import com.kindergartener.model.Justification;
import com.kindergartener.model.JustificationType;

/**
 * Created by Hp on 5/13/2017.
 */

public interface JustificationService {

    Justification findById(Long id);

    Justification save(Justification justification);

    void remove(Long id);

}
