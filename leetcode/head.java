import java.util.Random;

public class head {
    // 前缀和数组
    private int[] preSum;
    private Random rand = new Random();
    
    public head(int[] w) {
        int n = w.length;
        // 构建前缀和数组，偏移一位留给 preSum[0]
        preSum = new int[n + 1];
        preSum[0] = 0;
        // preSum[i] = sum(w[0..i-1])
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int n = preSum.length;
        // 在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
        int target = rand.nextInt(preSum[n - 1]) + 1;
        // 获取 target 在前缀和数组 preSum 中的索引
        // 别忘了前缀和数组 preSum 和原始数组 w 有一位索引偏移
        return left_bound(preSum, target) - 1;
    }
    // 搜索左侧边界的二分搜索
    public int left_bound(int[] nums, int target) {
        int left =0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid +1;
            }else if(nums[mid] > target){
                right = mid -1;
            }else if(nums[mid] == target){
                right = mid -1;
            }
            
        }
        if (left == nums.length ) return -1;
        return nums[left] == target ? left : -1 ;
    }

    public static void main(String[] args) {
        int [] a = new int[]{1, 3};
        head s = new head(a);
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());

    }

}



/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */