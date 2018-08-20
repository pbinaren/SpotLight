app.factory('rservice',function($http)
    {
	var url='http://localhost:8080/jobmiddle/register';
	var factory = 
	{
			createUser: createUser,
	};
	return factory;
    function createUser(user) 
    {
        return $http.post(url, user);
    }
 });