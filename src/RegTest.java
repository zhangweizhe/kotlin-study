import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        String regex = "";
        Pattern pattern = Pattern.compile(regex);
        String text = "";
        int count = 0;
        long start = System.currentTimeMillis();
        Matcher matcher = pattern.matcher(text);
        long matcherEnd = System.currentTimeMillis();
        System.out.println("match cost " + (matcherEnd - start));
        while (matcher.find()) {
            if (count == 10) {
                break;
            }
            System.out.println(matcher.group());
            count++;
        }
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("结束：count = " + count + ", cost = " + cost);
    }
}
