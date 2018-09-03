angular.module('myApp').controller('acontroller', function($scope, aservice, $location) {
	var self = this;
	
	self.blog = {
			blogid : 0,
			blogName : '',
			blogTitle : '',
			blogDescription : '',
			blogAuthor : '',
			status : 'false',
			createdOn : null
	};
	self.job = {
			id: null,
			jobTitle : '',
			jobDescription : '',
			companyName : '',
			status : 'false',
			skillsRequired : '',
			location: '',
			salary: '',
			experience: '',
			vacancies: null
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
	
	function getalljobs() {
		aservice.getalljobs().then(function(response) {
			self.jobs = response.data;
		}, function(response) {
			alert('No job available');
		})
	}
	
	self.deletejob =function(id){
		aservice.deletejob(id).then(function(response) {
			getalljobs();
		}, function(response) {
			alert('Not deleted');
		})
	}
	
	self.approvejob =function(id){
		aservice.approvejob(id).then(function(response) {
			alert('job Approved');
			getallblogs();
		}, function(response) {
			alert('Not approved');
		})
	}
	getalljobs()

})
