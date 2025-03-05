package cs3330_group39_assignment2;

import java.util.Scanner;

/**
 * main class for overall project, responsible for executing operations selected by the user
 */
public class MiddleEarthApp {
	public static void main(String[] args) {
		/**
		 * get an instance of MiddleEarthCouncil
		 * use instance of MiddleEarthCouncil to access CharacterManager
		 * initialize scan Scanner value for user input
		 */
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		/**
		 * While loop to facilitate multiple operations during a single execution
		 * Display choices for user, then get user input
		 */
		while(run == true) {
			System.out.println("\n\n*** Welcome to the Middle Earth Character Management App ***\n\n** Select an action form the list:\n"
				+ "*1. Add a new character\n*2. View all characters\n*3. Update a character\n*4. Delete a character\n*5. Attack a character\n*6. Battle Demonstration\n* Selection: ");
			int input = scan.nextInt();
			/**
			 * Add a new character
			 * Select the character race, enter a name, health, and power
			 * create a new MiddleEarthCharacter and initialize it to null
			 * set character information after character race has been identified and assigned using the switch statement
			 */
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
			/**
			 * View all characters
			 * call displayAllCharacters method to show all characters currently in the array
			 */
			else if(input == 2) {
				manager.displayAllCharacters();
			}
			/**
			 * Update a character
			 * find the character in the array based on user entered name
			 * ask user for new name, health, and power
			 * call updateCharacter and provide the information given by the user
			 */
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
			/**
			 * Delete a character
			 * use user entered name to find the character to be deleted
			 * call deleteCharacter and provide the character found to match the name provided by the user
			 */
			else if(input == 4) {
				manager.displayAllCharacters();
				System.out.println("Choose a character from the list above to delete (enter name): ");
				String choice = scan.next();
				MiddleEarthCharacter choiceChar = manager.getCharacter(choice);
				manager.deleteCharcter(choiceChar);
			}
			/**
			 * Attack a character 
			 * find attacker character based on user provided name
			 * find character to be attacked based on user provided name
			 * call attack method using attacking character and character to be attacked as the parameter
			 * display information related to the attack (was attack successful?, Amount of damage dealt)
			 */
			else if(input == 5) {
				manager.displayAllCharacters();
				System.out.println("Choose a character from the list above to attack with (enter name): ");
				String attackerChoice = scan.next();
				MiddleEarthCharacter attacker = manager.getCharacter(attackerChoice);
				System.out.println("Choose a character from the list above to be attacked (enter name): ");
				String attackedChoice = scan.next();
				MiddleEarthCharacter attacked = manager.getCharacter(attackedChoice);
				double prevHealth = attacked.health;
				attacker.attack(attacked);
				System.out.println(attacker.name + " attacks " + attacked.name + "!!!");
				if(prevHealth != attacked.health) {
					System.out.println("The attack is effective!\n" + prevHealth + "-->" + attacked.health);
				}
				else {
					System.out.println("The attack is ineffective...");
				}
				attacked.displayInfo();
				
			}
			/**
			 * Battle Demonstration
			 * six custom characters are initialized
			 * human fights dwarf to show standard damage dealt
			 * dwarf fights dwarf to show no damage dealt to same race characters
			 * human fights orc to show no damage dealt to orcs that are immune to human attacks
			 * Wizard fights dwarf to show 1.5x damage dealt
			 */
			else if(input == 6) {
				MiddleEarthCharacter humChar = new Human("Aragorn", 125, 45);
				MiddleEarthCharacter dwar1Char = new Dwarf("Gimli", 115, 50);
				MiddleEarthCharacter dwar2Char = new Dwarf("Gloin", 120, 55);
				MiddleEarthCharacter elfChar = new Elf("Legolas", 100, 60);
				MiddleEarthCharacter orcChar = new Orc("Lug", 140, 40);
				MiddleEarthCharacter wizardChar = new Wizard("Gandalf", 90, 70);
				System.out.println("***BEGIN BATTLE DEMO***");
				humChar.displayInfo();
				dwar1Char.displayInfo();
				System.out.println("Human " + humChar.name + " attacks dwarf " + dwar1Char.name + " (no advantage, no disadvantage, standard damage)");
				double prevHealth = dwar1Char.health;
				humChar.attack(dwar1Char);
				System.out.println(dwar1Char.name + " health change: " + prevHealth + " --> " + dwar1Char.health);
				dwar1Char.displayInfo();
				dwar2Char.displayInfo();
				System.out.println("Dwarf " + dwar1Char.name + " attacks dwarf " + dwar2Char.name + " (disadvantage, same race)");
				prevHealth = dwar2Char.health;
				dwar1Char.attack(dwar2Char);
				System.out.println(dwar2Char.name + " health change: " + prevHealth + " --> " + dwar2Char.health);
				humChar.displayInfo();
				orcChar.displayInfo();
				System.out.println("Human " + humChar.name + " attacks orc " + orcChar.name + " (disadvantage, ineffective against this species)");
				prevHealth = orcChar.health;
				humChar.attack(orcChar);
				System.out.println(orcChar.name + " health change: " + prevHealth + " --> " + orcChar.health);
				wizardChar.displayInfo();
				dwar2Char.displayInfo();
				System.out.println("Wizard " + wizardChar.name + " attacks dwarf " + dwar2Char.name + " (advantage, 1.5x damage)");
				prevHealth = dwar2Char.health;
				wizardChar.attack(dwar2Char);
				System.out.println(dwar2Char.name + " health change: " + prevHealth + " --> " + dwar2Char.health);
			}
		}
	}
}



