package cs3330_group39_assignment2;

/**
 * name represents the name of a character
 * health represents it's health
 * power represents it's power
 */
public abstract class MiddleEarthCharacter {
	public String name;
	public double health;
	public double power;
	/**
	 * constructor for MiddleEarthCharacter, responsible for setting name, health, and power fields
	 * @param name the name of a character
	 * @param health their health
	 * @param power their power
	 */
	public MiddleEarthCharacter(String name, double health, double power){
		this.name = name;
		this.health = health;
		this.power = power;
	}
	/**
	 * abstract method that is extended by the subclasses, allows for a character to attack a target
	 * @param target the attacked character
	 * @return true if the attack is successful, false otherwise
	 */
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	/**
	 * Displays the information (name, health, power) of a character
	 */
	void displayInfo() {
		System.out.println("\n*** " + this.name + "'s details:" + "\n* health: " + this.health + "\n* power: " + this.power);
	}
}
/**
 * extension of MiddleEarthCharacter for race Elf
 */
class Elf extends MiddleEarthCharacter {
	Elf(String name, double health, double power){
		super(name, health, power);
	}
	/**
	 * if the target is of Elf or Dwarf race, attack is ineffective, otherwise, if the target is Orc race,
	 * attack is 1.5x as effective, otherwise, the attack does standard damage
	 * for all extended attack methods, the attackers power is deducted from the targets health to calculate damage
	 */
	@Override boolean attack(MiddleEarthCharacter target) {
		if ((!target.getRace().equals("Elf")) & (!target.getRace().equals("Dwarf"))) {
			if (target.getRace().equals("Orc")) {
				target.health -= (this.power * 1.5);
				return true;
			}
			else {
				target.health -= this.power;
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * returns string Elf
	 */
	String getRace() {
		return "Elf";
	}
}

class Dwarf extends MiddleEarthCharacter {
	Dwarf(String name, double health, double power){
		super(name, health, power);
	}
	/**
	 * if the target is of Wizard or Dwarf race, attack is ineffective, otherwise, if the target is Elf race,
	 * attack is 1.5x as effective, otherwise, the attack does standard damage
	 * for all extended attack methods, the attackers power is deducted from the targets health to calculate damage
	 */
	@Override boolean attack(MiddleEarthCharacter target) {
		if (!target.getRace().equals("Wizard") & !target.getRace().equals("Dwarf")) {
			if (target.getRace().equals("Elf")) {
				target.health -= (this.power * 1.5);
				return true;
			}
			else {
				target.health -= this.power;
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * returns string Dwarf
	 */
	String getRace() {
		return "Dwarf";
	}
}

class Human extends MiddleEarthCharacter {
	Human(String name, double health, double power){
		super(name, health, power);
	}
	/**
	 * if the target is of Orc or Human race, attack is ineffective, otherwise, if the target is Wizard race,
	 * attack is 1.5x as effective, otherwise, the attack does standard damage
	 * for all extended attack methods, the attackers power is deducted from the targets health to calculate damage
	 */
	@Override boolean attack(MiddleEarthCharacter target) {
		if (!target.getRace().equals("Orc") & !target.getRace().equals("Human")) {
			if (target.getRace().equals("Wizard")) {
				target.health -= (this.power * 1.5);
				return true;
			}
			else {
				target.health -= this.power;
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * returns string Human
	 */
	String getRace() {
		return "Human";
	}
}

class Orc extends MiddleEarthCharacter {
	Orc(String name, double health, double power){
		super(name, health, power);
	}
	/**
	 * if the target is of Elf or Orc race, attack is ineffective, otherwise, if the target is Human race,
	 * attack is 1.5x as effective, otherwise, the attack does standard damage
	 * for all extended attack methods, the attackers power is deducted from the targets health to calculate damage
	 */
	@Override boolean attack(MiddleEarthCharacter target) {
		if (!target.getRace().equals("Orc") & !target.getRace().equals("Elf")) {
			if (target.getRace().equals("Human")) {
				target.health -= (this.power * 1.5);
				return true;
			}
			else {
				target.health -= this.power;
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * returns string Orc
	 */
	String getRace() {
		return "Orc";
	}
}

class Wizard extends MiddleEarthCharacter {
	Wizard(String name, double health, double power){
		super(name, health, power);
	}
	/**
	 * if the target is of Wizard or Human race, attack is ineffective, otherwise, if the target is Dwarf race,
	 * attack is 1.5x as effective, otherwise, the attack does standard damage
	 * for all extended attack methods, the attackers power is deducted from the targets health to calculate damage
	 */
	@Override boolean attack(MiddleEarthCharacter target) {
		if (!target.getRace().equals("Wizard") & !target.getRace().equals("Human")) {
			if (target.getRace().equals("Dwarf")) {
				target.health -= (this.power * 1.5);
				return true;
			}
			else {
				target.health -= this.power;
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * returns string Wizard
	 */
	String getRace() {
		return "Wizard";
	}
}






