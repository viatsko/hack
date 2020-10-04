import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoStream {
    static class Pair{
        double q1Val;
        double q2Val;
        Pair(double q1Val, double q2Val){
            this.q1Val = q1Val;
            this.q2Val = q2Val;
        }
    }
    static BlockingDeque<Double> q1 = new LinkedBlockingDeque<Double>();
    static BlockingDeque<Double> q2 = new LinkedBlockingDeque<Double>();
    static List<Pair> result = new ArrayList<Pair>();
    private static final Lock lock = new ReentrantLock();

    public static void calculate(BlockingDeque<Double> q1, BlockingDeque<Double> q2, double val){
        q1.offerLast(val);
        while(!q2.isEmpty()){
            while(!q2.isEmpty() && val - q2.getFirst() >= 1){
                q2.pollFirst();
            }
            for(Double d : q2){
                if(Math.abs(val - d) < 1){
                    result.add(new Pair(val,d));
                } else {
                    break;
                }
            }
            break;
        }
    }

    public static class MyThread1 extends Thread{
        BlockingQueue<Double> input = new LinkedBlockingQueue<Double>();
        MyThread1(BlockingQueue<Double> input){
            this.input = input;
        }
        @Override
        public void run() {
            while(!input.isEmpty()){
                Double d = input.poll();
                lock.lock();
                calculate(q1, q2, d);
                lock.unlock();
            }
        }

    }

    public static class MyThread2 extends Thread{
        BlockingQueue<Double> input = new LinkedBlockingQueue<Double>();
        MyThread2(BlockingQueue<Double> input){
            this.input = input;
        }
        @Override
        public void run(){
            while(!input.isEmpty()) {
                Double d = input.poll();
                lock.lock();
                calculate(q2, q1, d);
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BlockingQueue<Double> q1 = new LinkedBlockingQueue<Double>();
        q1.offer(0.2);
        q1.offer(1.4);
        q1.offer(3.0);

        BlockingQueue<Double> q2 = new LinkedBlockingQueue<Double>();
        q2.offer(1.0);
        q2.offer(1.1);
        q2.offer(3.5);

        Thread t1 = new MyThread1(q1);
        Thread t2 = new MyThread2(q2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        for(Pair p : result){
            System.out.println(p.q1Val + " " + p.q2Val);
        }
    }
}
