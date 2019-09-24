package model;


public class Character {

	private Character next;
	private Character prev;
	private Technique firstTech;
	private String name;
	private String personality;
	private String creationDate;
	private int power;
	private int score;


	// listas ---- ordenamiento por insercion 

	public Character(String name, String personality, String creationDate, int power, int score) {
		super();
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.score = score;
	}

	public void addTechnique(String name, int factor) {

		Technique t = new Technique(name ,factor);

		if(firstTech == null) {
			firstTech = t;
		}else {
			Technique sig = firstTech;
			while(sig.getNextTech() != null) {
				sig = sig.getNextTech();
			}
			sig.setNextTech(t);
		}

		ascendingSort();
	}

	public void ascendingSort() {
//1 tipo de ordenamient 


	}

	public boolean existTechName(String name) {
		boolean exist = false;
		Technique sig = firstTech;
		while(sig != null && !exist) {
			
			if(sig.getName().equals(name)) {
				exist = true;
			}
			sig = sig.getNextTech();
		}


		return exist;

	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public Character getnextChar() {
		return next;
	}

	public Character getprevChar() {
		return prev;
	}

	public void setNextChar(Character next) {
		this.next = next;
	}

	public void setPrevChar(Character prev) {
		this.prev = prev;
	}


	public Technique getTechnique() {
		return firstTech;
	}


}
