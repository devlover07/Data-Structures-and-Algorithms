class Solution {
    public String decodeAtIndex(String s, int k) {
        
        int n = s.length();
        long len = 0;
        char ch;

        for(int i = 0; i<n; i++){
            ch = s.charAt(i);

            if(Character.isDigit(ch)){
                len *= (ch - '0');
            } else {
                len++;
            }
        }

        for(int i = (n-1); i>=0; i--){
            ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                len /= (ch - '0');
                k %= len;
            } else {
                if(k == 0 || k == len) return ch+"";
                len--;
            }
        }

        return "";
    }
}