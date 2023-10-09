class Solution {
public:
    int integerBreak(int n) {
        vector<int> dp(n + 1, 0);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int x = j;
                int y = i - x;
                dp[i] = max(dp[i], max(x * y, dp[y] * x));
            }
        }

        return dp[n];
    }
};