/**
 * Created by Hp on 4/30/2017.
 */

angular.module('kindergartenerApp.LoginController',[])
    .controller('LoginController', function ($localStorage, $scope, $location, LoginFactory, TeacherFactory) {

        function init() {
            $scope.user = new Object();
            $scope.user.username = "";
            $scope.user.password = "";
        }

        init();

        $scope.login = function(){
            LoginFactory.login($scope.user)
                .success(function(data) {
                    $localStorage.loggedUser = data;
                    console.log("Log in successfull!");
                    if (data.userType == 'ADMIN') {
                        $location.path('/admin');
                    }
                    else if (data.userType == 'TEACHER') {
                        TeacherFactory.getTeacher($localStorage.loggedUser).success(function (data){
                            $localStorage.loggedUser = data;
                            $location.path('/teacher');
                        })
                    }
                    else if (data.userType == 'ACCOUNTANT') {
                        $location.path('/accountant');
                    }
                })
                .error(function(data){
                    alert("Pogrešna kombinacija korisničkog imena i lozinke!");
                });
        };

    });
