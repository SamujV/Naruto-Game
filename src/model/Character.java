package model;

public class Character {
	
	private Character next;
	private Technique firstTech;
	private String name;
	private String personality;
	private String creationDate;
	private int power;
	private int score;
	
	
	
	
	public Character(String name, String personality, String creationDate, int power, int score) {
		super();
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.score = score;
	}
	
	

	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public Technique getTechnique() {
		return firstTech;
	}
	
	
}
