package Item;
import first.Hero;
import first.Dice;

public class Potion extends Item{
	private String name;
	
	public boolean isPotion() {
		return true;
	}
	
	public void action(Hero hero){
		Dice dice = new Dice();
		switch(name) {
		case "Potion de Soin":
			 int d =5 +dice.diceThrow(6);
			 if(hero.getHp()+d<hero.getHpMax()) {
				 hero.setHp(hero.getHp()+d);
				System.out.println("Vous vous êtes soignée de "+d+" vous avez maintenant "+hero.getHp()+"HP");			 
			 }else { 
				 hero.setHp(hero.getHpMax());
				 System.out.println("Vous vous êtes totalement soignée, vous avez maintenant "+hero.getHp()+"HP");
			 }
			break;
		case "Potion de Soin II":
			
			break;
		case "Potion de Mana":
			
			break;
		case "Potion de Mana II":
			
			break;
		case "Potion de poison":
			
			break;
		case "Potion Berserk":
			
			break;
		}
	}
	
}
