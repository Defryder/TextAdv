package Item;

public abstract class Item {
	protected float poids;

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}
	public boolean isPotion() {
		return false;
	}
}
