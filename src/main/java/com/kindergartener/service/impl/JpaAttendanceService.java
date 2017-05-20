package com.kindergartener.service.impl;

import com.kindergartener.model.Attendance;
import com.kindergartener.model.Child;
import com.kindergartener.model.Group;
import com.kindergartener.model.Justification;
import com.kindergartener.repository.AttendanceRepository;
import com.kindergartener.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

@Service
@Transactional
public class JpaAttendanceService implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance findById(Long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> findByGroupAndDate(Group group, Date date) {
        return attendanceRepository.findByGroupAndDate(group, date);
    }

    @Override
    public List<Attendance> findByChild(Child child) {
        return attendanceRepository.findByChild(child);
    }

    @Override
    public List<Attendance> findByJustification(Justification justification) {
        return attendanceRepository.findByJustification(justification);
    }

    @Override
    public Long countByChildAndDateBetween(Child child, Date startDate, Date endDate) {
        return attendanceRepository.countByChildAndDateBetween(child, startDate, endDate);
    }

    @Override
    public Long countByChildAndDateBetweenAndAbsenceJustified(Child child, Date startDate, Date endDate) {
        return attendanceRepository.countByChildAndDateBetweenAndWasPresentAndJustificationNotNull(child, startDate,
                endDate, false);
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}
