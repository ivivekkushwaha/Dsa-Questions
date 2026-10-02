class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int dp[] = new int[n];
        int ans = 1;

            Arrays.fill(dp, 1);
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    // public int lis(int dp[][], int idx, int[] nums, int li) {

    //     if (idx == nums.length)
    //         return 0;
    //     if (dp[idx][li + 1] != -1)
    //         return dp[idx][li + 1];
    //     if (li == -1 || nums[idx] > nums[li]) {
    //         int count1 = 1 + lis(dp, idx + 1, nums, idx);
    //         int count2 = lis(dp, idx + 1, nums, li);
    //         return dp[idx][li + 1] = Math.max(count1, count2);
    //     }
    //     return dp[idx][li + 1] = lis(dp, idx + 1, nums, li);

    // }
}