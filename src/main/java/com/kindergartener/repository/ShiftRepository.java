package com.kindergartener.repository;

import com.kindergartener.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {

    Shift findById(Long id);

    List<Shift> findByStartTimeAndEndTime(String startTime, String endTime);
}
