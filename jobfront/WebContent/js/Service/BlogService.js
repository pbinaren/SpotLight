app.factory('bservice',function($http)
    {
	var url='http://localhost:8080/jobmiddle/blog';
	var factory = 
	{
			createblog: createblog,
			viewallblogs: viewallblogs,
			viewoneblog: viewoneblog
	};
	return factory;
    function createblog(blog) 
    {
        return $http.post(url, blog);
    }
    
    function viewallblogs() 
    {
        return $http.get(url);
    }
    function viewoneblog(id) 
    {
    	var blogurl = url +"/"+id;
        return $http.get(blogurl);
    }
 });