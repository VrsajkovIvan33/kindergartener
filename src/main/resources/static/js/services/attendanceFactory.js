/**
 * Created by Hp on 5/13/2017.
 */

angular.module('kidnergardenerApp.AttendanceFactory', [])
    .factory('AttendanceFactory', function($http){

        var factory = {};

        factory.getAttendancesByGroupAndDate = function (group, date){
            var dateString = '' + date.getDate() + '-' + (date.getMonth()+1) + '-' + date.getFullYear();
            return $http.get('/attendanceByGroup/' + group.id + '/' + dateString);
        };

        factory.getAttendancesByChild = function (child){
            return $http.get('/attendanceByChild/' + child.id);
        };

        factory.addAttendances = function (attendances){
            return $http.post('/attendance', attendances);
        };

        factory.updateAttendances = function (attendances){
            return $http.put('/attendance', attendances);
        };

        return factory;

    });
