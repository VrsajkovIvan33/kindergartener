/**
 * Created by Hp on 5/6/2017.
 */

angular.module('kindergartenerApp.AdminController',[])
    .controller('AdminController', function ($localStorage, $location, $scope, $mdSidenav, $mdDialog, ChildFactory) {
        function init(){

            if ($localStorage.loggedUser == undefined || $localStorage.loggedUser.userType != 'ADMIN') {
                $location.path('/');
            }

            $scope.user = $localStorage.loggedUser;

            ChildFactory.getChildrenByInstitution($scope.user).success(function (data){
                $scope.children = data;
                $scope.selectedChild = data[0];
            });
        }

        init();

        $scope.switchChild = function (child){
            $scope.selectedChild = child;
        };

        $scope.openAddChildDialog = function (ev){
            $mdDialog.show({
                controller: 'AddChildDialogController',
                templateUrl: 'html/childDialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:false
            })
                .then(function(child) {
                    ChildFactory.addChild(child)
                        .success(function (data) {
                            $scope.selectedChild = data;
                            ChildFactory.getChildrenByInstitution($scope.user).success(function (data){
                                $scope.children = data;
                            });
                        })
                        .error(function (data){
                            alert("Dodavanje novog deteta neuspešno!")
                        });
                });
        };

        $scope.openUpdateChildDialog = function (ev){
            $mdDialog.show({
                controller: 'UpdateChildDialogController',
                templateUrl: 'html/childDialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:false,
                locals: {
                    childToUpdate: $scope.selectedChild
                }
            })
                .then(function(child) {
                    ChildFactory.updateChild(child)
                        .success(function (data) {
                            $scope.selectedChild = data;
                            ChildFactory.getChildrenByInstitution($scope.user).success(function (data){
                                $scope.children = data;
                            });
                        })
                        .error(function (data){
                            alert("Ažuriranje deteta neuspešno!")
                        });
                });
        };

        $scope.removeChild = function (){
            ChildFactory.removeChild($scope.selectedChild)
                .success(function (data) {
                    ChildFactory.getChildrenByInstitution($scope.user).success(function (data){
                        $scope.children = data;
                        $scope.selectedChild = data[0];
                    });
                })
                .error(function (data){
                    alert('Brisanje nije uspešno obavljeno!');
                });
        };

        $scope.logout = function (){
            $localStorage.loggedUser = undefined;
            $location.path("/");
        };

    })
    .controller('AddChildDialogController', function ($scope, $mdDialog, $localStorage, UserFactory, CategoryFactory,
                                                   AgeGroupFactory, SupportedGroupFactory, LanguageFactory) {
        function init() {

            $scope.user = $localStorage.loggedUser;
            $scope.suppGroupDisabled = true;
            $scope.supportedGroups = null;

            UserFactory.getParents($scope.user.institution).success(function (data){
                $scope.parents1 = data;
                $scope.parents2 = $scope.parents1.slice();
                $scope.parents2.unshift(null);
            });

            AgeGroupFactory.getAgeGroups().success(function (data) {
                $scope.ageGroups = data;
            });

            LanguageFactory.getLanguages().success(function (data){
                $scope.languages = data;
            });

            $scope.isAdd = true;

            $scope.tempChild = null;
            $scope.tempChild = new Object();
            $scope.tempChild.name = "";
            $scope.tempChild.surname = "";
            $scope.tempChild.dateOfBirth = null;
            $scope.tempChild.placeOfBirth = "";
            $scope.tempChild.jmbg = "";
            $scope.tempChild.address = "";
            $scope.tempChild.phoneNumber = "";
            $scope.tempChild.ageGroup = null;
            $scope.tempChild.nativeLanguage = null;
            $scope.tempChild.parent1 = null;
            $scope.tempChild.parent2 = null;
            $scope.tempChild.category = null;
            $scope.tempChild.supportedGroup = null;
            $scope.tempChild.institution = $scope.user.institution;

            $scope.tempCategory = null;
            $scope.tempCategory = new Object();
            $scope.tempCategory.parentNumber = null;
            $scope.tempCategory.familyMembersNumber = null;
            $scope.tempCategory.childrenNumber = null;
            $scope.tempCategory.orderNumber = null;
            $scope.tempCategory.specialNeeds = false;

            $scope.categoryIsDefault = false;
        }

        init();

        $scope.findSuppGroups = function (){
            if ($scope.tempChild.ageGroup != null && $scope.tempChild.nativeLanguage != null) {
                SupportedGroupFactory.getSuitableSupportedGroups($scope.tempChild.ageGroup, $scope.tempChild.nativeLanguage,
                    $scope.user.institution).success(function (data){
                    $scope.supportedGroups = data;
                    if (data.length == 0) {
                        $scope.suppGroupDisabled = true;
                        $scope.tempChild.supportedGroup = null;
                    }
                    else {
                        $scope.suppGroupDisabled = false;
                    }
                });
            }
        };

        $scope.findSuitableCategory = function (){
            CategoryFactory.findSuitable($scope.tempCategory)
                .success(function (data){
                    $scope.categoryIsDefault = false;
                    $scope.tempChild.category = data;
                })
                .error(function (data){
                    $scope.categoryIsDefault = true;
                    CategoryFactory.getDefault().success(function (data){
                        $scope.tempChild.category = data;
                    })
                });
        };

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function() {
            $mdDialog.hide($scope.tempChild);
        };
    })
    .controller('UpdateChildDialogController', function ($scope, childToUpdate, $mdDialog, $localStorage, UserFactory,
                                                         CategoryFactory, AgeGroupFactory, SupportedGroupFactory,
                                                         LanguageFactory) {
        function init() {

            $scope.user = $localStorage.loggedUser;
            $scope.tempChild = childToUpdate;

            $scope.tempCategory = null;
            $scope.tempCategory = new Object();
            $scope.tempCategory.parentNumber = null;
            $scope.tempCategory.familyMembersNumber = null;
            $scope.tempCategory.childrenNumber = null;
            $scope.tempCategory.orderNumber = null;
            $scope.tempCategory.specialNeeds = false;

            $scope.categoryIsDefault = false;

            $scope.suppGroupDisabled = true;
            $scope.supportedGroups = null;

            UserFactory.getParents($scope.user.institution).success(function (data){
                $scope.parents1 = data;
                $scope.parents2 = $scope.parents1.slice();
                $scope.parents2.unshift(null);
            });

            AgeGroupFactory.getAgeGroups().success(function (data) {
                $scope.ageGroups = data;
            });

            LanguageFactory.getLanguages().success(function (data){
                $scope.languages = data;
            });

            $scope.isAdd = false;

        }

        $scope.findSuppGroups = function (){
            if ($scope.tempChild.ageGroup != null && $scope.tempChild.nativeLanguage != null) {
                SupportedGroupFactory.getSuitableSupportedGroups($scope.tempChild.ageGroup, $scope.tempChild.nativeLanguage,
                    $scope.user.institution).success(function (data){
                    $scope.supportedGroups = data;
                    if (data.length == 0) {
                        $scope.suppGroupDisabled = true;
                        $scope.tempChild.supportedGroup = null;
                    }
                    else {
                        $scope.suppGroupDisabled = false;
                    }
                });
            }
        };

        $scope.findSuitableCategory = function (){
            CategoryFactory.findSuitable($scope.tempCategory)
                .success(function (data){
                    $scope.categoryIsDefault = false;
                    $scope.tempChild.category = data;
                })
                .error(function (data){
                    $scope.categoryIsDefault = true;
                    CategoryFactory.getDefault().success(function (data){
                        $scope.tempChild.category = data;
                    })
                });
        };

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function() {
            $mdDialog.hide($scope.tempChild);
        };

        init();

        $scope.findSuppGroups();

    });
