class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> vowels = new HashSet<>();
        char[] chars = {'a','e','i','o','u','A','E','I','O','U'};
        for(char c : chars)
           vowels.add(c);
        
        int a = 0;
        int b = 0;
        for(int i = 0, j = s.length() - 1; i < s.length() / 2 && j >= s.length() / 2; i++, j--){
            if(vowels.contains(s.charAt(i)))
                a++;
            if(vowels.contains(s.charAt(j)))
                b++;
        }
        
        return a == b;
    }
}