class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);

        for(int i = 1; i<=n; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++){
                if(i == 1) {
                    dp[i][j] = Integer.max(dp[i][j-1], nums1[i-1] * nums2[j-1]);
                } else if(j == 1) {
                    dp[i][j] = Integer.max(dp[i-1][j], nums1[i-1]*nums2[j-1]);
                } else {
                    dp[i][j] = nums1[i-1] * nums2[j-1];
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + dp[i][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}