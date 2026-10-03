class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        
        for(int i=text1.length()-1; i>=0; i--){
            for(int j=text2.length()-1; j>=0; j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }


        return dp[0][0];
    }
    // public int lcs(String s1, String s2, int i, int j, int dp[][]) {
    //     if(i==s1.length() || j==s2.length())return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(s1.charAt(i)==s2.charAt(j))

    //         return dp[i][j] = 1 + lcs(s1, s2, i+1, j+1, dp);
        
    //     return dp[i][j] = Math.max(lcs(s1, s2, i+1, j, dp), lcs(s1, s2, i, j+1, dp));
        
    // }
}