package com.kindergartener.controller;

import com.kindergartener.model.Attendance;
import com.kindergartener.model.Justification;
import com.kindergartener.service.AttendanceService;
import com.kindergartener.service.JustificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 5/13/2017.
 */

@RestController
public class JustificationController {

    @Autowired
    private JustificationService justificationService;

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(
            value = "/justification",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Attendance>> addJustification(@RequestBody List<Attendance> updatedAttendances) {

        if (!updatedAttendances.isEmpty()) {
            Justification justification = new Justification();
            justification.setJustificationType(updatedAttendances.get(0).getJustification().getJustificationType());
            justification.setAdditionalNotes(updatedAttendances.get(0).getJustification().getAdditionalNotes());
            Justification newJustification = justificationService.save(justification);

            // set the new value as the justification for all attendances and save the IDs of the previous justifications
            List<Attendance> savedAttendances = new ArrayList<>();
            List<Long> justificationIds = new ArrayList<>();
            for (Attendance updatedAttendance : updatedAttendances) {
                Attendance attendance = attendanceService.findById(updatedAttendance.getId());
                if (attendance.getJustification() != null && !justificationIds.contains(attendance.getJustification().getId())) {
                    justificationIds.add(attendance.getJustification().getId());
                }
                attendance.setJustification(newJustification);
                savedAttendances.add(attendanceService.save(attendance));
            }

            // check if any of the previous justifications is now not connected to any attendance, it it isn't -> remove it
            for (Long id : justificationIds) {
                List<Attendance> remainingAttendances = attendanceService.findByJustification(
                        justificationService.findById(id));
                if (remainingAttendances.isEmpty()) {
                    justificationService.remove(id);
                }
            }

            return new ResponseEntity<List<Attendance>>(savedAttendances, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(
            value = "/justification",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Attendance>> removeJustification(@RequestBody List<Attendance> updatedAttendances) {

        List<Attendance> savedAttendances = new ArrayList<>();
        List<Long> justificationIds = new ArrayList<>();

        // set null as the justification for all specified attendances and save the justification IDs
        for (Attendance updatedAttendance : updatedAttendances) {
            Attendance attendance = attendanceService.findById(updatedAttendance.getId());
            if (attendance.getJustification() != null) {
                if (!justificationIds.contains(attendance.getJustification().getId())) {
                    justificationIds.add(attendance.getJustification().getId());
                }
                attendance.setJustification(null);
                savedAttendances.add(attendanceService.save(attendance));
            }
        }

        // if a justification is not connected to any attendance, remove it
        for (Long id : justificationIds) {
            List<Attendance> remainingAttendances = attendanceService.findByJustification(
                    justificationService.findById(id));
            if (remainingAttendances.isEmpty()) {
                justificationService.remove(id);
            }
        }

        return new ResponseEntity<List<Attendance>>(savedAttendances, HttpStatus.OK);
    }

}
