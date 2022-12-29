import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // step1: 转数组
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        // map
        // step2: 记录 t 的各种字符
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c: tarr){
            int count = need.getOrDefault(c, 0);
            need.put(c, ++count);
        }
        // 记录当前 window
        HashMap<Character, Integer> window = new HashMap<>();

        // 初始化标注
        int left = 0, right = 0;
        int valid =0; // 记录 window 当前满足的 char 数量
        int min_len = Integer.MAX_VALUE;
        String res = "";

        while(right < sarr.length){
            
            char c = sarr[right];
            // 确定终点
            right ++ ;
            // step3: 给终点 添加数字
            if(need.containsKey(c)) {
                // 要改成 equal 否则会有问题。
                Integer count = window.getOrDefault(c, 0);
                window.put(c, ++count);
                // 字母数字达标, 合法数字加1
                if (count.equals(need.get(c))){
                    valid ++;
                }
            }
            // step4:当区间包含所有字符， 右移 起点
            while(valid == need.size()){
                
                char delete = sarr[left];
                // step5: 判断长度
                if (right - left < min_len){
                    min_len = right - left;
                    res = s.substring(left, right);
                }

                if (need.containsKey(delete)){
                    // 缩减 有效数字
                    if(window.get(delete).equals(need.get(delete))){
                        valid --;
                    }
                    // 只是减一
                    int count = window.get(delete);
                    window.put(delete, --count);
                }
                // step6, 左移
                left ++;
            }

        }
        
        return res;
    }

}


// @lc code=end

