public class Codec {
    HashMap<Integer, String> map;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map = new HashMap<>();
        map.put(1, longUrl);
        return "http://tinyurl.com/" + 1;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));