class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sbr = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0;

        while(i < len1 || i<len2) {
            if(i < len1) {
                sbr.append(word1.charAt(i));
            }

            if(i < len2) {
                sbr.append(word2.charAt(i));
            }

            i++;
        }

        return sbr.toString();
    }
}