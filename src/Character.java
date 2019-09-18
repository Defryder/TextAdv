
public abstract class  Character {

	//attribut 
	protected int hp;
	protected int mp;

	protected int hpMax;
	protected int mpMax;
	protected int luck;
	
	
	protected String name;
	
	protected Dice dice = new Dice();
//	int atk;
//	int def;
	
	protected int cha;
	protected int vit;
	protected int intel;
	protected int adr;
	protected int str;
	protected int cou;

	protected int armor;	
	protected Weapon weapon;
	
	//classe / race
	
	public boolean checkDeath() {
		boolean b = false;
		if(hp<0) {
			b= true;
			System.out.println("" +name +" êtes mort");
		}
		return b;
	}
	
	public String toString() {
		String newLine = System.getProperty("line.separator");
		 
		return ("  " +name+ newLine + "hp :"+hp+ "  mp :"+mp +"  vit :"+vit+"  intel :"+intel+"  str :"+str+"  adr :"+adr+newLine +"cou :"+cou+"  cha :"+cha+newLine +"armor :" + armor +newLine + weapon.toString());

	}
	
	//action possible
	public abstract boolean pary(int vitAtacker, int strAtacker);
	public abstract boolean evade(int vitAtacker);
	public  abstract boolean run();
	public void attack(Character hero) {
		System.out.println("Le gobelin vous attaque :");
		int degat = this.getWeapon().damage();
		if(degat>hero.getArmor()) {
			hero.setHp(hero.getHp() - (degat - hero.getArmor()));
			System.out.println("Le gobelin vous inflige " + degat + ",vous perdez " + (degat - hero.getArmor()) + " HP");				
			System.out.println("Il vous reste " + hero.getHp() + " HP");					
		}else {
			System.out.println("Votre armure vous a protégé");				
			
		}
	}

	public  abstract void skillOne();
	public  abstract void skillTwo();
	public  abstract void skillThree();

	
	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getMpMax() {
		return mpMax;
	}

	public void setMpMax(int mpMax) {
		this.mpMax = mpMax;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public int getVit() {
		return vit;
	}
	public void setVit(int vit) {
		this.vit = vit;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getCou() {
		return cou;
	}
	public void setCou(int cou) {
		this.cou = cou;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdr() {
		return adr;
	}

	public void setAdr(int adr) {
		this.adr = adr;
	}
}
