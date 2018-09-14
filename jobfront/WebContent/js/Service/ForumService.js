app.factory('fservice',function($http)
    {
	var url='http://localhost:8080/jobmiddle/forum';
	var url1='http://localhost:8080/jobmiddle/forumdiscussion';
	var factory = 
	{
			createforum: createforum,
			viewallforums: viewallforums,
			viewoneforum: viewoneforum,
			createforumdiscussion: createforumdiscussion,
			viewallforumdiscussions: viewallforumdiscussions,
			
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
    
    function viewoneforum(id) 
    {
    	var furl = url +"/"+id;
        return $http.get(furl);
    }
    function createforumdiscussion(forumDiscussion) 
    {
        return $http.post(url1, forumDiscussion);
    }
    function viewallforumdiscussions(foid) 
    {
        return $http.get(url1+"/"+foid);
    }
 });