angular.module('myApp').controller('bcontroller', function($scope, $route, bservice, $location, bid,$rootScope) {
	var self = this;
	self.blog = {
			blogid : 0,
			blogTitle : '',
			blogDescription : '',
			blogAuthor : '',
			blogAuthoremail : '',
			status : '',
			createdOn : null
	};
	self.blogComment = {
			commid : 0,
			blogid : 0,
			blogcomment : '',
			postedby : '',
			createdOn : null
	};
	self.likedislike = {
			lid: 0,
			blogid: 0,
			likecount: 0,
			dislikecount: 0
	};
	
	self.submit = submit;
	self.submitComment = submitComment;
	self.reset =reset;
	
	
	viewallblogs()
	viewoneblog()
	viewallblogComments()
	viewmyblogs()

	function createblog(blog) {
		bservice.createblog(blog).then(function(response) {
			alert('blog added');
			reset();
		}, function(errResponse) {
			alert('blog not added');
		})
	}
	
	function submit()
	{
		self.blog.blogAuthor=$rootScope.currentuser.name;
		self.blog.blogAuthoremail=$rootScope.currentuser.email;
		self.blog.status='false';
		alert($rootScope.currentuser.name);
		createblog(self.blog);
	}
	
	function reset(){
		self.blog=null;
	}
	
	function viewallblogs() {
		bservice.viewallblogs().then(function(response) {
			self.blogs = response.data;
		}, function(response) {
			alert('No blog available');
		})
	}
	
	function viewmyblogs() {
		bservice.viewmyblogs($rootScope.currentuser.email).then(function(response) {
			self.myblogs = response.data;
			viewmylike();
		}, function(response) {
			self.myblogs=null;
		})
	}
	
	function viewoneblog() {
		bservice.viewoneblog(bid.id).then(function(response) {
			self.blog = response.data;
			viewmylike();
		}, function(errResponse) {
			alert('No blog available');
		})
	}
	
	self.selectoneblog =function(id) {
		bid.id=id;
		$location.path("/viewoneblog")
	}
	function viewallblogComments() {
		bservice.viewallblogComments(bid.id).then(function(response) {
			self.blogComments = response.data;
		}, function(errResponse) {
			alert('NO Blog Found');
		})
	}
	
	function createblogcomment(blogComment) {
		bservice.createblogcomment(blogComment).then(
				function(response) {
					alert('BlogComments Posted Successfully ');
					self.blogComment=null;
					$route.reload();
				}, function(errResponse) {
					alert('BlogComments Not Posted');
				})
	}
	
	function submitComment() 
	{
		alert(self.blogComment)
		self.blogComment.postedby = $rootScope.currentuser.name;
		self.blogComment.blogid = bid.id;
		createblogcomment(self.blogComment);
	}
	
	self.editblog =function(id) {
		bid.id=id;
		$location.path("/blog")
	}
	
	self.deleteblog =function(id) {
		bservice.deleteblog(id).then(function(response) {
			alert('blog deleted')
			$route.reload();
		}, function(errResponse) {
			alert('NO Blog Found');
		})
	}
	
	self.deleteblogcomment =function(id) {
		bservice.deleteblogcomment(id).then(function(response) {
			alert('blog comment deleted')
			$route.reload();
		}, function(errResponse) {
			alert('NO Blog Found');
		})
	}
	
	function viewmylike(){
		bservice.viewlikedislike(bid.id).then(function(response) {
			self.likedislike = response.data;
			alert("hi");
		}, function(response) {
			self.likedislike = response.data;
			alert("bye");
		})
	}
	
	self.updatelike =function(id) {
		self.likedislike.blogid =bid.id;
		self.likedislike.likecount=(self.likedislike.likecount+1);
		bservice.createlikedislike(self.likedislike).then(function(response){
			
		},function(errResponse){
			
		})
	}
	
	self.updatedislike =function(id) {
		self.likedislike.blogid =bid.id;
		self.likedislike.dislikecount=(self.likedislike.dislikecount+1);
		bservice.createlikedislike(self.likedislike).then(function(response){
			
		},function(errResponse){
			
		})
	}
	
	
})
