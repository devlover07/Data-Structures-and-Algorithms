class Solution {

    private int max(int a, int b){
        return (a>b? a: b);
    }

    public int integerBreak(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i<=n; i++){
            for(int j = 1; j<i; j++){
                int x = j;
                int y = i-x;
                dp[i] = Math.max(dp[i], Math.max(x*y, dp[y]*x));
            }
        }

        return dp[n];
    }
}