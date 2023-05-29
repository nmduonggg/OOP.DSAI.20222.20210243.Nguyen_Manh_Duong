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
			if (curr_disc != null) {
				if ((curr_disc.getCategory() == disc.getCategory()) && (curr_disc.getClass() == disc.getClass())
					&& (curr_disc.getDirector() == disc.getDirector()) && (curr_disc.getLength() == curr_disc.getLength())
					&& (curr_disc.getTitle() == disc.getTitle())) {
						itemsOrdered[i] = null;
						qtyOrdered = qtyOrdered - 1;
						return true;
					}
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

	// public boolean addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
	// 	int n = dvdList.length;
	// 	if (qtyOrdered + n <= MAX_NUMBERS_ORDERED){
	// 		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
	// 			for (int j = 0; j < n; j++){
	// 				if (itemsOrdered[i] == null){
	// 					itemsOrdered[i] = dvdList[j];
	// 				}
	// 			}
	// 		} return true;
	// 	} else {return false;}
	// }

	public boolean addDigitalVideoDisc(DigitalVideoDisc... discs){
		int n = discs.length;
		boolean place[] = new boolean[n];
		if (qtyOrdered + n <= MAX_NUMBERS_ORDERED){
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
				for (int j = 0; j < n; j++){
					if ((itemsOrdered[i] == null) && (!place[j])){
						itemsOrdered[i] = discs[j];
						place[j] = true;
					}
				}
			} return true;
		} else {
				return false;
			}
	}

	public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		boolean place1 = false;
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
				if ((!place1) && (itemsOrdered[i] != null)) {
					itemsOrdered[i] = dvd1;
					place1 = true;
				} else if (place1 && (itemsOrdered[i] == null)){
					itemsOrdered[i] = dvd2;
					break;
				}
			} return true;
		} else {
			return false;
		}
	}
}
