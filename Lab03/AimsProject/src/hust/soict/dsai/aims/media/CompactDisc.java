package hust.soict.dsai.aims.media;
import java.util.*;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public String getArtist() {
        return artist;
    }

    public void addTrack (Track track) {
        if (!(tracks.contains(track))){
            tracks.add(track);
            System.out.println("Add successfully !");
        } else {System.out.println("Track is added before");}
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Remove successfully");
        } else {
            System.out.println("No matching found");
        }
    }

    public int getLength() {
        int total_length = 0;
        for (Track track: tracks) {
            total_length = total_length + track.getLength();
        } return total_length;
    }

    public void play () {
        System.out.println("Compact DVD by " + this.getArtist());
        for (Track track: tracks) {
            track.play();
        }
    }
}
