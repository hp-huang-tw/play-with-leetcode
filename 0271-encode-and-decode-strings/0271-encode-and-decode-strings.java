public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String res = "";
        
        for (String s: strs) {
            res += s.length() + "#" + s;
        }
        
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0, j = 0;
        
        while (i < s.length()) {
            j = i;
            
            while (s.charAt(j) != '#') {
                j++;
            }
            
            int strLen = Integer.valueOf(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + strLen));
            
            i = j + 1 + strLen;
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));