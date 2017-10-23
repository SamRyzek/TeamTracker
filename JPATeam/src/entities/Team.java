package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "game_week")
	private int gameWeek;
	
	@Column(name = "win_or_loss")
	private String winOrLoss;


	
	//sets and gets
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
	public int getGameWeek() {
		return gameWeek;
	}
	public void setGameWeek(int gameWeek) {
		this.gameWeek = gameWeek;
	}
	public String getWinOrLoss() {
		return winOrLoss;
	}
	public void setWinOrLoss(String winOrLoss) {
		this.winOrLoss = winOrLoss;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", gameWeek=" + gameWeek + ", winOrLoss=" + winOrLoss + "]";
	}
	
	

}
