package model;



public class Clan {
	
	private String name;
	
	private Character firstCharacter;
	private Clan next;
	private Clan prev;
	
	public Clan(String nam) {
		name = nam;
		next = null;
		prev = null;
	}
	
	
	public void addCharacter(String name, String personality, String creationDate, int power, int score) {
		
		Character c = new Character(name, personality,creationDate,power, score);
		
		if(firstCharacter == null) {
			firstCharacter = c;
		}else {
			
			Character sig = firstCharacter;
			while(sig.getnextChar() != null) {
				sig = sig.getnextChar();
			}
			sig.setNextChar(c);
			c.setPrevChar(sig);	
		}
		
		
	}
	

	public boolean existCharacterName(String name) {
		
		boolean exist = false;
		Character sig = firstCharacter;
		while(sig != null && !exist) {
			
			if(sig.getName().equals(name)) {
				exist = true;
			}
			sig = sig.getnextChar();
		}


		return exist;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	
	public Character getCharacter() {
		return firstCharacter;
	}
	public Clan getNextClan() {
		return next;
	}
	
	public Clan getPrevClan() {
		return prev;
	}
	
	public void setNextClan(Clan sig) {
		next = sig;
	}
	public void setPrevClan(Clan ant) {
		prev = ant;
	}

}
