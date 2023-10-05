class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        int maj1 = 0;
        int maj2 = 0;
        int count1 = 0;
        int count2 = 0;
        List<Integer> major = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            if(count1 == 0 && nums[i] != maj2) {
                count1 = 1;
                maj1 = nums[i];
            } else if(count2 == 0 && nums[i] != maj1) {
                count2 = 1;
                maj2 = nums[i];
            } else if(nums[i] == maj1) {
                count1++;
            } else if(nums[i] == maj2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (maj1 == nums[i]) {
                count1++;
            } else if (maj2 == nums[i]) {
                count2++;
            }
        }

        if(count1 > (n/3)) {
            major.add(maj1);
        }
        if(count2 > (n/3)) {
            major.add(maj2);
        }

        return major;
    }
}