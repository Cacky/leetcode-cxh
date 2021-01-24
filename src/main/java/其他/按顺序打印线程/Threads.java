package 其他.按顺序打印线程;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads implements Runnable {
    private static Lock lock = new ReentrantLock();
    private static Integer count = 0;
    private static final Integer MAX = 3000;
    private static String[] s = {"A", "B", "C","D"};

    private String name;

    public Threads(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        while (count < MAX) {
            lock.lock();
            try {
                while (this.name.equals(s[count % 4]) && count < MAX) {
                    System.out.println(name + "，count：" + count);
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 20, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(new Threads("A"));
        executor.execute(new Threads("B"));
        executor.execute(new Threads("C"));
        executor.execute(new Threads("D"));
        executor.shutdown();
    }
}
