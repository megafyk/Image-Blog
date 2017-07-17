'use strict';

var loadingApp = angular.module('loadingApp', ['infinite-scroll']);

loadingApp.controller('DemoController', function ($scope, Megafyk) {
    $scope.megafyk = new Megafyk();
});

loadingApp.factory('Megafyk', function ($http) {
    var Megafyk = function () {
        this.posts = [];
        this.busy = false;
        this.page = 1;
    };

    Megafyk.prototype.nextPage = function () {
        if (this.busy) return;
        this.busy = true;

        var url = "http://localhost:8080/post/page" + this.page;
        $http.get(url).success(function (data) {
            var posts = data;
            console.log(posts);
            for (var i = 0; i < posts.length; i++) {
                this.posts.push(posts[i]);
            }
            this.page += 1;
            this.busy =false;
        }.bind(this));
    }
    return Megafyk;
});