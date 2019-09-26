package first;

public class Market {
	
	private int armor = 0;
	
	public Market(Hero hero) {
		armor = hero.getArmor();
	}

	public void demandeActionMarket() {

		int a = armor * 10 ;
		System.out.println("Le marché est ouvert: ");			
		System.out.println(" 1 : achetez 1 pt d'armure  ("+a+"po)");
		System.out.println(" 2 : achetez 1 potion de soin (15 po)");
		System.out.println(" 3 : ajoutez 1 potion de mana (20 po)");

//		System.out.println(" 4 : ajoutez 1pt en Intel");
//		System.out.println(" 5 : ajoutez 1pt en Luck");
//
//		System.out.println(" 6 : Utiliser une potion de soin");
//		System.out.println(" 7 : Utiliser une potion de mana");

		System.out.println(" 8 : Sortir");		

	}
	
	public void actionMarket(int mar , Hero hero) {
		switch(mar) {
		case 1:
			if (hero.getGold() >= armor * 10) {
				hero.setGold(hero.getGold() - armor * 10 );
				armor++;
				hero.setArmor(hero.getArmor()+1);
				
			}else {
				System.out.println("vous n'avez pas assez d'or!");
			}
			break;
		case 2:
			if (hero.getGold() >= 15) {
				hero.setNbPotionSoin(hero.getNbPotionSoin() + 1 );
				hero.setGold(hero.getGold()-15);
			}else {
				System.out.println("vous n'avez pas assez d'or!");
			}
			break;
		case 3:
			if (hero.getGold() >= 20) {
				hero.setNbPotionMana(hero.getNbPotionMana() + 1 );
				hero.setGold(hero.getGold()-20);
			}else {
				System.out.println("vous n'avez pas assez d'or!");
			}
			break;
		case 8:
			break;
		}

	}
	
}
