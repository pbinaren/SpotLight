angular.module('myApp').controller('bcontroller', function($scope, bservice, $location, bid) {
	var self = this;
	self.blog = {
			blogTitle : '',
			blogDescription : '',
			blogAuthor : '',
			status : 'false',
			createdOn : null
	};
	self.submit = submit;

	function createblog(blog) {
		bservice.createblog(blog).then(function(response) {
			alert('blog added');
			self.blog=null;
		}, function(errResponse) {
			alert('blog not added');
		})
	}
	
	function submit()
	{
		createblog(self.blog);
	}
	
	function viewallblogs() {
		bservice.viewallblogs().then(function(response) {
			self.blogs = response.data;
		}, function(response) {
			alert('No blog available');
		})
	}
	
	function viewoneblog() {
		bservice.viewoneblog(bid.id).then(function(response) {
			self.blog = response.data;
		}, function(response) {
			alert('No blog available');
		})
	}
	
	self.selectoneblog =function(id) {
		bid.id=id;
		$location.path("/viewoneblog")
	}
	viewallblogs()
	viewoneblog()
})
