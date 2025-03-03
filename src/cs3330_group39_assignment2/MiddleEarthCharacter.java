package cs3330_group39_assignment2;

public abstract class MiddleEarthCharacter {
	public String name;
	public double health;
	public double power;
	
	public MiddleEarthCharacter(String name, double health, double power){
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	
	void displayInfo() {
		System.out.println("\n*** " + this.name + "'s details:" + "\n* health: " + this.health + "\n* power: " + this.power);
	}
}

class Elf extends MiddleEarthCharacter {
	Elf(String name, double health, double power){
		super(name, health, power);
	}
	@Override boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() != "Elf") & (target.getRace() != "Dwarf")) {
			if (target.getRace() == "Orc") {
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
	String getRace() {
		return "Elf";
	}
}

class Dwarf extends MiddleEarthCharacter {
	Dwarf(String name, double health, double power){
		super(name, health, power);
	}
	@Override boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() != "Wizard") & (target.getRace() != "Dwarf")) {
			if (target.getRace() == "Elf") {
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
	String getRace() {
		return "Dwarf";
	}
}

class Human extends MiddleEarthCharacter {
	Human(String name, double health, double power){
		super(name, health, power);
	}
	@Override boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() != "Orc") & (target.getRace() != "Human")) {
			if (target.getRace() == "Wizard") {
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
	String getRace() {
		return "Human";
	}
}

class Orc extends MiddleEarthCharacter {
	Orc(String name, double health, double power){
		super(name, health, power);
	}
	@Override boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() != "Orc") & (target.getRace() != "Elf")) {
			if (target.getRace() == "Human") {
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
	String getRace() {
		return "Orc";
	}
}

class Wizard extends MiddleEarthCharacter {
	Wizard(String name, double health, double power){
		super(name, health, power);
	}
	@Override boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() != "Wizard") & (target.getRace() != "Human")) {
			if (target.getRace() == "Dwarf") {
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
	String getRace() {
		return "Wizard";
	}
}




/*
class Main {
	public static void main(String[] args) {
		Elf myElf = new Elf("Jeff", 10.1, 50.3);
		Orc myOrc = new Orc("Bob", 11.2, 42.1);
		String testString = myElf.getRace();
		System.out.println(testString);
		System.out.println(myOrc.health);
		boolean testBool = myElf.attack(myOrc);
		System.out.println(testBool);
		System.out.println(myOrc.health);
		myElf.displayInfo();
	}
}
*/

