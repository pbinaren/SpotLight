app.factory('lservice',function($http)
    {
	var url='http://localhost:8080/jobmiddle/login';
	var factory = 
	{
			loginUser: loginUser,
	};
	return factory;
    function loginUser(user) 
    {
        return $http.post(url, user);
    }
 });