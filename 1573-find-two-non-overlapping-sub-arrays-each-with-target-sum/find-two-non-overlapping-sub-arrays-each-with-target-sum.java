class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int sum = 0;
        int right=0;
        int left=0;
         int[] best = new int[n];
         Arrays.fill(best, Integer.MAX_VALUE);
         int ans = Integer.MAX_VALUE;
         for(right=0;right<n; right++){
            sum+=arr[right];
            while(left<=right && sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum == target){
                int len = right-left+1;
                if(left>0&& best[left-1]!= Integer.MAX_VALUE){
                    ans = Math.min(ans, len+best[left-1]);
                }
                best[right]=len;
            }
            if(right>0){
                best[right]=Math.min(best[right], best[right-1]);
            }

         }
         return ans==Integer.MAX_VALUE ? -1: ans;
    }
}