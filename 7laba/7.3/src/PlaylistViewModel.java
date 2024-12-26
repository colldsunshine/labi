import java.util.List;

public class PlaylistViewModel {
    private List<Track> tracks;
    private PlaylistView view;

    public PlaylistViewModel(List<Track> tracks, PlaylistView view) {
        this.tracks = tracks;
        this.view = view;
    }

    public void playTrack(String title) {
        for (Track track : tracks) {
            track.setPlaying(track.getTitle().equals(title));
        }
        updateView();
    }

    public void updateView() {
        view.displayTracks(tracks);
    }
}