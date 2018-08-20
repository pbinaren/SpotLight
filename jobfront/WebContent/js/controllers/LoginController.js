angular.module('myApp').controller('lcontroller', function($scope, lservice, $location) {
	var self = this;
	self.user = {
			name : '',
			email : '',
			password : '',
			phno : '',
			onlineStatus : 'false',
		role : ''
	};
	self.submit = submit;

	function loginuser(user) {
		lservice.loginUser(user).then(function(response) {
			alert('Login Successsful');
			$location.path('/blog');
		}, function(errResponse) {
			alert('login UnSuccesssful');
		})
	}
	
	function submit()
	{
		loginuser(self.user);
	}
})
