package cs3330_group39_assignment2;
/**
 * 
 * instance of MiddleEarthCouncil, class to facilitate access to CharacterManager
 * getInstance return current instance, if one does not exist create one
 * getCharacterManager, return an instance of CharacterManager
 */
class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	public static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	public CharacterManager getCharacterManager() {
		CharacterManager manager = new CharacterManager();
		return manager;
	}
}
