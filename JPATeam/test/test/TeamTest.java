package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Team;

public class TeamTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	@Before
	public void setUp() throws Exception{
		emf = Persistence.createEntityManagerFactory("Team");
		em = emf.createEntityManager();
	}
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test() {
		boolean pass = true;
		assertEquals(pass, true);
	}


	@Test
	public void test_quiz_database_mapping() {
		Team t = em.find(Team.class, 1);
		assertEquals(t.getName(), "Falcons");

	}
	

}

