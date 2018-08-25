var app = angular.module("myApp", [ "ngRoute", "ngCookies" ]);
app.value('bid', {
	id : 1
});
app.value('jid', {
	id : 1
});
app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "home.html"
	}).when("/about", {
		templateUrl : "aboutus.html"
	}).when("/contact", {
		templateUrl : "contact.html"
	}).when("/login", {
		templateUrl : "login.html"
	}).when("/blog", {
		templateUrl : "blog.html"
	}).when("/blogapproval", {
		templateUrl : "blogapproval.html"
	}).when("/viewallblogs", {
		templateUrl : "viewallblogs.html"
	}).when("/viewoneblog", {
		templateUrl : "viewoneblog.html"
	}).when("/forum", {
		templateUrl : "forum.html"
	}).when("/viewallforums", {
		templateUrl : "viewallforums.html"
	}).when("/job", {
		templateUrl : "job.html"
	}).when("/jobapproval", {
		templateUrl : "jobapproval.html"
	}).when("/viewalljobs", {
		templateUrl : "viewalljobs.html"
	}).when("/viewonejob", {
		templateUrl : "viewonejob.html"
	}).when("/registration", {
		templateUrl : "registration.html"
	});
});

app
		.run(function($rootScope, $location, $http, $cookieStore) {

			$rootScope
					.$on(
							'$locationChangeStart',
							function(event, next, current) {
								var isLoggedIn = $rootScope.usersingnedin;
								var role = $rootScope.currentuser.role;
								var studPages = [ '/blog', '/viewallblogs',
										'/viewoneblog', '/viewallforums' ]
								var empPages = [ '/viewalljobs', '/viewonejob' ]
								var compPages = [ '/job' ]
								var adminPages = [ '/jobapproval',
										'/blogapproval', '/forum' ]
								var currentPage = $location.path()
								var isstudPage = $.inArray(currentPage,
										studPages) >= 0;
								var isAdminPage = $.inArray(currentPage,
										adminPages) >= 0;
								var isempPage = $
										.inArray(currentPage, empPages) >= 0;
								var iscompPage = $.inArray(currentPage,
										compPages) >= 0;

								if (!isLoggedIn) {
									if (isstudPage || isAdminPage || isempPage
											|| iscompPage) {
										alert("You need to log in to view this page");
										$location.path('/login');
									}
								} else {
									if (role == 'Admin') {
										if (isempPage
												|| iscompPage) {
											alert("You can not do this operation as you are logged as : "
													+ role);
											$location.path('/');
										}
									} else if (role == 'Employee') {
										if (iscompPage || isAdminPage) {
											alert("You can not do this operation as you are logged as : "
													+ role);
											$location.path('/');
										}
									} else if (role == 'Employer') {
										if (isAdminPage) {
											alert("You can not do this operation as you are logged as : "
													+ role);
											$location.path('/');
										}
									} else {
										if (isAdminPage || isempPage
												|| iscompPage) {
											alert("You can not do this operation as you are logged as : "
													+ role);
											$location.path('/');
										}
									}
								}

							})
			$rootScope.currentUser = $cookieStore.get('currentuser') || null;
			if ($rootScope.currentuser) {
				$http.defaults.headers.common['Authorization'] = 'Basic'
						+ $rootScope.currentuser;
			}
		});