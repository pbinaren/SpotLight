app.factory('fservice',function($http)
    {
	var url='http://localhost:8080/jobmiddle/forum';
	var factory = 
	{
			createforum: createforum,
			viewallforums: viewallforums,
			
	};
	return factory;
    function createforum(forum) 
    {
        return $http.post(url, forum);
    }
    
    function viewallforums() 
    {
        return $http.get(url);
    }
 });