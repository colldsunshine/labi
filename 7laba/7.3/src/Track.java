public class Track {
    private String title;
    private String artist;
    private boolean isPlaying;

    public Track(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.isPlaying = false;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
}