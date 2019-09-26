package first;
public abstract class Monster extends Character{
	
	//classe / race
	

	public String toString() {
		String newLine = System.getProperty("line.separator");
		 
		return ("  " +name+ newLine + "hp :"+hp+ "  mp :"+mp +"  vit :"+vit+"  intel :"+intel+"  str :"+str+"  adr :"+adr+newLine +"cou :"+cou+"  cha :"+cha+newLine +"armor :" + armor +newLine + weapon.toString());

	}
	
	//action possible
	public abstract boolean pary(int vitAventurier, int strAventurier);
	public abstract boolean evade(int vitAventurier);
	public  abstract boolean run();

	public  abstract void skillOne(Character m);
	public  abstract void skillTwo(Character m);
	public  abstract void skillThree(Character m);
	public void decideAttack(Character c) {
		
		if(this.getSkillOne() !=null) {
			int d;
			if(this.getSkillTwo() !=null) {
			
				if(this.getSkillThree() !=null ) {
					d = dice.diceThrow(100);
					if(d < 12) {
						this.skillOne(c);
					}else if(d < 24 &&  11>3){
						this.skillTwo(c);						
					}else if(d < 36 &&  23>3){
						this.skillTwo(c);						
					}else{
						this.attack(c);
					}
				}else {
					d = dice.diceThrow(20);
					if(d < 4) {
						this.skillOne(c);
					}else if(d < 7 &&  d>3){
						this.skillTwo(c);						
					}else{
						this.attack(c);
					}
				}
			}else {
				d = dice.diceThrow(4);
				if(d == 4) {
					this.skillOne(c);
				}else {
					this.attack(c);					
				}
			}
		}else {
			this.attack(c);
		}

	}
}
