
public class Goblin extends Monster{
	public Goblin(){
		System.out.println("Ta mere     en sliiiiiiiip!!");
		this.name = "Goblin";
		
		this.armor = dice.diceThrow(2)-1;//0 - 1
		hp=10 + dice.diceThrow(6);
		mp =0 + dice.diceThrow(6);

		vit = 2+ dice.diceThrow(3);
		intel = 2+ dice.diceThrow(3);
		str = 2+ dice.diceThrow(3);
		adr = 2+ dice.diceThrow(3);
		
		cou = 4+ dice.diceThrow(6);
		cha= 0+ dice.diceThrow(4);
		if(dice.diceThrow(6)>4) {
			weapon = new Weapon();
			weapon.setName("gourdin");
			weapon.setNb_dice(1);
			weapon.setDice_maxValue(6);
			weapon.setRawDamage(0);
			
		}else {
			weapon = new Weapon();
			weapon.setName("unnarmed");
			weapon.setNb_dice(1);
			weapon.setDice_maxValue(4);
			weapon.setRawDamage(0);
		}
	}
	
	@Override
	public boolean pary(int vitAventurier, int strAventurier) {
		if(weapon.getName().equals("gourdin")) {
			int a = 2;
			if(vitAventurier<vit) {
				a++;
			}
			if(strAventurier<str) {
				a++;
			}
			if(dice.diceThrow(6)<a) {
				return true;
			}else {
				return false;
				
			}
		}else {
			return false;
		}
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
	public void skillOne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skillTwo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skillThree() {
		// TODO Auto-generated method stub
		
	}
	
}