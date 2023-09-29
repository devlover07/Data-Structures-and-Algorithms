public class Solution {
    public int getSum(int A, int B, int[] C) {

        Map<Integer, Integer> hm = new HashMap<>();

        for(int i: C){
            hm.putIfAbsent(i, 0);
            hm.put(i, hm.get(i) + 1);
        }

        int sum = 0;

        Set<Integer> keys = hm.keySet();
        boolean checkIfExist = false;

        for(int key: keys){
            if(hm.get(key) == B) {
                sum += key;
                checkIfExist = true;
            }
        }

        return checkIfExist ? sum % 1000000007 :-1;
    }
}
