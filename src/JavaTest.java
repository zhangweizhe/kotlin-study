public class JavaTest {

    static int i = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        int a = 0;
        while (a < 100) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        i++;
                        System.out.println(i);
                    }
                }
            }.start();
            a++;
        }
    }
}

