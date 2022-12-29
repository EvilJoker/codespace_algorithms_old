import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //step1: to arry
        char[] arr = s.toCharArray();
        //step2: window
        HashMap<Character, Integer> window = new HashMap<>();

        int left =0, right =0;
        int max = 0;
        while(right < arr.length){
            char c = arr[right];
            right ++;
            window.put(c, window.getOrDefault(c, 0) +1);
            while(window.get(c) > 1){
                // step3: 缩短条件为 c >1
                char d = arr[left];
                window.put(d, window.get(d) - 1 );
                left ++;
            }
            // step4: 求最长
            max = max > right -left ? max : right - left;
        }

        return max;
    }
}
// @lc code=end

