import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JavaTest {

    public static void main(String[] args) {
        for (int i=0; i<50; i++) {
            System.out.println("table size for " + i + " is " + tableSizeFor(i));
        }
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}

