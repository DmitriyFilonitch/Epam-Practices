package ua.nure.filonitch.practice8.db.entity;

public class User {

	private int id;
	private String login;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String toString() {
		return login;
	}

	public static User createUser(String login) {
		User user = new User();
		user.setLogin(login);
		return user;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		User u = (User) obj;
		return login.equals(u.login);
	}


	@Override
	public int hashCode() {
		final int p = 31;
		int res = 1;
		res = p * res + ((login == null) ? 0 : login.hashCode());
		return res;
	}
}
