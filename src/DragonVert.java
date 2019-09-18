
public class DragonVert extends Monster{
	public DragonVert(){
		this.name = "Green Dragon";
		
		this.armor = dice.diceThrow(2) + 1;//2 - 3
		hp=30 + dice.diceThrow(15);
		mp =12 + dice.diceThrow(10);
		int baseStats =5;
		int baseDice =5;
		
		vit = baseStats+ dice.diceThrow(baseDice);
		intel = baseStats+ dice.diceThrow(baseDice);
		str = baseStats+ dice.diceThrow(baseDice);
		adr = baseStats+ dice.diceThrow(baseDice);
		
		cou = 8+ dice.diceThrow(7);
		cha= 8+ dice.diceThrow(5);
		
		weapon = new Weapon();
		weapon.setName("Claws");
		weapon.setNb_dice(1);
		weapon.setDice_maxValue(6);
		weapon.setRawDamage(4);
			
		
	}
	
	@Override
	public boolean pary(int vitAventurier, int strAventurier) {
		return false;
	}

	@Override
	public boolean evade(int vitAventurier) {
			return false;
	}

	@Override
	public boolean run() {
		return false;
	}

	@Override
	public void skillOne() {
		//queue du dragon //swipe   ???
	}

	@Override
	public void skillTwo() {
// coup de croc		
	}

	@Override
	public void skillThree() {
	//souffle du dragon	
	}
	
}
