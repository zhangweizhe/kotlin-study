package bytedance;

import java.util.ArrayList;
import java.util.List;

public class Q6 {

    public static void main(String[] args) {
        // 6. Z 字形变换
        // https://leetcode.cn/problems/zigzag-conversion/
        Q6 q6 = new Q6();
        System.out.println(q6.convert("A", 1));
    }

    public String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            // 字符串长度小于 numRows，直接返回 s 就可以
            return s;
        }
        // 使用 List<StringBuilder> 存储每行的字符
        List<StringBuilder> sbList = new ArrayList<>(numRows);
        // 控制行走方向，1向下走，-1向上走，因为当遍历到的行 rowIndex == 0 时，要换行，所以 step 初始值是 -1
        int step = -1;
        char[] chars = s.toCharArray();
        // 当前遍历到哪一行
        int rowIndex = 0;
        for (char c : chars) {
            if (rowIndex >= sbList.size()) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sbList.add(sb);
            }else {
                StringBuilder sb = sbList.get(rowIndex);
                sb.append(c);
            }
            if (rowIndex == numRows-1 || rowIndex == 0) {
                // 改变行走方向
                step = -step;
            }
            rowIndex += step;
        }
        StringBuilder result = new StringBuilder();
        // 从上到下，拼接每一行的结果
        for (StringBuilder sb : sbList) {
            result.append(sb.toString());
        }
        return result.toString();
    }
}
