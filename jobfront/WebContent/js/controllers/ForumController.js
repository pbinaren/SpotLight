angular.module('myApp').controller('fcontroller', function($scope, fservice, $location) {
	var self = this;
	self.forum = {
			id: null,
			forumTitle : '',
			forumDescription : '',
			
	};
	self.submit = submit;

	function createforum(forum) {
		fservice.createforum(forum).then(function(response) {
			alert('forum added');
		}, function(errResponse) {
			alert('forum not added');
		})
	}
	
	function submit()
	{
		createforum(self.forum);
	}
	
	function viewallforums() {
		fservice.viewallforums().then(function(response) {
			self.forums = response.data;
		}, function(response) {
			alert('No forum available');
		})
	}
	viewallforums()
})
