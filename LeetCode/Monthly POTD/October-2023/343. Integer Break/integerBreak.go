func integerBreak(n int) int {
    dp := make([]int, n+1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1

    for i := 3; i <= n; i++ {
        for j := 1; j < i; j++ {
            x := j
            y := i - x
            dp[i] = max(dp[i], max(x*y, dp[y]*x))
        }
    }

    return dp[n]
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}