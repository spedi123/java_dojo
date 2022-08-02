import java.util.HashMap;
import java.util.Set;

public class SongList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("About Damm Time", "Lizzo");
        trackList.put("As It was", "Harry Styles");
        trackList.put("First Class", "Jack Harlow");
        trackList.put("Break My Soul", "Beyonce");

        String singer = trackList.get("Break My Soul");
        System.out.println("My favorite singer is " + singer);
        
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println("Title is " + key);
            System.out.println("Signer is " + trackList.get(key));
        }
    }
}
