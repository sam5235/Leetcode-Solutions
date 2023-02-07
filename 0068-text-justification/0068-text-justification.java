class Solution {
   
public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> text = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (!line.isEmpty() && line.length() + word.length() >= maxWidth) {
                text.add(padLine(line, maxWidth)); 
                line = new StringBuilder();
            }
            if (line.length() != 0) {
                line.append(' ');
            }
            line.append(word);
        }
        line.append(" ".repeat(maxWidth - line.length()));
        text.add(line.toString()); 
        return text;
    }
    
    private String padLine(StringBuilder line, int maxWidth) {
        int ind = 0;
        for (int i = line.length(); i < maxWidth; i++) {
            ind = getSpaceIndex(line, ind + 1);
            line.insert(ind, ' ');
        }
        return line.toString();
    }
    
    private int getSpaceIndex(StringBuilder line, int startIndex) {
        int i = startIndex;
        for (; i < line.length() && line.charAt(i) != ' '; i++);
        for (; i < line.length() && line.charAt(i) == ' '; i++); 
        if (i >= line.length()) { 
            i = 0;
            for (; i < line.length() && line.charAt(i) != ' '; i++);
            for (; i < line.length() && line.charAt(i) == ' '; i++); 
        }
        return i;
    }
}