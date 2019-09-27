package first;
public class Slime extends Monster{
	public Slime(int lvl){
		this.name = "Slime";
		
		this.armor = dice.diceThrow(2)-1;//0 - 1
		hp = 10 + dice.diceThrow(6);
		mp = 0 + dice.diceThrow(6);
		this.setSkillOne("Acid");
		int baseStats =2;
		int baseDice =3;
		this.lvl = lvl;
		xp = lvl* 2;
		vit = baseStats;
		intel = baseStats;
		str = baseStats;
		adr = baseStats;
		luck = baseStats;
		gold = baseStats;
		for(int i = 0;i<lvl*baseDice;i++) {
			int v = dice.diceThrow(5);
			gold = gold+v-1;//dice.diceThrow(baseDice)
			switch(v){
			case 1:
				this.vit =this.vit +1; // dice.diceThrow(baseDice)
				break;
			case 2:
				this.intel = this.intel+1;//+ dice.diceThrow(baseDice)
				break;
			case 3:
				this.str = this.str+1;//dice.diceThrow(baseDice)
				break;
			case 4:
				this.adr = this.adr+1;//dice.diceThrow(baseDice)
				break;
			case 5:
				this.luck = luck+1;// dice.diceThrow(baseDice)
				break;
			}
			
		}
		for(int i = 0;i<lvl ;i++) {
			hp = hp + dice.diceThrow(baseDice);
			mp = mp + dice.diceThrow(baseDice);
		}
		
		
		cou = 4 + dice.diceThrow(6);
		cha = 0 + dice.diceThrow(4);
		weapon = new Weapon();
		weapon.setName("unnarmed");
		weapon.setNb_dice(1);
		weapon.setDice_maxValue(4);
		weapon.setRawDamage(0);
	}
	
	@Override
	public boolean pary(int vitAventurier, int strAventurier) {
		return false;
	}

	@Override
	public boolean evade(int vitAventurier) {
		if(vit > vitAventurier) {
			if(dice.diceThrow(6)<2) {
				return true;
			}else {
				return false;
				
			}
		}else {
			return false;
		}
	}

	@Override
	public boolean run() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void skillOne(Character m) {
		int k = 0;
		if(this.mp > 2) {
			System.out.println(name +" essaie de vous dissoudre :");
			int t = dice.diceThrow(6);
			if(t > 2) {
				if(m.getArmor() >= 2) {
					m.setArmor(m.getArmor()-2);
				}
				else {
					m.setArmor(0);
				}
			}
			this.mp = mp-3;
		}else {
			System.out.println("MP insuffisants, on ne devrait pas pouvoir atteindre ce message");
		}
	
	}

	@Override
	public void skillTwo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skillThree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skillOne() {
		// TODO Auto-generated method stub
		
	}
	
}
