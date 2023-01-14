class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] roots = new int[26];
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i  = 0; i < 26; i++){
            roots[i] = i;
        }
        for(int i = 0; i < s1.length(); i++){
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';
            union(roots, idx1, idx2);
        }
        for(int i = 0; i < roots.length; i++){
            find(roots, roots[i]);
        }
        System.out.println(Arrays.toString(roots));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            int idx = roots[baseStr.charAt(i) - 'a'];
            sb.append(chars[roots[idx]]);
        }
      
        return sb.toString();
    }
    void union(int[] roots, int a, int b){
        int ra = find(roots, a);
        int rb = find(roots, b);
        if(ra < rb)
          roots[rb] = roots[ra];
        else  roots[ra] = roots[rb];
    }
    int find(int[] roots, int a){
        if(roots[a] == a)
            return a;
        return roots[a] = find(roots, roots[a]);
    }
}