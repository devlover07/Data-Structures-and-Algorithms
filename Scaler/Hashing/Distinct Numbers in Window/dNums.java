public class Solution {
    public int[] dNums(int[] A, int B) {

        int n = A.length;
        int[] res = new int[n-B+1];
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i<B; i++){
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        res[0] = hm.size();

        for(int i = 1; i<=n-B; i++){
            hm.put(A[i-1], hm.get(A[i-1]) - 1);
            hm.put(A[i+B-1], hm.getOrDefault(A[i+B-1], 0) + 1);

            if(hm.get(A[i-1]) == 0) hm.remove(A[i-1]);

            res[i] = hm.size();
        }

        return res;
    }
}
