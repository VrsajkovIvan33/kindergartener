/**
 * Created by Hp on 5/18/2017.
 */

angular.module('kindergartenerApp.AccountantController',[])
    .controller('AccountantController', function ($localStorage, $location, $scope, $mdDialog, ChildFactory,
                                                  PaymentFactory, DebitFactory) {
        
        function init(){

            if ($localStorage.loggedUser == undefined || $localStorage.loggedUser.userType != 'ACCOUNTANT') {
                $location.path('/');
            }

            $scope.user = $localStorage.loggedUser;
            $scope.selectedChildForPayments = undefined;
            $scope.selectedMonthForPayments = 0;
            $scope.selectedYearForPayments = new Date().getFullYear();
            $scope.selectedYearForDebit = new Date().getFullYear();
            $scope.selectedMonthlyDebit = undefined;
            
            $scope.getPayments();

            ChildFactory.getChildrenByInstitution($scope.user).success(function (data){
                $scope.childrenForPayments = data;
                $scope.childrenForDebit = data.slice();
                $scope.childrenForPayments.unshift(undefined);
                $scope.selectedChildForDebit = $scope.childrenForDebit[0];
                $scope.getTotalDebit();
            });

            $scope.monthNames = ['Svi', 'Januar', 'Februar', 'Mart', 'April', 'Maj', 'Jun',
                'Jul', 'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar'];
            $scope.monthsForPayments = $scope.monthNames.map(function (key, val, array){
                return {
                    name: key,
                    orderOf: val
                };
            });

            $scope.paymentTypes = new Array();
            $scope.paymentTypes.push({
                name: 'Direktni',
                type: 'DIRECT'
            });
            $scope.paymentTypes.push({
                name: 'Preko posrednika',
                type: 'THROUGH_INTERMEDIARIES'
            });
        }

        $scope.getPayments = function (){

            if ($scope.selectedChildForPayments == undefined) {
                PaymentFactory.getPaymentsByInstitution($scope.user.institution, $scope.selectedMonthForPayments,
                    $scope.selectedYearForPayments).success(function (data){
                    $scope.payments = data;
                    if (data != undefined && data.length > 0) {
                        $scope.selectedPayment = data[0];
                    }
                });
            }
            else {
                PaymentFactory.getPaymentsByChild($scope.selectedChildForPayments, $scope.selectedMonthForPayments,
                    $scope.selectedYearForPayments).success(function (data){
                    $scope.payments = data;
                    if (data != undefined && data.length > 0) {
                        $scope.selectedPayment = data[0];
                    }
                    else {
                        $scope.selectedPayment = undefined;
                    }
                });
            }
        };

        $scope.getTotalDebit = function (){
            DebitFactory.calculateDebit($scope.selectedChildForDebit, $scope.selectedYearForDebit).success(function (data){
                $scope.totalDebit = data;
                if (data.debits != undefined && data.debits.length > 0) {
                    $scope.selectedMonthlyDebit = data.debits[0];
                }
                else {
                    $scope.selectedMonthlyDebit = undefined;
                }
            });
        };

        $scope.switchPayment = function (payment){
            $scope.selectedPayment = payment;
        };

        init();

        $scope.getMonthName = function (month){
            for (var i = 1; i < $scope.monthsForPayments.length; i++) {
                if (month == $scope.monthsForPayments[i].orderOf) {
                    return $scope.monthsForPayments[i].name;
                }
            }
        };

        $scope.getPaymentTypeName = function (paymentType){
            for (var i = 0; i < $scope.paymentTypes.length; i++) {
                if (paymentType == $scope.paymentTypes[i].type) {
                    return $scope.paymentTypes[i].name;
                }
            }
        };

        $scope.openAddPaymentDialog = function (ev){
            $mdDialog.show({
                controller: 'AddPaymentDialogController',
                templateUrl: 'html/paymentDialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:false
            })
                .then(function(payment) {
                    PaymentFactory.addPayment(payment)
                        .success(function (data) {
                            $scope.getPayments();
                        })
                        .error(function (data){
                            alert("Dodavanje nove uplate neuspešno!")
                        });
                });
        };

        $scope.openUpdatePaymentDialog = function (ev){
            $mdDialog.show({
                controller: 'UpdatePaymentDialogController',
                templateUrl: 'html/paymentDialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:false,
                locals: {
                    paymentToUpdate: $scope.selectedPayment
                }
            })
                .then(function(payment) {
                    PaymentFactory.updatePayment(payment)
                        .success(function (data) {
                            $scope.getPayments();
                        })
                        .error(function (data){
                            alert("Ažuriranje uplate neuspešno!")
                        });
                });
        };

        $scope.removePayment = function (){
            PaymentFactory.removePayment($scope.selectedPayment).success(new function (data){
                $scope.getPayments();
            });
        };

        $scope.logout = function (){
            $localStorage.loggedUser = undefined;
            $location.path("/");
        };


    })
    .controller('AddPaymentDialogController', function ($scope, $mdDialog, $localStorage, ChildFactory) {

        function init() {

            $scope.tempPayment = new Object();
            $scope.tempPayment.month = undefined;
            $scope.tempPayment.year = undefined;
            $scope.tempPayment.child = undefined;
            $scope.tempPayment.paymentType = undefined;
            $scope.tempPayment.amount = undefined;
            $scope.tempPayment.date = undefined;

            $scope.monthNames = ['Januar', 'Februar', 'Mart', 'April', 'Maj', 'Jun',
                'Jul', 'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar'];
            $scope.months = $scope.monthNames.map(function (key, val, array){
                return {
                    name: key,
                    orderOf: val + 1
                };
            });

            $scope.paymentTypes = new Array();
            $scope.paymentTypes.push({
                name: 'Direktni',
                type: 'DIRECT'
            });
            $scope.paymentTypes.push({
                name: 'Preko posrednika',
                type: 'THROUGH_INTERMEDIARIES'
            });

            ChildFactory.getChildrenByInstitution($localStorage.loggedUser).success(function (data){
                $scope.children = data;
            });

            $scope.isAdd = true;
        }

        init();

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function() {
            $mdDialog.hide($scope.tempPayment);
        };

    })
    .controller('UpdatePaymentDialogController', function ($scope, paymentToUpdate, $mdDialog, $localStorage, ChildFactory) {

        function init() {

            $scope.tempPayment = paymentToUpdate;

            $scope.monthNames = ['Januar', 'Februar', 'Mart', 'April', 'Maj', 'Jun',
                'Jul', 'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar'];
            $scope.months = $scope.monthNames.map(function (key, val, array){
                return {
                    name: key,
                    orderOf: val + 1
                };
            });

            $scope.paymentTypes = new Array();
            $scope.paymentTypes.push({
                name: 'Direktni',
                type: 'DIRECT'
            });
            $scope.paymentTypes.push({
                name: 'Preko posrednika',
                type: 'THROUGH_INTERMEDIARIES'
            });

            ChildFactory.getChildrenByInstitution($localStorage.loggedUser).success(function (data){
                $scope.children = data;
            });

            $scope.isAdd = false;
        }

        init();

        $scope.cancel = function() {
            $mdDialog.cancel();
        };

        $scope.answer = function() {
            $mdDialog.hide($scope.tempPayment);
        };

    });

