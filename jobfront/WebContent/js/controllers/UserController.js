angular.module('myApp').controller('rcontroller', function($scope, rservice, $location) {
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

	function createuser(user) {
		rservice.createUser(user).then(function(response) {
			alert('Registered Successsfuly LogIn To Continue');
			$location.path('/login');
		}, function(errResponse) {
			alert('Registration UnSuccesssful');
		})
	}
	
	function submit()
	{
		createuser(self.user);
	}
})
