package ua.nure.filonitch.practice8.db.entity;

public class Team {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Team createTeam(String s) {
		Team team = new Team();
		team.setName(s);
		return team;
	}

	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Team t = (Team) obj;
		return name.equals(t.name);
	}

	@Override
	public int hashCode() {
		final int p = 31;
		int res = 1;
		res = p * res + ((name == null) ? 0 : name.hashCode());
		return res;
	}
}
