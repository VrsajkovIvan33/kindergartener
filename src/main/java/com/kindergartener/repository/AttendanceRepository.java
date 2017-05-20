package com.kindergartener.repository;

import com.kindergartener.model.Attendance;
import com.kindergartener.model.Child;
import com.kindergartener.model.Group;
import com.kindergartener.model.Justification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Attendance findById(Long id);

    @Query("SELECT a FROM Attendance a WHERE a.child.supportedGroup.group = ?1 AND a.date = ?2")
    List<Attendance> findByGroupAndDate(Group group, Date date);

    List<Attendance> findByChild(Child child);

    List<Attendance> findByJustification(Justification justification);

    Long countByChildAndDateBetween(Child child, Date startDate, Date endDate);

    Long countByChildAndDateBetweenAndWasPresentAndJustificationNotNull(Child child, Date startDate, Date endDate,
                                                                            Boolean wasPresent);

}
