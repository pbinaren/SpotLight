angular.module('myApp').controller('acontroller', function($scope, aservice, $location) {
	var self = this;
	
	self.blog = {
			id : null,
			blogName : '',
			blogTitle : '',
			blogDescription : '',
			blogAuthor : '',
			status : 'false',
			createdOn : null
	};

	function getallblogs() {
		aservice.getallblogs().then(function(response) {
			self.blogs = response.data;
		}, function(response) {
			alert('No blog available');
		})
	}
	
	self.deleteblog =function(id){
		aservice.deleteblog(id).then(function(response) {
			getallblogs();
		}, function(response) {
			alert('Not deleted');
		})
	}
	
	self.approveblog =function(id){
		aservice.approveblog(id).then(function(response) {
			alert('Blog Approved');
			getallblogs();
		}, function(response) {
			alert('Not approved');
		})
	}
	getallblogs()
})
