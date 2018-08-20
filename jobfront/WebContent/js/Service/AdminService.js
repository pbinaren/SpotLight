app.factory('aservice',function($http)
    {
	
	var factory = 
	{
			getallblogs: getallblogs,
			deleteblog: deleteblog,
			approveblog: approveblog
			};
	return factory;
    function getallblogs() 
    {
    	var url='http://localhost:8080/jobmiddle/admin/blogs';
        return $http.get(url);
    }
    function deleteblog(id)
    {
    	var url="http://localhost:8080/jobmiddle/admin/blog/"+id;
		return $http.delete(url);
    } 
    
    function approveblog(id)
    {
    	var url="http://localhost:8080/jobmiddle/admin/blogapprove/"+id;
		return $http.put(url);
    }
 });