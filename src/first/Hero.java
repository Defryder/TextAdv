
package first;

public class Hero extends Character{
	
	//classe / race
	
	private	int addStat;
	private int nbPotionSoin;
	private int nbPotionMana;
	public int getNbPotionMana() {
		return nbPotionMana;
	}

	public void setNbPotionMana(int nbPotionMana) {
		this.nbPotionMana = nbPotionMana;
	}

	public int getAddStat() {
		return addStat;
	}

	public void setAddStat(int addStat) {
		this.addStat = addStat;
	}

	public boolean checkDeath() {
		boolean b = false;
		if(hp<=0) {
			b= true;
		}
		return b;
	}
	
	public String troString() {
		String newLine = System.getProperty("line.separator");
		 
		return ("Vous êtes le guerrier " +name+ newLine + "lvl :"+lvl+"  xp :"+xp+"  hp :"+hp+ "  mp :"+mp +"  vit :"+vit+"  intel :"+intel+"  str :"+str+"  adr :"+adr+newLine +"cou :"+cou+"  cha :"+cha+newLine +"armor :" + armor +newLine + weapon.toString());

	}
	
	@Override
	public String toString() {
		String newLine = System.getProperty("line.separator");
		return "Hero [" + name +"   hp=" + hp +"/"+hpMax+ ", mp=" + mp +"/"+mpMax
				 + ", xp=" + xp + ", gold=" + gold + ", lvl=" + lvl+ 
				newLine+ ", cha=" + cha + ", vit=" + vit + ", intel=" + intel + ", adr="
				+ adr + ", str=" + str + ", cou=" + cou +  ", luck=" + luck+
				newLine+"addStat=" + addStat + ", nbPotionSoin=" + nbPotionSoin +
				newLine+ ", armor=" + armor + ", weapon=" + weapon.toString() + "]";
	}

	public void xp(int xpGagne){
		xp = xp+xpGagne;
		while( xp>=lvl*lvl*10) {
			
			xp = xp - lvl*lvl*10;
			lvl++;
			System.out.println(("Vous gagnez un niveau "));
			 //TODO a passer en global et choix sur l'augmentation dans les niveaux
			addStat= addStat + 5;
			hpMax = hpMax+dice.diceThrow(6);
			mpMax = mpMax + dice.diceThrow(4);
			hp=hpMax;
			mp =mpMax;
			
		}
		
	}
	
	
	public void gold(int gold){
		System.out.println("Vous avez gagné "+gold+ " d'or!");
		this.gold = this.gold+gold;
	}
	
	//constructeur
	public Hero(String name){
		this.name = name;
		this.nbPotionSoin = 5;
		this.nbPotionMana = 2;
		this.SkillOne = "Flying Slash";
		this.SkillTwo = "";
		this.SkillThree = "";
		this.armor = 1;
		hp=25 + dice.diceThrow(6)+dice.diceThrow(6);
		mp =10 + dice.diceThrow(6);
		hpMax = hp;
		mpMax = mp;
		vit = 4+ dice.diceThrow(3);
		intel = 4+ dice.diceThrow(3);
		str = 4+ dice.diceThrow(3);
		adr = 4+ dice.diceThrow(3);
		lvl = 1;
		xp = 0;
		cou = 7+ dice.diceThrow(6);
		cha= 7+ dice.diceThrow(6);
		addStat = 0;
		weapon = new Weapon();
		weapon.setName("épée en fer");
		weapon.setNb_dice(1);
		weapon.setDice_maxValue(6);
		weapon.setRawDamage(1);
	}
	
	public int getNbPotionSoin() {
		return nbPotionSoin;
	}

	public void setNbPotionSoin(int nbPotionSoin) {
		this.nbPotionSoin = nbPotionSoin;
	}

	//action possible
//	public void attack(Monster m){
//		
//		System.out.println("Vous attaquez :");
//		int degat = this.getWeapon().damage();
//		if(degat>m.getArmor()) {
//			m.setHp(m.getHp() - (degat - m.getArmor()));
//			System.out.println("Vous infligez " + degat + ",il perd " + (degat - m.getArmor()) + " HP");				
////			System.out.println("Il lui reste " + m.getHp() + " HP");					
//		}else {
//			System.out.println("Son armure l'a protégé");				
//			
//		}
//	}
	public void potionSoin() {
		if(nbPotionSoin > 0) {
			nbPotionSoin --;
			int d =5 +dice.diceThrow(6);
			if(hp+d<hpMax) {
				hp=hp+d;
				System.out.println("Vous vous êtes soignée de "+d+" vous avez maintenant "+hp+"HP");			 
			}else {
				hp = hpMax;
				System.out.println("Vous vous êtes totalement soignée, vous avez maintenant "+hp+"HP");
			}			
		}else {
			System.out.println("Vous n'avez plus de potion de soin");
		}
	}
	public void potionMana() {
		if(nbPotionMana>0) {
			 int d =3 +dice.diceThrow(3);
			 if(mp+d<mpMax) {
				 mp=mp+d;
				System.out.println("Vous avez récupérer "+d+"mp, vous avez maintenant "+mp+"MP");			 
			 }else {
				 mp = mpMax;
				 System.out.println("Vous avez récupéré tous vos "+mp+"MP");
			 }			
		}else {
			System.out.println("Vous n'avez plus de potion de mana");
		}
	}
	
	public void pary(){
		
	}
	public void evade(){
		
	}
	public boolean run(){
		return false;
		
	}
	public boolean isHero() {
		return true;
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
	public void skillOne(Character m) {
		int k = 0;
		if(this.mp>7) {
			System.out.println("Une lame d'air fond sur le l'ennemi :");
			this.mp = mp-8;
			k= 8+dice.diceThrow(8)*((this.intel/5)) - m.getArmor();
			if(k>0) {
				m.setHp(m.getHp()- k);				
				System.out.println("vous infligez "+ k+"HP");
			}else {
				System.out.println("elle s'écrase sur l'armure de votre adversaire qui vous toise en ayant l'impression qu'un moustique l'a piqué");
			}
		}else {
			System.out.println("une douce brise rafraichit votre adversaire, vos MP sont insuffisants");
			this.setMp(0);
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
