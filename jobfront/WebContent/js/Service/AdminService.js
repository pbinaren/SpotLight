app.factory('aservice',function($http)
    {
	
	var factory = 
	{
			getallblogs: getallblogs,
			deleteblog: deleteblog,
			approveblog: approveblog,
			getalljobs: getalljobs,
			deletejob: deletejob,
			approvejob: approvejob
			};
	return factory;
    function getallblogs() 
    {
    	var url='http://localhost:8080/jobmiddle/admin/blogs';
        return $http.get(url);
    }
    function deleteblog(id)
    {
    	var url="http://localhost:8080/jobmiddle/admin/blogreject/"+id;
		return $http.delete(url);
    } 
    
    function approveblog(id)
    {
    	var url="http://localhost:8080/jobmiddle/admin/blogapprove/"+id;
		return $http.put(url);
    }
    function getalljobs() 
    {
    	var url='http://localhost:8080/jobmiddle/admin/jobs';
        return $http.get(url);
    }
    function deletejob(id)
    {
    	var url="http://localhost:8080/jobmiddle/admin/jobreject/"+id;
		return $http.delete(url);
    } 
    
    function approvejob(id)
    {
    	var url="http://localhost:8080/jobmiddle/admin/jobapprove/"+id;
		return $http.put(url);
    }
 });