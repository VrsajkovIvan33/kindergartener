package com.kindergartener.service.impl;

import com.kindergartener.model.Shift;
import com.kindergartener.repository.ShiftRepository;
import com.kindergartener.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaShiftService implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> findAll() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift findById(Long id) {
        return shiftRepository.findById(id);
    }

    @Override
    public List<Shift> findByStartTimeAndEndTime(String startTime, String endTime) {
        return shiftRepository.findByStartTimeAndEndTime(startTime, endTime);
    }

    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }
}
