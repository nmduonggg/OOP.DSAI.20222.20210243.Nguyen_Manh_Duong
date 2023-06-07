package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;
	
	public String getAuthor() {
		return author;
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
	public DigitalVideoDisc(String title, String category, String author, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String author, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.length = length;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}

    public boolean equals(DigitalVideoDisc disc) {
        return ((category == disc.getCategory())
        && (author == disc.getAuthor()) && (length == disc.getLength())
        && (title == disc.getTitle()));
    }

	public void play () {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
}
