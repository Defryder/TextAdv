package first;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir un nom : ");
		String name = sc.nextLine();
		Hero hero = new Hero(name);
		Partie partie = new Partie(hero);

		partie.start(name);
		boolean event = false;
		boolean stop = false;
		boolean stats = false;
		int action = 255;
		while(stop == false) {
			System.out.println(hero.toString());
			while(event == false && stats == false) {
				partie.demandeActionHorsCombat();
				action = sc.nextInt();
				if(action == 0) {
					event = partie.doActionHorsCombat(action);						
				}else{
					stats = partie.doActionHorsCombat(action);	
				}
			}

			while(stats == true) {
				partie.demandeActionStats();
				action = sc.nextInt();
				stats = partie.doActionStats(action);	
			}
			
  			if(event == true) {
				Event.randomEvent(hero, partie);
				event = false;
			}
			stop = hero.checkDeath();
		}
		System.out.println("Vous êtes mort");
		System.out.println("Now playing \"Sad_kazoo.mp3\"");
	}
}
