package controllers;

import helpers.FooHelper;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
    	FooHelper.insertTestData();
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result user() {
    	FooHelper.showUserAndHisLikes();
    	return ok("Show user & his likes .");
    }
    
    public static Result likes() {
    	FooHelper.showLikes();
    	return ok("Show likes .");
    }
  
}
