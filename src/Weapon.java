public class Weapon {
	private String name;
	private int nb_dice;
	private int dice_maxValue;
	private int rawDamage;	
	private Dice d= new Dice(); 

	public String toString() {
		 String newLine = System.getProperty("line.separator");
		return ("Vous êtes armé de : "+ newLine+name +"  "+ nb_dice +"D"+dice_maxValue+" +"+ rawDamage);

	}
	public int damage() {
		int k = rawDamage;
		
		for(int i =0;i<nb_dice;i++) {
			k = k+d.diceThrow(dice_maxValue);
			System.out.println("Weapon dice gives "+k +" damage");
		}
		return k;
	}


	public int getDice_maxValue() {
		return dice_maxValue;
	}
	public void setDice_maxValue(int dice_maxValue) {
		this.dice_maxValue = dice_maxValue;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNb_dice() {
		return nb_dice;
	}


	public void setNb_dice(int nb_dice) {
		this.nb_dice = nb_dice;
	}


	public int getRawDamage() {
		return rawDamage;
	}


	public void setRawDamage(int rawDamage) {
		this.rawDamage = rawDamage;
	}
}
