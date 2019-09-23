package first;
public class Wolf extends Monster{
	public Wolf(int lvl){
		this.name = "Wolf";
		
		this.armor = dice.diceThrow(3) -1;//0 - 2
		hp=20;
		mp =8;
		int baseStats =4;
		int baseDice =4;
		this.lvl = lvl;
		xp = lvl * 10;
		vit = baseStats;
		intel = baseStats;
		str = baseStats;
		adr = baseStats;
		luck = baseStats;
		gold = baseStats;
		for(int i = 0;i<lvl;i++) {
			gold = gold+ dice.diceThrow(baseDice);
			hp = hp + dice.diceThrow(8);
			mp = mp + dice.diceThrow(4);
			vit = vit+ dice.diceThrow(baseDice);
			intel = intel+ dice.diceThrow(baseDice);
			str = str+ dice.diceThrow(baseDice);
			adr = adr+ dice.diceThrow(baseDice);
			luck = luck+ dice.diceThrow(baseDice);
			
		}
		
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
