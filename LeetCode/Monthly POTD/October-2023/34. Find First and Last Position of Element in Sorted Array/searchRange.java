class Solution {

    private int binarySearch(int[] arr, int start, int end, int target) {
        if(start > end) return -1;

        int mid = (start+end)/2;

        if(arr[mid] > target) {
            return binarySearch(arr, start, mid-1, target);
        } else if(arr[mid] < target) {
            return binarySearch(arr, mid+1, end, target);
        }

        return mid;
    }
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int[] ans = {-1, -1};

        if(n == 0) return ans;
        else if(n == 1) {
            if(nums[0] == target) {
                ans[0] = 0;
                ans[1] = 0;
            }

            return ans;
        }

        int index = binarySearch(nums, start, end, target);
        if(index == -1) return ans;

        start = index;

        while(start >= 0 && nums[start] == target) {
            start--;
        }

        end = index;

        while(end <n && nums[end] == target){
            end++;
        }

        ans[0] = start+1;
        ans[1] = end-1;

        return ans;
    }
}