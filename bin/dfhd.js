// Add your code here!

var myApp = angular.module('myApp', []);

// define MathService here
myApp.service('MathService', function() {
  //define all the arithmetic functions here like add, subtract. multiply and divide here
  $scope.multiply=function(a,b){
      return a*b;
  }

});

// define CalculatorService here which uses Math service
myApp.service('CalculatorService', function(MathService) {
// consume MathService multiply function for getting square and cube of the parameter
  this.square = function(a) {
      return MathService.multiply(a,a);
  };
  this.cube = function(a) {
      return MathService.multiply(a,a*a);
  };

});

// define CalculatorController here
myApp.controller('CalculatorController', function($scope, CalculatorService) {

  // consume CalculatorService- square and cube function for getting square of the input
  // set the result in scope variable answer
  $scope.answer="";
  $scope.Square = function() {
    
      $scope.answer=CalculatorService.square(parseInt($scope.num));
  }

  $scope.Cube = function() {
       $scope.answer=CalculatorService.cube(parseInt($scope.num));
  }
});

// Add your code here!

var myApp = angular.module('myApp', []);

// define MathService here
myApp.service('MathService', function() {
  //define all the arithmetic functions here like add, subtract. multiply and divide here
  this.multiply=function(a,b){
      return a*b;
  }

});

// define CalculatorService here which uses Math service
myApp.service('CalculatorService', function(MathService) {
// consume MathService multiply function for getting square and cube of the parameter
  this.square = function(a) {
      return MathService.multiply(a,a);
  };
  this.cube = function(a) {
      return MathService.multiply(a,a*a);
  };

});

// define CalculatorController here
myApp.controller('CalculatorController', function($scope, CalculatorService) {

  // consume CalculatorService- square and cube function for getting square of the input
  // set the result in scope variable answer
  $scope.answer="";
  $scope.Square = function() {
    
      $scope.answer=CalculatorService.square(parseInt($scope.num));
  }

  $scope.Cube = function() {
       $scope.answer=CalculatorService.cube(parseInt($scope.num));
  }
});

