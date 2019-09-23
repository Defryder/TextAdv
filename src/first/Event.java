package first;
import java.util.Scanner;

public class Event {
	static void randomEvent(Hero hero, Partie partie) {
		Dice d = new Dice();
		int  a = d.diceThrow(100);

		if(a < 5) {
			//rien
			System.out.println("Vous trouvez ... rien du tout.");
		}
		else if(5 <= a && a < 65) {
			//combat
			System.out.println("Vous trouvez ... de la bastoooon!");
			boolean combat = true;
			Monster m = null;
			while(combat) {
				if(m == null) {
					m = partie.rencontreMonstre(hero);					
				}

				partie.demandeActionCombat();
				Scanner sc = new Scanner(System.in);
				combat = partie.doAction(sc.nextInt(), m);	
				if(combat == false) {
					hero.xp(m.getXp());
					hero.gold(m.getGold());
					m = null;
				}
			}
		}
		else if(65 <= a && a < 95) {
			System.out.println("Vous trouvez ... un marchant!");
			System.out.println("Que voulez vous faire ? ");
			System.out.println(" 1 : Marchander");
			System.out.println(" 2 : Partir");
			Scanner sc = new Scanner(System.in);
			Market market = new Market();
			int mark = sc.nextInt();
			switch(mark) {
			case 1:
				market.demandeActionMarket();
				int malinois = sc.nextInt();
				market.actionMarket(malinois, hero);
				break;
			case 2:
				break;
			default:
				System.out.println("market fatal error");
			}
		}
		else {
			//loot?
			System.out.println("Vous trouvez ... un truc?");
		}
	}
}
