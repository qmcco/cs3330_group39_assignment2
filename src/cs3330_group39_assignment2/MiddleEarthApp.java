package cs3330_group39_assignment2;

import java.util.Scanner;

public class MiddleEarthApp {
	public static void main(String[] args) {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while(run == true) {
			System.out.println("\n\n*** Welcome to the Middle Earth Character Management App ***\n\n** Select an action form the list:\n"
				+ "*1. Add a new character\n*2. View all characters\n*3. Update a character\n*4. Delete a character\n*5. Execute all character's attack actions\n* Selection: ");
			int input = scan.nextInt();
			if(input == 1) {
				System.out.print("\nSelect character type:\n1. Elf\n2. Dwarf\n3. Human\n4. Orc\n5. Wizard\nSelection(1-5): ");
				int choice = scan.nextInt();
				System.out.print("\nEnter the new character's name: ");
				String name = scan.next();
				System.out.print("\nEnter health: ");
				double health = scan.nextDouble();
				System.out.print("\nEnter power: ");
				double power = scan.nextDouble();
				MiddleEarthCharacter newChar = null;
				switch(choice){
					case 1:
						newChar = new Elf(name,health,power);
						break;
					case 2:
						newChar = new Dwarf(name,health,power);
						break;
					case 3:
						newChar = new Human(name,health,power);
						break;
					case 4:
						newChar = new Orc(name,health,power);
						break;
					case 5:
						newChar = new Wizard(name,health,power);
						break;
					default:
						break;
						
				}
				if(newChar != null) {
					manager.addCharacter(newChar);
				}
				else {
					System.out.println("Error: Failed to initialize new character");
				}
				
			}
			else if(input == 2) {
				manager.displayAllCharacters();
			}
			else if(input == 3) {
				manager.displayAllCharacters();
				System.out.println("Choose a character from the list above to update (enter name): ");
				String choice = scan.next();
				MiddleEarthCharacter choiceChar = manager.getCharacter(choice);
				choiceChar.displayInfo();
				System.out.print("\nEnter new name: ");
				String name = scan.next();
				System.out.print("\nEnter new health: ");
				double health = scan.nextDouble();
				System.out.print("\nEnter new power: ");
				double power = scan.nextDouble();
				manager.updateCharacter(choiceChar, name, health, power);
			}
			else if(input == 4) {
				manager.displayAllCharacters();
				System.out.println("Choose a character from the list above to delete (enter name): ");
				String choice = scan.next();
				MiddleEarthCharacter choiceChar = manager.getCharacter(choice);
				manager.deleteCharcter(choiceChar);
			}
			else if(input == 5) {
				
			}
		}
	}
}



