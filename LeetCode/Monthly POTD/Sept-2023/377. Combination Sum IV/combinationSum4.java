/* ========================DP 1: Top Down approach(Memoization=)====================
class Solution {

    public int combinationSum4(int[] nums, int target) {

        HashMap<Integer, Integer> memo = new HashMap<>();

        return comb(nums, target, memo);
    }

    private int comb(int[] arr, int remain, HashMap<Integer, Integer> memo){

        if(remain == 0){
            return 1;
        }

        if(memo.containsKey(remain)){
            return memo.get(remain);
        }

        int result = 0;
        int n = arr.length;

        for(int i = 0; i<n; i++){
            if(remain-arr[i] >= 0){
                result += comb(arr, remain-arr[i], memo);
            }
        }

        memo.put(remain, result);

        return result;
    }
}

*/

//======================DP 2:Bottom up approach(Tabulation)=====================
class Solution {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 1; i<=target; i++){
            for(int num: nums){
                if(i-num>=0){
                    dp[i] += dp[i-num];
                }
            }
        }

        return dp[target];
    }
}