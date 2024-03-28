class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        
        answer = dp[n];
        
        return answer;
    }
}