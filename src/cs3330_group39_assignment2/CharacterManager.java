package cs3330_group39_assignment2;

public class CharacterManager {
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[5];
	private int size;
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		boolean addedCheck = false;
		for(int i=0; i<characters.length; i++) {
			if(characters[i] == null) {
				characters[i] = c;
				size++;
				addedCheck = true;
				i = characters.length;
			}
		}
		if(addedCheck == false) {
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[(characters.length)*2];
			System.arraycopy(c, 0, newCharacters, 0, size);
			characters = newCharacters;
			addedCheck = addCharacter(c);
		}
		return addedCheck;
	}
	public MiddleEarthCharacter getCharacter(String name) {
		MiddleEarthCharacter retVal = null;
		for(int i=0; i<characters.length; i++) {
			if(characters[i] != null) {
				if (characters[i].name.equals(name)) {
					retVal = characters[i];
				}
			}
		}
		return retVal;
		
	}
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		boolean changeCheck = false;
		for(int i=0; i<characters.length; i++) {
			if((characters[i] == character) & (characters[i] != null)) {
				if(characters[i].name != name) {
					characters[i].name = name;
					changeCheck = true;
				}
				if(characters[i].health != health) {
					characters[i].health = health;
					changeCheck = true;
				}
				if(characters[i].power != power) {
					characters[i].power = power;
					changeCheck = true;
				}
			}
		}
		return changeCheck;
	}
	public boolean deleteCharcter(MiddleEarthCharacter character) {
		boolean deleteCheck = false;
		for(int i=0; i<characters.length; i++) {
			if(characters[i] == character) {
				characters[i] = null;
				size--;
				deleteCheck = true;
			}
		}
		for(int i=1; i<characters.length; i++) {
			if((characters[i-1] == null) & (characters[i] != null)) {
				characters[i-1] = characters[i];
				characters[i] = null;
			}
		}
		return deleteCheck;
	}
	public void displayAllCharacters() {
		for(int i=0; i<characters.length; i++) {
			if(characters[i] != null) {
				System.out.print(i+1 + ".");
				characters[i].displayInfo();
			}
		}
	}
}
