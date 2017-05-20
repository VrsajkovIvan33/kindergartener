/**
 * Created by Hp on 5/12/2017.
 */

angular.module('kindergartenerApp.TeacherController',[])
    .controller('TeacherController', function ($localStorage, $location, $scope, $mdDialog, uiCalendarConfig,
                                               AttendanceFactory, ChildFactory, JustificationFactory) {

        function retrieveAttendancesForGroup() {
            AttendanceFactory.getAttendancesByGroupAndDate($scope.user.group, $scope.dateOfAttendance)
                .success(function (data){
                    $scope.attendances = data;
                    $scope.alreadyMarked = true;
                })
                .error(function (data){
                    $scope.attendances = data;
                    $scope.alreadyMarked = false;
                });
        }

        function generateCalendarEvents(data) {

            $scope.myEvents = data.map(function (key, val, array){
                var calendarEvent = new Object();
                calendarEvent.start =  new Date(key.date);
                calendarEvent.allDay = true;
                calendarEvent.id = key.id;
                if (key.wasPresent) {
                    calendarEvent.title = 'Prisutan/a';
                    calendarEvent.className = 'waspresent';
                }
                else if (key.justification == null || key.justification == undefined) {
                    calendarEvent.title = 'Izostao/la';
                    calendarEvent.className = 'wasntpresent';
                }
                else {
                    calendarEvent.title = 'Opravdano izostao/la';
                    calendarEvent.className = 'justified';
                }
                return calendarEvent;
            });
        }

        function renderEvents() {
            uiCalendarConfig.calendars.myCalendar.fullCalendar('removeEvents');
            uiCalendarConfig.calendars.myCalendar.fullCalendar('addEventSource', $scope.myEvents);
        }

        function retrieveAttendancesForChild(child) {
            AttendanceFactory.getAttendancesByChild(child).success(function (data){
                $scope.childsAttendances = data;
                generateCalendarEvents(data);
                renderEvents();
            });
        }

        function init() {

            if ($localStorage.loggedUser == undefined || $localStorage.loggedUser.userType != 'TEACHER') {
                $location.path('/');
            }

            $scope.user = $localStorage.loggedUser;
            $scope.dateOfAttendance = new Date();
            $scope.alreadyMarked = false;
            $scope.selectedAttendances = new Array();

            retrieveAttendancesForGroup();

            ChildFactory.getChildrenByGroup($scope.user.group).success(function (data){
                $scope.children = data;
                $scope.selectedChild = data[0];
            });
            
            $scope.eventClick = function (date, jsEvent, view){
                var event = $scope.myEvents.filter(function (item, index, array) {
                    return item.id == date.id;
                });
                var attendance = $scope.childsAttendances.filter(function (item, index, array) {
                    return item.id == date.id;
                });
                if (!attendance[0].wasPresent) {
                    var index = $scope.selectedAttendances.indexOf(attendance[0]);
                    if (index == -1) {
                        $scope.selectedAttendances.push(attendance[0]);
                        if (attendance[0].justification == null) {
                            event[0].className = 'wasntpresent-selected';
                        }
                        else {
                            event[0].className = 'justified-selected';
                        }
                    }
                    else {
                        $scope.selectedAttendances.splice(index, 1);
                        if (attendance[0].justification == null) {
                            event[0].className = 'wasntpresent';
                        }
                        else {
                            event[0].className = 'justified';
                        }
                    }
                    renderEvents();
                }
            };

            $scope.uiConfig = {
                calendar: {
                    height: 450,
                    editable: true,
                    header: {
                        left: 'month basicWeek basicDay agendaWeek agendaDay',
                        center: 'title',
                        right: 'today prev, next'
                    },
                    eventClick: $scope.eventClick
                }
            }
        }

        init();

        $scope.dateChanged = function (){
            retrieveAttendancesForGroup();
        };

        $scope.addAttendances = function (){
            AttendanceFactory.addAttendances($scope.attendances).success(function (){
                console.log("Attendances post");
                retrieveAttendancesForGroup();
            })
        };

        $scope.updateAttendances = function (){
            AttendanceFactory.updateAttendances($scope.attendances).success(function (){
                console.log("Attendances put");
                retrieveAttendancesForGroup();
            })
        };

        $scope.setAllWerePresents = function (value){
            var len = $scope.attendances.length;
            for (var i = 0; i < len; i++) {
                $scope.attendances[i].wasPresent = value;
            }
        };

        $scope.switchChild = function (child){
            $scope.selectedChild = child;
            retrieveAttendancesForChild(child);
        };

        $scope.initCalendar = function (){
            uiCalendarConfig.calendars.myCalendar.fullCalendar('render');
            retrieveAttendancesForChild($scope.selectedChild);
        };

        $scope.addJustification = function (ev){
            $mdDialog.show({
                controller: 'JustificationDialogController',
                templateUrl: 'html/justificationDialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:false
            })
                .then(function(justification) {
                    var attendances = $scope.selectedAttendances.map(function (key, val, array){
                        var returnVal = key;
                        returnVal.justification = justification;
                        return returnVal;
                    });
                    JustificationFactory.addJustification(attendances).success(function (data){
                        retrieveAttendancesForChild($scope.selectedChild);
                        $scope.selectedAttendances = new Array();
                    });
                });
        };

        $scope.removeJustification = function (){
            var attendances = $scope.selectedAttendances.map(function (key, val, array){
                var returnVal = key;
                returnVal.justification = undefined;
                return returnVal;
            });
            JustificationFactory.removeJustification(attendances).success(function (data){
                retrieveAttendancesForChild($scope.selectedChild);
                $scope.selectedAttendances = new Array();
            });
        };

        $scope.enableButtons = function (){
            return $scope.selectedAttendances.length == 0;
        };

        $scope.logout = function (){
            $localStorage.loggedUser = undefined;
            $location.path("/");
        };

    })
    .controller('JustificationDialogController', function ($scope, $mdDialog) {

        function init() {

            $scope.justificationTypes = [];
            $scope.justificationTypes.push({
                text: "Bolest",
                type: "SICKNESS"
            });
            $scope.justificationTypes.push({
                text: "Odmor",
                type: "Vacation"
            });
            $scope.justificationTypes.push({
                text: "Porodični razlozi",
                type: "FAMILY_REASONS"
            });
            $scope.justificationTypes.push({
                text: "Ostalo",
                type: "OTHER"
            });

            $scope.newJustification = new Object();
            $scope.newJustification.justificationType = undefined;
            $scope.newJustification.additionalNotes = "";

        }

        init();

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function() {
            $mdDialog.hide($scope.newJustification);
        };

    });