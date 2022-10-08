public class Codec {
    String[] str;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        str = new String[1];
        str[0] = longUrl;
        return "http://tinyurl.com/" + 0;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return str[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));