import java.util.Scanner;

public class Map {

	// Attributs
	private double L;
	private double l;	
	private int nb_floors;
	private static int[][] map1 = new int [23][19];
	private static int[] position = new int [2];
	
	public int[] getPosition() {
		return position;
	}
	public static void setPosition(int i, int j) {
		position[0] = i;
		position[1] = j;
	}
	public static void createMap1() {
		for (int i = 1; i<=3; i++) {
			map1[i][1] = 1;
			map1[i][2] = 1;
			map1[i][3] = 1;
		}
		map1[2][4] = 1; map1[2][5] = 1;
		for (int i = 1; i<=4; i++) {
			map1[i][6] = 1;
			map1[i][7] = 1;
			map1[i][8] = 1;
		}
		map1[5][8] = 1; map1[6][8] = 1;
		for (int i = 7; i<=11; i++) {
			map1[i][5] = 1;
			map1[i][6] = 1;
			map1[i][7] = 1;
			map1[i][8] = 1;
		}
		map1[12][7] = 1; map1[13][7] = 1;
		for (int i = 14; i<=18; i++) {
			map1[i][5] = 1;
			map1[i][6] = 1;
			map1[i][7] = 1;
			map1[i][8] = 1;
			map1[i][9] = 1;
		}
		map1[10][9] = 1; map1[10][10] = 1;
		for (int j = 11; j<=17; j++) {
			map1[9][j] = 1;
			map1[10][j] = 1;
			map1[11][j] = 1;
		}
		for (int i = 3; i<=5; i++) {
			map1[i][12] = 1;
			map1[i][13] = 1;
			map1[i][14] = 1;
			map1[i+3][13] = 1;
		}
		for (int j = 10; j<=13; j++) {
			map1[16][j] = 1;
		}
		for (int i = 12; i<=18; i++) {
			map1[i][14] = 1;
		}
		for (int i = 19; i<=21; i++) {
			map1[i][13] = 1;
			map1[i][14] = 1;
			map1[i][15] = 1;
		}
		setPosition(10,17);
	}
	
	public static void printMap(int[][] tab) {
		for (int j = 0; j<19; j++) {
			for (int i = 0; i<23; i++) {
				if (i == position[0] && j == position[1]) {
					System.out.print("☺");
				} else {
					if (tab[i][j] == 0) {
						System.out.print("█");
						
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void joue(int[][] map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Pour avancer : 1=haut 2=bas 3=droite 4=gauche");
		int avancer = 10;
		try {
			avancer = sc.nextInt();
		} catch (Exception e) {}
		if (avancer==1 && map[position[0]][position[1]-1] == 1) {
			// haut
			position[1] = position[1]-1;
		} else if (avancer==2 && map[position[0]][position[1]+1] == 1) {
			// bas
			position[1] = position[1]+1;
		} else if (avancer==3 && map[position[0]+1][position[1]] == 1) {
			// droite
			position[0] = position[0]+1;
		} else if (avancer==4 && map[position[0]-1][position[1]] == 1) {
			// gauche
			position[0] = position[0]-1;
		} else {
			System.out.println("Erreur recommence");
			joue(map);
		}
		printMap(map);
	}

	public static void main(String[] args) {
		createMap1();
		printMap(map1);
		while(true) {
			joue(map1);
		}
	}
}
