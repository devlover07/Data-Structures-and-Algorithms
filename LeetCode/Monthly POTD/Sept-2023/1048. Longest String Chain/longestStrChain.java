class Solution {
    public int longestStrChain(String[] words) {
        
        int n = words.length;
        Map<String, Integer> memo = new HashMap<>();
        int res = 0;
        
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        
        for(String word: words){
            memo.put(word, 1);
            for(int i = 0; i<word.length(); i++){
                StringBuilder sameWord = new StringBuilder(word);
                String next = sameWord.deleteCharAt(i).toString();
                
                if(memo.containsKey(next)){
                    memo.put(word, Math.max(memo.get(word), memo.get(next)+1));
                }
            }
            
            res = Math.max(res, memo.get(word));
        }
        
        return res;
    }
}