import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
         // step1: 变数组
         char[] s1arr = p.toCharArray();
         char[] s2arr = s.toCharArray();
 
         // step2: map 记录
         HashMap<Character, Integer> need = new HashMap<>();
         // 更新 记录
         for(char c: s1arr){
             need.put(c, need.getOrDefault(c, 0) + 1);
         }
         HashMap<Character, Integer> window = new HashMap<>();
 
         // step3: 标记值
         int left =0, right = 0;
         int valid =0 ;// 满足的字符数
 
         while(right < s2arr.length){
             char c = s2arr[right];
             right ++ ;
             if(need.containsKey(c)){
                 // 更新 字符数 & 和满足数目的合法值
                 window.put(c, window.getOrDefault(c, 0) + 1);
                 if(window.get(c).equals(need.get(c))){
                     valid ++;
                 }
             }
             // step4: 缩小窗口: 
             while(right - left >= s1arr.length ){
                 if(valid == need.size()){
                    // 增加索引
                    res.add(left);
                 }
                 char delete = s2arr[left];
                 if(need.containsKey(delete)){
                     if(window.get(delete).equals(need.get(delete))){
                         valid --;
                     }
                     window.put(delete, window.get(delete) - 1);
                 }
                 left++;
             }
         }
         // 没找到
         return res;
    }
}
// @lc code=end

