
public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sience Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);

		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());

		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.removeDigitalVideoDisc(dvd3);

		anOrder.addDigitalVideoDisc(dvd1, dvd3, dvd2);
		// anOrder.removeDigitalVideoDisc(dvd1);
		// anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("Total cost after removing dvd3: ");
		System.out.println(anOrder.totalCost());

		System.out.println(DigitalVideoDisc.nbDigitalVideoDiscs);
	}
}
