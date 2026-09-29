// Last updated: 9/29/2026, 11:12:58 AM
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count =0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
    }
}