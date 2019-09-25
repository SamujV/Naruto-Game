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


	public void addCharacter(String name, String personality, String creationDate, int score) {

		Character c = new Character(name, personality,creationDate, score);

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
		if(sig != null) {
			while(sig != null && !exist) {				
				if(sig.getName().equals(name)) {
					exist = true;
				}
				sig = sig.getnextChar();
			}			
		}
		return exist;
	}

	public String showCharacters() {
		String names = "";
		Character sig = firstCharacter;
		while(sig != null) {

			names += "- " + sig.getName() + "\n";
			sig = sig.getnextChar();
		}


		return names;
	}

	public Character characterExist(String name) {

		boolean existChar = false;
		Character sig = firstCharacter;
		Character exist = null;
		if(sig != null) {
			while(sig != null && !existChar) {
				if(sig.getName().equalsIgnoreCase(name)) {
					existChar = true;
					exist = sig;
				}
				sig = sig.getnextChar();
			}
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
