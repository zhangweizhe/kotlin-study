package bytedance;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public static void main(String[] args) {
        // 93. 复原 IP 地址
        // https://leetcode.cn/problems/restore-ip-addresses/
        Q93 q93 = new Q93();
        System.out.println(q93.restoreIpAddresses("1111"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int i=1; i<4; i++) {
            for (int j=1; j<4; j++) {
                for (int k=1; k<4; k++) {
                    int remain = n - i - j - k;
                    if (remain >=1 && remain <= 3) {

                        String seg1 = s.substring(0, i);
                        if (!isValid(seg1)) {
                            continue;
                        }
                        String seg2 = s.substring(i, i + j);
                        if (!isValid(seg2)) {
                            continue;
                        }
                        String seg3 = s.substring(i + j, i + j + k);
                        if (!isValid(seg3)) {
                            continue;
                        }
                        String seg4 = s.substring(i + j + k, n);
                        if (!isValid(seg4)) {
                            continue;
                        }
                        result.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String seg) {
        int i = Integer.parseInt(seg);
        int length = seg.length();
        return (i >= 100 && i <= 255 && length == 3)
                || (i >= 10 && i <= 99 && length == 2)
                || (i >= 0 && i <= 9 && length == 1);
    }
}
