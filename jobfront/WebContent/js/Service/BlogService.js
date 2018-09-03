app.factory('bservice',function($http)
    {
	var url='http://localhost:8080/jobmiddle/blog';
	var url1 ='http://localhost:8080/jobmiddle/blogcomment';
	var url2 ='http://localhost:8080/jobmiddle/mydata';

	var factory = 
	{
			createblog: createblog,
			viewallblogs: viewallblogs,
			viewmyblogs: viewmyblogs,
			viewoneblog: viewoneblog,
			createblogcomment: createblogcomment,
			viewallblogComments: viewallblogComments,
			deleteblog:deleteblog,
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
    
    function viewmyblogs(emailid) 
    {
        return $http.get(url2+"/blog?email="+emailid);
    }
    
    function viewoneblog(id) 
    {
    	var blogurl = url +"/"+id;
        return $http.get(blogurl);
    }
    function createblogcomment(blogComment) 
    {
        return $http.post(url1, blogComment);
    }
    
    function viewallblogComments(blogid) 
    {
        return $http.get(url1+"/"+blogid);
    }
    
    function deleteblog(id) 
    {
    	var blogurl = url2 +"/blog/"+id;
        return $http.delete(blogurl);
    }
 });