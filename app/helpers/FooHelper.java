package helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.Logger;
import utils.DateUtil;

import com.avaje.ebean.Ebean;


import models.User;
import models.UserLike;

public class FooHelper {

	
	public static void insertTestData() {
		// test user
		List<User> testUsers = new ArrayList<User>();
 		User user1 = new User();
		user1.name = "rkaneko";
		testUsers.add(user1);
		User user2 = new User();
		user2.name = "Bob";
		testUsers.add(user2);
		Ebean.save(testUsers);
		
		// test user_like
		List<UserLike> testUserLikes = new ArrayList<UserLike>();
		UserLike userLike1 = new UserLike();
		userLike1.uid = 1;
		userLike1.feedId = 1l;
		userLike1.createdAt = new Date();
		testUserLikes.add(userLike1);
		UserLike userLike2 = new UserLike();
		userLike2.uid = 1;
		userLike2.feedId = 2l;
		userLike2.createdAt = new Date();
		testUserLikes.add(userLike2);
		UserLike userLike3 = new UserLike();
		userLike3.uid = 2;
		userLike3.feedId = 1l;
		userLike3.createdAt = new Date();
		testUserLikes.add(userLike3);
		UserLike userLike4 = new UserLike();
		userLike4.uid = 2;
		userLike4.feedId = 3l;
		userLike4.createdAt = new Date();
		testUserLikes.add(userLike4);
		
		Ebean.save(testUserLikes);
	}
	
	public static void showLikes() {
		List<UserLike> testUserLikes = UserLike.findAllJoinUser();
		for (UserLike userLike : testUserLikes) {
			Logger.info(userLike.toString());
		}
		
		List<UserLike> testUserLikesBySql = UserLike.findAllJoinUserUsingSql();
		for (UserLike userLike : testUserLikesBySql) {
			Logger.info(userLike.toString());
		}
	}
	
	public static void showUserAndHisLikes() {
		User user = User.findByUid(1);
		Logger.info("ユーザ : " + user.name + "のLikeは");
		for (UserLike like : user.likes) {
			Logger.info("feedId : " + like.feedId + ",createdAt : " + DateUtil.toString(like.createdAt));
		}
	}
}
