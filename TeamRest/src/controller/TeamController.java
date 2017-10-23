package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.TeamDAO;
import entities.Team;

@RestController
public class TeamController {
	
	@Autowired
	private TeamDAO teamDao;
	
	@RequestMapping(path="ping", method=RequestMethod.GET )
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="teams", method=RequestMethod.GET)
	public List<Team> index(){
		return teamDao.getAll();
	}
	
	@RequestMapping(path="teams/{id}", method=RequestMethod.GET)
	public Team show(@PathVariable int id) {
		return teamDao.show(id);
	}
	
	@RequestMapping(path="teams", method=RequestMethod.POST)
	public Team create(@RequestBody String teamJSON) {
		return teamDao.create(teamJSON);
	}
	
	@RequestMapping(path="teams/{id}", method=RequestMethod.PUT)
	public Team update(@PathVariable int id, @RequestBody String team) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Team mappedTeam = mapper.readValue(team, Team.class);
			return teamDao.update(id, mappedTeam);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		} 
	}
	
	@RequestMapping(path="teams/{id}", method=RequestMethod.DELETE)
	public boolean remove(@PathVariable int id) {
		teamDao.remove(id);
		return true;
	}

}
