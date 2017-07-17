'use strict';

app.controller('PostController', ['$scope', 'PostService', function ($scope, PostService) {
    var self = this;
    self.post = {
        id: null,
        title: '',
        title_clean: '',
        articlce: '',
        author_id: null,
        status: null,
        comments_enabled: null,
        views: null,
        likes: null,
        image_uri: '',
        date_published: ''
    };
    self.posts = [];
    fetchAllPosts();

    function fetchAllPosts() {
        PostService.fetchAllPosts()
            .then(
                function (d) {
                    console.log(d);
                    self.posts = d;
                },
                function (errResponse) {
                    console.error('Error while fetching Posts');
                }
            );
    }
}]);