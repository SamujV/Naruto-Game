package model;

public class Clan {
	
	private String name;
	
	private Character firsCharacter;
	private Clan next;
	
	public Clan(String nam) {
		name = nam;
	}
	
	public String getName() {
		return name;
	}
	

}
