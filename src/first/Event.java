package first;
import java.util.Scanner;

public class Event {
	static void randomEvent(Hero hero, Partie partie) {

		Dice d = new Dice();
		int  a = d.diceThrow(100);

		if(a < 5) {
			//rien
			deception();
		}
		else if(5 <= a && a < 65) {
			//combat
			combat(hero, partie);
		}
		else if(65 <= a && a < 95) {

			marchand(hero);

		}
		else {
			//loot?
			loot();
		}
	}

	static void marchand(Hero hero) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous trouvez ... un marchant!");
		System.out.println("Que voulez vous faire ? ");
		System.out.println(" 1 : Marchander");
		System.out.println(" 2 : Partir");
		Market market = new Market(hero);
		int mark = sc.nextInt();
		int malinois = 53;
		while(malinois != 8) {
			switch(mark) {
			case 1:
				System.out.println("Vous avez  "+hero.getGold()+" d'or, "+hero.getArmor()+" d'armure, "+hero.getNbPotionSoin()+" potion(s) de soin"+hero.getNbPotionMana()+" potion(s) de mana");
				market.demandeActionMarket();
				malinois = sc.nextInt();
				market.actionMarket(malinois, hero);
				break;
			case 2:
				malinois = 8;

				break;
			default:
				malinois = 8;

				System.out.println("market fatal error");
			}
		}
	}

	static void combat(Hero hero, Partie partie) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous trouvez ... de la bastoooon!");
		boolean combat = true;
		Monster m = null;
		while(combat) {
			if(m == null) {
				m = partie.rencontreMonstre(hero);					
			}

			partie.demandeActionCombat();
			combat = partie.doAction(sc.nextInt(), m);	
			if(combat == false && !hero.checkDeath()) {
				hero.xp(m.getXp());
				hero.gold(m.getGold());
				m = null;
			}
		}
	}

	static void loot() {
		System.out.println("Vous trouvez ... un truc?");
		System.out.println("C'etait surement le vent.");
	}

	static void deception() {
		System.out.println("Vous trouvez ... rien du tout.");
	}
}
