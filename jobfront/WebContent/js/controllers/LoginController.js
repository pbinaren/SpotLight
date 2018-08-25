angular.module('myApp').controller('lcontroller', function($scope, lservice, $location,$rootScope,$cookieStore) {
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
	self.logout = logout;

	$rootScope.currentuser=self.user;
	function loginuser(user) 
	{
		lservice.loginUser(user).then(function(response) 
				{
			self.user=response.data;
			$rootScope.currentuser=self.user;
			$rootScope.usersingnedin=true;
			$cookieStore.put('currentuser',	$rootScope.currentuser);
			if(self.user.role=="Student")
				$location.path("/viewallblogs")
			else if(self.user.role=="Employee")
				$location.path("/viewalljobs")
			else if(self.user.role=="Employer")
				$location.path("/job")
			else
				$location.path("/blogapproval")
			alert('Login Successsful');
			}, function(errResponse) {
			alert('login UnSuccesssful');
		})
	}
	
	function submit()
	{
		loginuser(self.user);
	}
	
	function logout()
	{
		self.user=null;
		$rootScope.currentuser = null;
		$cookieStore.remove('currentuser');
		$location.path('/');

	}
})
