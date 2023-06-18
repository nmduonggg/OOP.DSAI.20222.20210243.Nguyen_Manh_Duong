package hust.soict.dsai.aims.media;
import java.util.*;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title) {
        super(id, title);
    }

    public CompactDisc(String title) {
       super(title);
    }

    public boolean addTrack (Track track) {
        if (!(tracks.contains(track))){
            tracks.add(track);
            return true;
        } else {return false;}
    }

    public boolean removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            return true;
        } else {
           return false;
        }
    }

    public int getLength() {
        int total_length = 0;
        for (Track track: tracks) {
            total_length = total_length + track.getLength();
        } return total_length;
    }

    public String toString() {
        return "CD by " + artist + super.toString();
    }

    public String play() {
        String playing = "";
        for (Track track: tracks) {
            playing = playing + track.play() + "\n";
        } return playing;
    }
}
