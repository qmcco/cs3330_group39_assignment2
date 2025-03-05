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
	String getRace() {
		return "Elf";
	}
}

class Dwarf extends MiddleEarthCharacter {
	Dwarf(String name, double health, double power){
		super(name, health, power);
	}
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
	String getRace() {
		return "Dwarf";
	}
}

class Human extends MiddleEarthCharacter {
	Human(String name, double health, double power){
		super(name, health, power);
	}
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
	String getRace() {
		return "Human";
	}
}

class Orc extends MiddleEarthCharacter {
	Orc(String name, double health, double power){
		super(name, health, power);
	}
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
	String getRace() {
		return "Orc";
	}
}

class Wizard extends MiddleEarthCharacter {
	Wizard(String name, double health, double power){
		super(name, health, power);
	}
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
	String getRace() {
		return "Wizard";
	}
}






