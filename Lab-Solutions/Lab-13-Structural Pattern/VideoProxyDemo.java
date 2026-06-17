// Solution 2: Video Streaming Platform
// Pattern: Proxy (Virtual / Caching)

// Subject Interface
interface Video {
    void play();
}

// Real Object
class RealVideo implements Video {
    private String name;
    RealVideo(String name) {
        this.name = name;
        loadVideo();
    }
    private void loadVideo() {
        System.out.println("Loading video: " + name);
    }
    public void play() {
        System.out.println("Playing video: " + name);
    }
}

// Proxy
class VideoProxy implements Video {
    private RealVideo realVideo;
    private String name;

    VideoProxy(String name) { this.name = name; }

    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(name); // lazy loading
        }
        realVideo.play();
    }
}

// Client
public class VideoProxyDemo {
    public static void main(String[] args) {
        Video video = new VideoProxy("movie.mp4");
        video.play(); // loads + plays
        video.play(); // only plays (no reload)
    }
}
