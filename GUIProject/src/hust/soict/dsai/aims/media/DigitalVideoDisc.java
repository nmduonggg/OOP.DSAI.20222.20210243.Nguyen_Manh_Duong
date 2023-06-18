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

	public String play () {
		return "Playing DVD: " + this.getTitle() + "\n DVD Length: " + this.getLength();
		
	}

}

