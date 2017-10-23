package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Team;

@Repository
@Transactional
public class TeamDAOImpl implements TeamDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Team> getAll() {
		String query = "SELECT t FROM Team t";
		return em.createQuery(query, Team.class)
				 .getResultList();
	}

	@Override
	public Team show(int id) {
		return em.find(Team.class, id);
	}

	@Override
	public Team create(String teamJSON) {
		System.out.println("Something Else");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Team mappedTeam = mapper.readValue(teamJSON, Team.class);
			em.persist(mappedTeam);
			em.flush();
			return mappedTeam;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		return null;
	}

	@Override
	public Team update(int id, Team team) {
		Team managed = em.find(Team.class, id);
		System.out.println("Anything");
		managed.setName(team.getName());
		managed.setGameWeek(team.getGameWeek());
		managed.setWinOrLoss(team.getWinOrLoss());
		return managed;
	}
		
	@Override
	public void remove(int id) {
		Team t = em.find(Team.class, id);
		em.remove(t);
	}

}
