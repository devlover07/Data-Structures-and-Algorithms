public class Solution {
    public int solve(String A) {

        int n = A.length();
        Map<Character, Integer> charFreq = new HashMap<>();

        for(char ch: A.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        List<Integer> vals = new ArrayList<Integer>(charFreq.values());
        int sumOValues = 0;
        int countOdd = 0;

        for(int val: vals) {
            if(n%2 == 0) {
                if(val%2 != 0) return 0;
            } else {
                if(val%2 != 0) countOdd++;
            }
            sumOValues += val;
        }

        return (countOdd<=1) ? 1 : 0;
    }
}
