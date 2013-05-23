package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "user")
public class User extends Model {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	public Integer uid;
	
	public String name;
	
	@OneToMany(mappedBy = "user")
	public List<UserLike> likes;
	
	/** finder */
	private static Finder<Integer, User> find = new Finder<Integer, User>(Integer.class, User.class);
	
	
	// -----------------------------------
	
	public static User findByUid(Integer uid) {
		return find
				.fetch("likes")
				.where()
				.eq("uid", uid)
				.findUnique();
	}

}
