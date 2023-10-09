class Solution {

    // ===================== 3RD Approach =====================
    public char findTheDifference(String s, String t) {
        
        char ch = 0;

        for(char c: (s+t).toCharArray()) ch ^= c;

        return ch;
    }
    /*==================== 2nd Approach ======================
    public char findTheDifference(String s, String t) {
        
        char ch = 0;

        for(char c: s.toCharArray()) ch ^= c;
        for(char c: t.toCharArray()) ch ^= c;

        return ch;
    }
    */

    /*=================== My Solution =====================
    public char findTheDifference(String s, String t) {
        
        Map<Character, Integer> sHm = new HashMap<>();
        Map<Character, Integer> tHm = new HashMap<>();
        int n = s.length();

        if(n == 0) return t.charAt(0);
        char ch = ' ';

        for(int i = 0; i<n; i++){
            ch = s.charAt(i);
            sHm.putIfAbsent(ch, 1);
            sHm.put(ch, sHm.get(ch) + 1);
        }

        n = t.length();

        for(int i = 0; i<n; i++){
            ch = t.charAt(i);
            tHm.putIfAbsent(ch, 1);
            tHm.put(ch, tHm.get(ch) + 1);
        }

        // n = tHm.size();

        for(int i = 0; i<n; i++){
            ch = t.charAt(i);
            if(!sHm.containsKey(ch)) return ch;
            else {
                if(tHm.get(ch)-sHm.get(ch) != 0)
                return ch;
            }
        }

        return ch;
    }
    */
}