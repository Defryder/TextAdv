import java.util.Scanner;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Partie partie = new Partie();
		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez choisir un nom : ");
		String name = sc.nextLine();
		Hero hero = new Hero(name);
		System.out.println(hero.toString());

		partie.start(name);
		Monster m = partie.rencontreMonstre();
		boolean combat = true;
		while(combat == true) {
			partie.demandeAction();
			int action= sc.nextInt();
			int degat;
			switch(action) {
			case 1:
				if(m.getCou()<hero.getCou()) {
					hero.attack(m);
					combat = !m.checkDeath();
					if(combat ==false) {
						break;
					}
					m.attack(hero);
					combat = !hero.checkDeath();
				}else{
					System.out.println("Le "+m.getName()+" est plus courageux que vous");				
					m.attack(hero);
					combat = !hero.checkDeath();
					if(combat ==false) {
						break;
					}
					hero.attack(m);
					combat = !m.checkDeath();
				}
				break;
			case 2:
				if(m.getCou()<hero.getCou()) {
					hero.potionSoin();
					m.attack(hero);
					combat = !hero.checkDeath();
				}else{
					System.out.println("Le "+m.getName()+" est plus courageux que vous");				
					m.attack(hero);
					combat = !hero.checkDeath();
					if(combat ==false) {
						break;
					}
					hero.potionSoin();
				}
				break;
			case 3:
				if(m.getVit()<hero.getVit()) {
					System.out.println("Vous réussissez à vous enfuir");				
					combat =false;
				}else{
					System.out.println("Le "+m.getName()+" est plus rapide que vous, il vous poursuit et vous touche dans le dos");				
					degat = m.getWeapon().damage();
					m.attack(hero);
					combat = !hero.checkDeath();
					combat = !m.checkDeath();
				
				}
				break;
			}
			
		}

	}

}
