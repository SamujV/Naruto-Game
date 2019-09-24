package interfaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import model.Clan;


public class Game {	;

	 Scanner i = new Scanner(System.in);
	 Scanner s = new Scanner(System.in);
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	 private Clan firstClan;
	 
	 public Game() throws IOException {
		System.out.println(showWelcome());
		Menu();
		

	}




	public void Menu() throws IOException {

		int option = 0;
	
		while(option != 5) {
			try {
				System.out.println(showMenu());
			option = Integer.parseInt(br.readLine());
				Cases(option);

			}catch(NumberFormatException e) {
				System.out.println(" Please insert the correct format \n");
			}
		}
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
	public boolean existClanName(String name) {
		boolean exist = false;
		Clan sig = firstClan;
		while(sig != null && !exist) {
			
			if(sig.getName().equals(name)) {
				exist = true;
			}
			sig = sig.getNextClan();
		}


		return exist;

	}

	public String showMenu() {
		String message = "";
		message += "What do you want to do? \n";
		message += "1. Create a Clan \n";
		message += "2. Create a Character \n";
		message += "3. Create a Technique \n";
		message += "4. Use test data \n";
		message += "5. Exit \n";
		return message;

	}

	public void Cases(int option) throws IOException {
		switch (option){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			bye();			
			break;
		default: errorNumber();

		}
	}


	

	
//	public void ShowClubList() {
//
//		try {
//			for (int i = 1; i <= clubs.size(); i++) {
//				System.out.println(i +". "+ clubs.get(i-1).getName());
//			}
//		}catch(NullPointerException e) {
//			e.getMessage();
//		}
//	}






	public String showWelcome() {
		String message = "";
		message += "=============================================================\n";
		message += "================= Welcome to the NARUTO GAME ================\n";
		message += "=============================================================\n";
		return message;
	}

	public String petType() {
		String message = "";
		message += "Dog \n";
		message += "Cat \n";
		message += "Bird \n";
		message += "Reptile \n";
		message += "Fish \n";
		message += "Invertebrate";
		return message;
	}
	public void showCreateClubMessage() {
		String message = "";
		message += "=========================================================\n";
		message += "====================   CREATE A CLUB   ==================\n";
		message += "=========================================================\n";
		System.out.println("" + message);
	}
	public void showCreateOwnerMessage() {
		String message = "";
		message += "=========================================================\n";
		message += "====================   CREATE AN OWNER   =================\n";
		message += "=========================================================\n";
		System.out.println("" + message);
	}
	public void showCreatePetMessage() {
		String message = "";
		message += "=========================================================\n";
		message += "====================   CREATE A PET   ==================\n";
		message += "=========================================================\n";
		System.out.println("" + message);
	}


	public void bye() {
		System.out.println("Thanks for using the program");
	}
	public void errorNumber() {

		System.out.println(" Ups... this is not an option");
	}



}
