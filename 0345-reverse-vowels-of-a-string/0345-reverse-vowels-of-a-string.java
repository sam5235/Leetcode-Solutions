class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> vowel = new HashSet<>();
        vowel.addAll(Arrays.asList('u','U', 'a','A','i','I','o','O','e', 'E'));
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            char left = chars[i];
            char right = chars[j];
            if(vowel.contains(left) && vowel.contains(right)){
                chars[i] = right;
                chars[j] = left;
                i++;
                j--;   
            }
                
            if(!vowel.contains(left))
                i++;
            if(!vowel.contains(right))
                j--;
            
        }
        return new String(chars);
    }
}