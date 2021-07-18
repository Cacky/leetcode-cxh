package 线程.lc1114_按序打印;

/**
 * 线程.按序打印.
 *
 * @author chengxiaohai.
 * @date 2021/2/4.
 */
public class ThreadTest1 {
    private int flag = 0;
    public void first(Runnable printFirst) throws InterruptedException {
        //如果flag不为0则让first线程等待，while循环控制first线程如果不满住条件就一直在while代码块中，防止出现中途跳入，执行下面的代码，其余线程while循环同理
        while( flag != 0){
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //定义成员变量为 1
        flag = 1;
        //唤醒其余所有的线程
    }
    public void second(Runnable printSecond) throws InterruptedException {
        //如果成员变量不为1则让二号等待
        while (flag != 1){
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        //如果成员变量为 1 ，则代表first线程刚执行完，所以执行second，并且改变成员变量为 2
        flag = 2;
        //唤醒其余所有的线程
    }
    public void third(Runnable printThird) throws InterruptedException {
        //如果flag不等于2 则一直处于等待的状态
        while (flag != 2){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        //如果成员变量为 2 ，则代表second线程刚执行完，所以执行third，并且改变成员变量为 0
        printThird.run();
        flag = 0;
    }

    public static void main(String[] args) {
        ThreadTest1 threadTest = new ThreadTest1();
        Thread thread1 = new Thread(()->{
            try {
                threadTest.first(()->{
                    System.out.println("one");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                threadTest.second(()->{
                    System.out.println("two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()->{
            try {
                threadTest.third(()->{
                    System.out.println("three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        thread1.start();
        thread2.start();
    }
}
