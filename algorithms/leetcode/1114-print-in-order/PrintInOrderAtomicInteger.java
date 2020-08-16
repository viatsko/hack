import java.util.concurrent.atomic.*;

class Foo {
    AtomicInteger counter = new AtomicInteger(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (!counter.compareAndSet(0, 1)) {}
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!counter.compareAndSet(1, 2)) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!counter.compareAndSet(2, 3)) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
