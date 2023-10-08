var maxDotProduct = function(nums1, nums2) {
    const n = nums1.length;
    const m = nums2.length;

    const dp = new Array(n + 1).fill(null).map(() => new Array(m + 1).fill(-Infinity));

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (i === 1) {
                dp[i][j] = Math.max(dp[i][j - 1], nums1[i - 1] * nums2[j - 1]);
            } else if (j === 1) {
                dp[i][j] = Math.max(dp[i - 1][j], nums1[i - 1] * nums2[j - 1]);
            } else {
                dp[i][j] = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + dp[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
    }

    return dp[n][m];
};
Previous
