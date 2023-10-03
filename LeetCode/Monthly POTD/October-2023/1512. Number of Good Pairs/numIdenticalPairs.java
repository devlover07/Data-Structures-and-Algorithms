class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0, count[] = new int[101];

        for(int num: nums){
            ans = ans + count[num]++;
        }

        return ans;
    }
}