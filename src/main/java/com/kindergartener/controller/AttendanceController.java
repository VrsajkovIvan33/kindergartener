package com.kindergartener.controller;

import com.kindergartener.model.Attendance;
import com.kindergartener.model.Child;
import com.kindergartener.model.Group;
import com.kindergartener.model.SupportedGroup;
import com.kindergartener.service.AttendanceService;
import com.kindergartener.service.ChildService;
import com.kindergartener.service.GroupService;
import com.kindergartener.service.SupportedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ChildService childService;

    @RequestMapping(
            value = "/attendanceByGroup/{id}/{date}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Attendance>> getAttendanceByGroup(@PathVariable(name = "id") Long groupId,
                                                                 @PathVariable(name = "date") String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Group group = groupService.findById(groupId);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        List<Attendance> attendances = attendanceService.findByGroupAndDate(group, date);
        if (!attendances.isEmpty()) {
            return new ResponseEntity<List<Attendance>>(attendances, HttpStatus.OK);
        }
        // no attendances found for the specified date -> initialize attendances and send them as a result
        else {
            List<Child> children = childService.findByGroup(group);
            for (Child child : children) {
                Attendance attendance = new Attendance();
                attendance.setDate(date);
                attendance.setChild(child);
                attendance.setWasPresent(false);
                attendances.add(attendance);
            }
            return new ResponseEntity<List<Attendance>>(attendances, HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @RequestMapping(
            value = "/attendanceByChild/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Attendance>> getAttendanceByChild(@PathVariable(name = "id") Long childId) {

        List<Attendance> attendances = attendanceService.findByChild(childService.findById(childId));
        return new ResponseEntity<List<Attendance>>(attendances, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/attendance",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Attendance>> addAttendances(@RequestBody List<Attendance> newAttendances) {

        List<Attendance> savedAttendances = new ArrayList<>();
        for (Attendance newAttendance : newAttendances) {
            Attendance attendance = new Attendance();
            attendance.setDate(newAttendance.getDate());
            attendance.setChild(newAttendance.getChild());
            attendance.setWasPresent(newAttendance.getWasPresent());
            savedAttendances.add(attendanceService.save(attendance));
        }
        return new ResponseEntity<List<Attendance>>(savedAttendances, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/attendance",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public  ResponseEntity<List<Attendance>> updateAttendances(@RequestBody List<Attendance> updatedAttendances) {

        List<Attendance> savedAttendances = new ArrayList<>();
        for (Attendance updatedAttendance : updatedAttendances) {
            Attendance attendance = attendanceService.findById(updatedAttendance.getId());
            attendance.setWasPresent(updatedAttendance.getWasPresent());
            if (!attendance.getWasPresent()) {
                attendance.setJustification(null);
            }
            savedAttendances.add(attendanceService.save(attendance));
        }
        return new ResponseEntity<List<Attendance>>(savedAttendances, HttpStatus.OK);
    }
}
