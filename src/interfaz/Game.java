package interfaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import model.Clan;


public class Game {	

	Scanner i = new Scanner(System.in);
	Scanner s = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private Clan firstClan;

	public Game()  {
		System.out.println(showWelcome());
		Menu();
	}

	public void Menu() {

		int option = 0;

		while(option != 4) {
			try {
				System.out.println(showMenu());
				option = Integer.parseInt(br.readLine());
				Cases(option);

			}catch(NumberFormatException e) {
				System.out.println(" Please insert the correct format \n");
			}catch(IOException a) {
				a.getMessage();
			}
		}
	}

	public void Cases(int option) throws IOException {
		switch (option){
		case 1:
			createClan();
			break;
		case 2:
			createCharacter();
			break;
		case 3:
			createTechnique();
			break;
		case 4:
			bye();	
			break;
		default: errorNumber();

		}
	}
	public String showMenu() {
		String message = "";
		message += "What do you want to do? \n";
		message += "1. Create Clan \n";
		message += "2. Create Character \n";
		message += "3. Create Technique \n";
		message += "4. Exit \n";
		return message;

	}

	public void createClan() {
		System.out.println(showClanMessage());

		String name = askClanData();	
		addClan(name);
	}

	public String askClanData() {
		String name = "";
		System.out.println("Please insert the clan's name");
		try {
			name = br.readLine();
			while(existClanName(name) != null) {
				System.out.println("Name it's not available, try again");
				name = br.readLine();
			}

		}catch(NumberFormatException e){
			System.out.println(" Please insert the correct format \n");
		}catch(IOException e) {
			e.getMessage();
		}

		return name;
	}

	public void addClan(String name) {
		Clan clan = new Clan(name);
		if(firstClan == null) {
			firstClan = clan;
		}else {
			Clan sig = firstClan;
			while(sig.getNextClan() != null) {
				sig = sig.getNextClan();
			}

			sig.setNextClan(clan);
			clan.setPrevClan(sig);


		}


	}


	public void createCharacter() {
		String nameClan = "";
		System.out.println(showCharacterMessage() + "\n");
		if(firstClan != null) {
			try {
				System.out.println(showClans() + "\n");
				System.out.println("Insert the name of the character's clan");
				nameClan = br.readLine();
				while(existClanName(nameClan) == null) {
					System.out.println("There is no clan with that name, try again");
					nameClan = br.readLine();
				}
				askCharacterData(nameClan);
			}catch(NumberFormatException e) {
				System.out.println("Please insert the correct format \n");
			}catch(IOException d){
				d.getMessage();
			}
		}else {
			System.out.println("Create a Clan first");
		}
	}

	public void askCharacterData(String nameC) {
		Clan clan = existClanName(nameC);
		String name, personality, creationD;
		int score;
		try {
			System.out.println("Insert character's name ");
			name = br.readLine();
			while(clan.existCharacterName(name) == true) {
				System.out.println("Name already taken, try again");
				name = br.readLine();
			}		
			System.out.println("Insert personality ");
			personality = br.readLine();
			System.out.println("Insert creation date");
			creationD = br.readLine();
			System.out.println("Insert score");
			score = Integer.parseInt(br.readLine());

			clan.addCharacter(name, personality, creationD, score);


		}catch(NumberFormatException e) {
			System.out.println("Please insert the correct format \n");
		}catch(IOException a) {
			a.getMessage();
		}		
	}


	public Clan existClanName(String name) {	
		boolean existClan = false;
		Clan sig = firstClan;
		Clan exist = null;
		if(sig != null) {
			while(sig != null && !existClan) {
				if(sig.getName().equalsIgnoreCase(name)) {
					existClan = true;
					exist = sig;
				}
				sig = sig.getNextClan();
			}
		}
		return exist;
	}

	public void createTechnique() {
		System.out.println(showTechniqueMessage() + "\n");
		String nameClan = "";
		String nameChar = "";
		String nameTech = "";
		int factor = 0;
		if(firstClan != null && firstClan.getCharacter() != null) {
			try {
				System.out.println(showClans());
				System.out.println("Insert the name of the character's clan");
				nameClan = br.readLine();
				while(existClanName(nameClan) == null) {
					System.out.println("There is no clan with that name, try again");
					nameClan = br.readLine();
				}
				Clan clan = existClanName(nameClan);
				System.out.println(showCharacters(nameClan));
				System.out.println("Insert The name of the character \n");
				nameChar = br.readLine();
				while(existClanName(nameClan).existCharacterName(nameChar) != true) {
					System.out.println("There is no character with that name, try again");
					nameChar = br.readLine();
				}
				System.out.println("\n" + "Insert technique's name ");
				nameTech = br.readLine();
				System.out.println("Insert factor");
				factor = Integer.parseInt(br.readLine());
				clan.characterExist(nameChar).addTechnique(nameTech, factor);

			}catch(NumberFormatException e) {
				System.out.println("Please insert the correct format \n");
			}catch(IOException d){
				d.getMessage();
			}
		}else {
			System.out.println("Create a clan and a character first");
		}		
	}

	public String showClans() {
		String names = "";
		Clan sig = firstClan;
		if(sig != null) {
			while(sig != null) {
				names += "- " + sig.getName() + "\n";
				sig = sig.getNextClan();
			}	
		}
		return names + "\n";
	}

	public String showCharacters(String clanName) {
		Clan clan = existClanName(clanName);
		String names = clan.showCharacters();
		return names + "\n";
	}

	public String showWelcome() {
		String message = "";
		message += "=============================================================\n";
		message += "================= Welcome to the NARUTO GAME ================\n";
		message += "=============================================================\n";
		return message;
	}
	public String showClanMessage() {
		String message = "";
		message += "=============================================================\n";
		message += "======================= CREATE CLAN =========================\n";
		message += "=============================================================\n";
		return message;
	}
	public String showCharacterMessage() {
		String message = "";
		message += "=============================================================\n";
		message += "====================== CREATE CHARACTER =====================\n";
		message += "=============================================================\n";
		return message;
	}
	public String showTechniqueMessage() {
		String message = "";
		message += "=============================================================\n";
		message += "===================== CREATE TECHNIQUE ======================\n";
		message += "=============================================================\n";
		return message;
	}

	public void bye() {
		System.out.println("Thanks for using the program");
	}
	public void errorNumber() {

		System.out.println(" Ups... this is not an option");
	}



}
