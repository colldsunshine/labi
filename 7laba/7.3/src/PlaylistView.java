import java.util.List;

public class PlaylistView {
    public void displayTracks(List<Track> tracks) {
        for (Track track : tracks) {
            System.out.println(track.getTitle() + " от " + track.getArtist() + (track.isPlaying() ? " [Playing]" : ""));
        }
    }
}