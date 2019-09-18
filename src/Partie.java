
public class Partie {
	private Hero hero;
	private Map map;
	public void start(String name) {
		
		System.out.println("Bonjour, Sir  "+name);
		System.out.println("Vous êtes un guerrier de niveau 1");
		
		
		System.out.println("Vous devez traversez une forêt afin d'atteindre la prochaine ville ");
		try {
			Thread.sleep(5);
			
		}catch(Exception e) {
			
		}
		System.out.println("Vous entrer dans la forêt, vous rencontrer un monstre");
				
	}
	
	public Monster rencontreMonstre() {
		Monster gob = new Goblin();
		System.out.println();
		System.out.println(gob.toString());
		return gob;
	}
	public void demandeAction(){
		System.out.println("Que voulez vous faire ? ");
		System.out.println(" 1 : Attaquer");
		System.out.println(" 2 : Utiliser une potion");
		System.out.println(" 3 : Fuir");
//		System.out.println(" 1 : Skill 1");
//		System.out.println(" 1 : Skill 2");
//		System.out.println(" 1 : Skill 3");
		
	}
	
	
}
