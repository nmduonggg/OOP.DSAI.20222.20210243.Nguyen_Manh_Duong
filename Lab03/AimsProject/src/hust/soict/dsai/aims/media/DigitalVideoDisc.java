package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
    private static int nbDigitalVideoDiscs = 0;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}


	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}

    public boolean equal(DigitalVideoDisc disc) {
        if ((category == disc.getCategory())
        && (director == disc.getDirector()) && (length == disc.getLength())
        && (title == disc.getTitle())) {
            return true;
         } else {
        return false;
        }
    }

	public void play () {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
}
