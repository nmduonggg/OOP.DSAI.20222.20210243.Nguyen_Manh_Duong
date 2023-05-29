import javax.lang.model.type.NullType;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	private int qtyOrdered;
	private float cost;

	public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if ((itemsOrdered[i] == null) && (qtyOrdered < MAX_NUMBERS_ORDERED)) {
				itemsOrdered[i] = disc;
				qtyOrdered = qtyOrdered + 1;
				return true;
			}
		} return false;
	}

	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			DigitalVideoDisc curr_disc = itemsOrdered[i];
			if ((curr_disc != null) & (curr_disc.getCategory() == disc.getCategory()) && (curr_disc.getClass() == disc.getClass())
				&& (curr_disc.getDirector() == disc.getDirector()) && (curr_disc.getLength() == curr_disc.getLength())
				&& (curr_disc.getTitle() == disc.getTitle())) {
					itemsOrdered[i] = null;
					qtyOrdered = qtyOrdered - 1;
					return true;
				}
		} return false;
	}

	public float totalCost() {
		float res = (float)0.0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
			if (itemsOrdered[i] != null){
				res = res + itemsOrdered[i].getCost();
			}
		}
		return res;
	}
}
