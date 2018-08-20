angular.module('myApp').controller('fcontroller', function($scope, fservice, $location) {
	var self = this;
	self.forum = {
			
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
	
	
})
