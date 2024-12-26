import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Трек-1", "Исполнитель-1"));
        tracks.add(new Track("Трек-2", "Исполнитель-2"));
        tracks.add(new Track("Трек-3", "Исполнитель-3"));

        PlaylistView view = new PlaylistView();
        PlaylistViewModel viewModel = new PlaylistViewModel(tracks, view);

        viewModel.updateView();
        viewModel.playTrack("Трек-2");
    }
}