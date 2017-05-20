package com.kindergartener.service;

import com.kindergartener.model.Shift;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface ShiftService {

    List<Shift> findAll();

    Shift findById(Long id);

    List<Shift> findByStartTimeAndEndTime(String startTime, String endTime);

    Shift save(Shift shift);
}
