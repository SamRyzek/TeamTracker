package data;

import java.util.List;

import entities.Team;

public interface TeamDAO {
	
	public List<Team> getAll();

	public Team show(int id);

	public Team create(String teamJSON);

	public Team update(int id, Team team);

	public void remove(int id);

}
