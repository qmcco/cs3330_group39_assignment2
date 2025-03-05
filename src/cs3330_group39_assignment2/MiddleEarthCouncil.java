package cs3330_group39_assignment2;

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
