angular.module('myApp').controller('fcontroller', function($scope,$route, fservice, $location, fid,$rootScope) {
	var self = this;
	self.forum = {
			foid: 0,
			forumTitle : '',
			forumDescription : '',
			
	};
	self.forumDiscussion = {
			fdid : 0,
			foid : 0,
			fdiscussion : '',
			postedby : '',
			createdOn : null
	}
	self.submit = submit;
	self.submitDiscussion = submitDiscussion;

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
	
	self.selectoneforum =function(id) {
		fid.id=id;
		$location.path("/viewoneforum")
	}
	
	function viewoneforum() {
		fservice.viewoneforum(fid.id).then(function(response) {
			self.forum = response.data;
		}, function(response) {
			alert('No forum available');
		})
	}
	
	function createforumdiscussion(forumDiscussion) {
		fservice.createforumdiscussion(forumDiscussion).then(
				function(response) {
					alert('discussion Posted Successfully ');
					self.blogComment=null;
					$route.reload();
				}, function(errResponse) {
					alert('discussion Not Posted');
				})
	}
	
	function submitDiscussion() 
	{
		self.forumDiscussion.postedby = $rootScope.currentuser.name;
		self.forumDiscussion.foid = fid.id;
		createforumdiscussion(self.forumDiscussion);
	}
	
	function viewallforumdiscussions() {
		fservice.viewallforumdiscussions(fid.id).then(function(response) {
			self.forumDiscussions = response.data;
		}, function(errResponse) {
			alert('NO forum Found');
		})
	}
	
	viewallforums()
	viewoneforum()
	viewallforumdiscussions()
})
