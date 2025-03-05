package cs3330_group39_assignment2;

/**
 * characters stores characters of type MiddleEarthCharacter that are created by the user
 * size tracks the size of the array characters
 */
public class CharacterManager {
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[5];
	private int size;
	/**
	 * addCharacter takes a MiddleEarthCharacter variable and adds it to the first empty positon in the array
	 * if no empty position is found, a new array of double the size of the previous is created, is given the elements
	 * in the current characters array, then replaces the characters array a boolean value returns true if the value was 
	 * successfully added to the array, and false otherwise
	 * @param c character to be added to the array characters
	 * @return
	 */
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
			System.arraycopy(characters, 0, newCharacters, 0, size);
			characters = newCharacters;
			addedCheck = addCharacter(c);
		}
		return addedCheck;
	}
	/**
	 * getCharacter takes a String, then finds a MiddleEarthCharacter element in the array characters based on that String
	 * The passed String must represent a name of an existing character in the list, as it it compared to each elements name field
	 * to determine if it is in fact the character to be returned
	 * Once the character is found it is returned, if it is not found, null is returned
	 * @param name string representing the name of a character to be searched for in the array
	 * @return
	 */
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
	/**
	 * updateCharacter is given a MiddleEarthCharacter, as well as new values for the name, power, and health fields
	 * the passed character is found in the array, then its fields are updated, given that the passed fields are not 
	 * identical to their previous values
	 * the method returns false is no field was changed, and true otherwise
	 * @param character the character to be updated
	 * @param name the new name of the character
	 * @param health the new health of the character
	 * @param power the new power of the character
	 * @return
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		boolean changeCheck = false;
		for(int i=0; i<characters.length; i++) {
			if((characters[i] == character) & (characters[i] != null)) {
				if(!characters[i].name.equals(name)) {
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
	/**
	 * deleteCharacter identifies a passed MiddleEarthCharacter in the characters array, then removes the character from the array
	 * after the removal is completed, elements in the array will be shifted back to fill the space left empty by the deleted character
	 * the method returns false is no element is deleted, and true otherwise
	 * @param character to be deleted from the array
	 * @return
	 */
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
	/**
	 * displayAllCharacters increments through the array characters and displays the information of each character in the array
	 */
	public void displayAllCharacters() {
		for(int i=0; i<characters.length; i++) {
			if(characters[i] != null) {
				System.out.print(i+1 + ".");
				characters[i].displayInfo();
			}
		}
	}
}
