import java.util.Random;

public class Dice {

	public int diceThrow(int a) {
		Random rnd= new Random();
		int d = rnd.nextInt();
		if( d<0) {
			d=-d;
		}
		d = d%a;
		return d+1;
	}
	
}
