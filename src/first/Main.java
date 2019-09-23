package first;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Market market = new Market();
		System.out.println("test");
		System.out.println("Veuillez choisir un nom : ");
		String name = sc.nextLine();
		Hero hero = new Hero(name);
		Partie partie = new Partie(hero);
		System.out.println(hero.toString());

		partie.start(name);
		boolean combat = false;
		boolean stop = false;
		boolean stats = false;
		int action = 255;
		Monster m =null;
		int nbCombat = 0;
		while(stop == false) {
			while(combat == false && stats == false) {
				partie.demandeActionHorsCombat();
				action= sc.nextInt();
				if(action == 0) {
					combat = partie.doActionHorsCombat(action);						
				}else{
					stats = partie.doActionHorsCombat(action);	
				}
			}

			while(stats == true) {
				partie.demandeActionStats();
				action= sc.nextInt();
				stats = partie.doActionStats(action);	

			}
			
			while(combat == true) {

				if(m ==null) {
					m= partie.rencontreMonstre(hero);					
				}

				partie.demandeActionCombat();
				action= sc.nextInt();
				combat = partie.doAction(action, m);	
				if(combat == false) {
					nbCombat ++;
					hero.xp(m.getXp());
					hero.gold(m.getGold());
					m =null;
				}
			
			}
			System.out.println(hero.toString());
			if(nbCombat %3 == 0) {
				System.out.println("Félicitation, vous avez battu 5 monstres voulez vous vous rendre au marché?(0/1)");
				int mark = sc.nextInt();
				switch(mark) {
				case 0:
					market.demandeActionMarket();
					int malinois= sc.nextInt();
					market.actionMarket(malinois, hero);
					break;
				case 1:
					break;
				}
				
			}
		}			
	}

	
}
