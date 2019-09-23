package first;
public abstract class Monster extends Character{
	
	//classe / race
	
	public boolean checkDeath() {
		boolean b = false;
		if(hp<0) {
			b= true;
			System.out.println(name+" est mort");
		}
		return b;
	}
	
	public String toString() {
		String newLine = System.getProperty("line.separator");
		 
		return ("  " +name+ newLine + "hp :"+hp+ "  mp :"+mp +"  vit :"+vit+"  intel :"+intel+"  str :"+str+"  adr :"+adr+newLine +"cou :"+cou+"  cha :"+cha+newLine +"armor :" + armor +newLine + weapon.toString());

	}
	
	//action possible
	public abstract boolean pary(int vitAventurier, int strAventurier);
	public abstract boolean evade(int vitAventurier);
	public  abstract boolean run();

	public  abstract void skillOne();
	public  abstract void skillTwo();
	public  abstract void skillThree();

}
