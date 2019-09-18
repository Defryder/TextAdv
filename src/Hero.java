import java.util.Random;

public class Hero extends Character{
	
	//classe / race
	
	public boolean checkDeath() {
		boolean b = false;
		if(hp<0) {
			b= true;
			System.out.println("Vous êtes mort");
		}
		return b;
	}
	
	public String toString() {
		String newLine = System.getProperty("line.separator");
		 
		return ("Vous êtes le guerrier " +name+ newLine + "hp :"+hp+ "  mp :"+mp +"  vit :"+vit+"  intel :"+intel+"  str :"+str+"  adr :"+adr+newLine +"cou :"+cou+"  cha :"+cha+newLine +"armor :" + armor +newLine + weapon.toString());

	}

	
	//constructeur
	public Hero(String name){
		this.name = name;
		
		this.armor = 1;
		hp=25 + dice.diceThrow(6)+dice.diceThrow(6);
		mp =10 + dice.diceThrow(6);
		hpMax = hp;
		mpMax = mp;
		vit = 4+ dice.diceThrow(3);
		intel = 4+ dice.diceThrow(3);
		str = 4+ dice.diceThrow(3);
		adr = 4+ dice.diceThrow(3);
		
		cou = 7+ dice.diceThrow(6);
		cha= 7+ dice.diceThrow(6);
		weapon = new Weapon();
		weapon.setName("épée en fer");
		weapon.setNb_dice(1);
		weapon.setDice_maxValue(6);
		weapon.setRawDamage(1);
	}
	
	//action possible
	public void attack(Monster m){
		
		System.out.println("Vous attaquez :");
		int degat = this.getWeapon().damage();
		if(degat>m.getArmor()) {
			m.setHp(m.getHp() - (degat - m.getArmor()));
			System.out.println("Vous infligez " + degat + ",il perd " + (degat - m.getArmor()) + " HP");				
//			System.out.println("Il lui reste " + m.getHp() + " HP");					
		}else {
			System.out.println("Son armure l'a protégé");				
			
		}
	}
	public void potionSoin() {
		 int d =5 +dice.diceThrow(6);
		 if(hp+d<hpMax) {
			hp=hp+d;
			System.out.println("Vous vous êtes soignée de "+d+" vous avez maintenant "+hp+"HP");			 
		 }else {
			 hp = hpMax;
			 System.out.println("Vous vous êtes totalement soignée, vous avez maintenant "+hp+"HP");
		 }
	}
	public void pary(){
		
	}
	public void evade(){
		
	}
	public boolean run(){
		return false;
		
	}

	@Override
	public boolean pary(int vitAtacker, int strAtacker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evade(int vitAtacker) {
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
