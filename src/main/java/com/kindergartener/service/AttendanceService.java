package com.kindergartener.service;

import com.kindergartener.model.Attendance;
import com.kindergartener.model.Child;
import com.kindergartener.model.Group;
import com.kindergartener.model.Justification;

import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

public interface AttendanceService {

    Attendance findById(Long id);

    List<Attendance> findByGroupAndDate(Group group, Date date);

    List<Attendance> findByChild(Child child);

    List<Attendance> findByJustification(Justification justification);

    Long countByChildAndDateBetween(Child child, Date startDate, Date endDate);

    Long countByChildAndDateBetweenAndAbsenceJustified(Child child, Date startDate, Date endDate);

    Attendance save(Attendance attendance);

}
