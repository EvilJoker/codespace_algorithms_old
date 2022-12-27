/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left =0, right = nums.length -1;
        while(left != right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum < target) {
                left ++;
            }else{
                right --;
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

