package first;
public class Partie {
	private Hero hero;
//	private Map map;
	Partie(Hero hero){
		this.hero = hero; 
	}
	public void start(String name) {
		
		System.out.println("Bonjour, Sir  "+name);
		System.out.println("Vous êtes un guerrier de niveau 1");
		
		
		System.out.println("Vous devez traversez une forêt afin d'atteindre la prochaine ville ");
		
		System.out.println("Vous entrer dans la forêt, vous rencontrer un monstre");
				
	}
	
	public Monster rencontreMonstre(Hero hero) {
		Dice d = new Dice();
		int  a = d.diceThrow(100);
		Monster m; 
		int lvlvl = hero.getLvl() +d.diceThrow(5) - 3;
		if(lvlvl<1) {
			lvlvl = 1;
		}
		if(a <5) {
			m= new DragonVert(lvlvl); 
		}else if(5 <= a && a < 40) {
			m= new Wolf(lvlvl); 			
		}else {
			m= new Goblin(lvlvl); 
		}
		
		System.out.println();
		System.out.println(m.toString());
		return m;
	}
	public void demandeActionCombat(){
		System.out.println("Que voulez vous faire ? ");
		System.out.println(" 1 : Attaquer");
		System.out.println(" 2 : Utiliser une potion");
		System.out.println(" 3 : Fuir");
//		System.out.println(" 1 : Skill 1");
//		System.out.println(" 1 : Skill 2");
//		System.out.println(" 1 : Skill 3");
		
	}
	public boolean doAction(int action, Monster m) {
		boolean combat =  true;
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
				m.attack(hero);
				combat = !hero.checkDeath();
				combat = !m.checkDeath();
			
			}
			break;
		}
		return combat;
	}
	public boolean doActionHorsCombat(int action) {
		boolean combat =  false;
		switch(action) {
		case 0: // avancer
			combat =  true; // on va changer combat dans le main
			break;
		case 2: // popo soin
			hero.potionSoin();
			break;

		case 4: //go Stat
			combat = true; // on va changer stats dans le main
			break;
//			case 3:
//			break;
//		case 5:
//			break;
//		case 6:
//			break;
//		case 7:
//			break;
//		case 8:
//			break;
//		case 9:
//			break;
		}
		return combat;
	}
	public boolean doActionStats(int action) {
		boolean stats =  true;
		switch(action) {
		case 1:
			if(hero.getAddStat() >0) {
				hero.setStr(hero.getStr()+1);
				hero.setAddStat(hero.getAddStat()-1);				
			}else {
				System.out.println("pas assez de points pour ajouter des stats");
			}
			break;
		case 2:
			if(hero.getAddStat() >0) {
				hero.setVit(hero.getVit()+1);
				hero.setAddStat(hero.getAddStat()-1);				
			}else {
				System.out.println("pas assez de points pour ajouter des stats");
			}
			break;
		case 3:
			if(hero.getAddStat() >0) {
				hero.setAdr(hero.getAdr()+1);
				hero.setAddStat(hero.getAddStat()-1);				
			}else {
				System.out.println("pas assez de points pour ajouter des stats");
			}
			break;
		case 4:
			if(hero.getAddStat() >0) {
				hero.setIntel(hero.getIntel()+1);
				hero.setAddStat(hero.getAddStat()-1);				
			}else {
				System.out.println("pas assez de points pour ajouter des stats");
			}
			break;
		case 5:
			if(hero.getAddStat() >0) {
				hero.setLuck(hero.getLuck()+1);
				hero.setAddStat(hero.getAddStat()-1);				
			}else {
				System.out.println("pas assez de points pour ajouter des stats");
			}
			break;
		case 6:
			hero.potionSoin();
			break;
		case 7:
			hero.potionMana();
			break;
		case 8:
			stats = false;
			break;
		case 9:
			break;
		}

		return stats;
	}
	public void demandeActionHorsCombat(){
		System.out.println("Que voulez vous faire ? ");
		System.out.println(" 0 : Avancer");
		System.out.println(" 2 : Utiliser une potion de soin");
//		System.out.println(" 3 : Ouvrir l'inventaire");
		System.out.println(" 4 : Voir vos caractéristiques");
		
	}

	public void demandeActionStats(){
		System.out.println("Que voulez vous faire ? ");
		System.out.println(" 1 : ajoutez 1pt en Force");
		System.out.println(" 2 : ajoutez 1pt en Vitesse");
		System.out.println(" 3 : ajoutez 1pt en Adresse");
		System.out.println(" 4 : ajoutez 1pt en Intel");
		System.out.println(" 5 : ajoutez 1pt en Luck");

		System.out.println(" 6 : Utiliser une potion de soin");
		System.out.println(" 7 : Utiliser une potion de mana");

		System.out.println(" 8 : Sortir");		
	}	
	
}
