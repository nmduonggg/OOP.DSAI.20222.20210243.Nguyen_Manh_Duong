package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc {
	
	public String getAuthor() {
		return author;
	}
	public int getLength() {
		return length;
	}


	public DigitalVideoDisc(int id, String title) {
		super(id, title);
	}
	
	public DigitalVideoDisc (String title) {
		super(title);
	}

	public void play () {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}

}

