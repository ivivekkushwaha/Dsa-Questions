class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = i; j < n; j++) {
                hs.add(nums.get(j));
                int count = hs.size();
                ans += count * count;
            }
        }
        return ans;

    }
}