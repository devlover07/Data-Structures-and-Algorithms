class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();

        vector<vector<int>> dp(n + 1, vector<int>(m + 1, INT_MIN));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1) {
                    dp[i][j] = max(dp[i][j - 1], nums1[i - 1] * nums2[j - 1]);
                } else if (j == 1) {
                    dp[i][j] = max(dp[i - 1][j], nums1[i - 1] * nums2[j - 1]);
                } else {
                    dp[i][j] = nums1[i - 1] * nums2[j - 1];
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + dp[i][j]);
                    dp[i][j] = max(dp[i][j], dp[i - 1][j]);
                    dp[i][j] = max(dp[i][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
};
    }
};