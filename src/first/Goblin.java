package first;
public class Goblin extends Monster{
	public Goblin(int lvl){
		this.name = "Goblin";
		
		this.armor = dice.diceThrow(2)-1;//0 - 1
		hp=10 + dice.diceThrow(6);
		mp =3 + dice.diceThrow(2);
		this.setSkillOne("Smash");
		this.setSkillTwo(null);
		this.setSkillThree(null);
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
			hp = hp + dice.diceThrow(baseDice+1);
			mp = mp + dice.diceThrow(baseDice-1);
			if(i%4 == 0) {
				this.armor ++;
			}
		}
		
		
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
	public void skillOne(Character m) {
		int k = 0;
		if(this.mp>4) {
			System.out.println(name +" essaie de vous smasher :");
			int t = dice.diceThrow(6);
			if(this.weapon.getName() == "gourdin" ) {
				k= 6+t*((this.str/5)) - m.getArmor();				
			}else{  //unnarmed
				k= 4+t*((this.str/5)) - m.getArmor();
				this.setHp(hp - t );
				System.out.println("Il s'inflige "+t+"HP en vous smashant à main nue!");

			}
			if(k>0) {
				m.setHp(m.getHp()- k);	
				System.out.println(name+" inflige "+ (k+m.getArmor())+"dégats, vous perdez "+k+"HP");
			}else {
				System.out.println("Votre armure vous protège");
			}
			if(t > 3) {
				m.setArmor(m.getArmor()-1);
				System.out.println("Vous perdez un point d'armure");
			}
			this.mp = mp-5;
		}else {
//			System.out.println("MP insuffisants, on ne devrait pas pouvoir atteindre ce message");
			m.attack(m);
		}
	
	}

	@Override
	public void skillTwo(Character m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skillThree(Character m) {
		// TODO Auto-generated method stub
		
	}
	
}
