package model;


public class Technique {

	private Technique next;
	private int factor;
	private String name;
	
	public Technique(String name, int factor) {
		this.name = name;
		this.factor = factor;
	}
	
	public int getFactor() {
		return factor;
	}
	public String getName() {
		return name;
	}
	public Technique getNextTech() {
		return next;
	}
	public void setNextTech(Technique t) {
		next = t;
	}
	
	
	
	
}
