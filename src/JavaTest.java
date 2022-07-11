import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTest {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        JavaTest javaTest = new JavaTest();
        javaTest.lockTest();

    }

    private void lockTest() {
        new Thread("t1") {
            @Override
            public void run() {
                super.run();
                System.out.println(getName() + " 尝试获取锁");
                lock.lock();
                System.out.println(getName() + " 获取锁成功");
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + " 释放锁");
                lock.unlock();
                System.out.println(getName() + " 释放锁成功");

            }
        }.start();

        new Thread("t2") {
            @Override
            public void run() {
                System.out.println(getName() + " 尝试获取锁");
                boolean tryLock = false;
                try {
                    tryLock = lock.tryLock(4100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + " tryLock 结果：" + tryLock);
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + " 释放锁");
                lock.unlock();
                System.out.println(getName() + " 释放锁成功");
            }
        }.start();
    }

    public synchronized void syncFun() {
        int integer = 0;
        System.out.println(integer);
        integer++;
        System.out.println(integer);
        List<String> strList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        strList.add("asdf");
        integerList.add(123);
    }

}

