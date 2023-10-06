var integerBreak = function(n) {
    let dp = new Array(n + 1).fill(0);
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for (let i = 3; i <= n; i++) {
        for (let j = 1; j < i; j++) {
            let x = j;
            let y = i - x;
            dp[i] = Math.max(dp[i], Math.max(x * y, dp[y] * x));
        }
    }

    return dp[n];
};