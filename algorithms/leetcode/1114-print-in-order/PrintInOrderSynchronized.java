class Foo {
    int count = 0;

    public Foo() {
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        count++;
        this.notifyAll();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (count != 1) this.wait();
        count++;
        this.notifyAll();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (count != 2) this.wait();
        count++;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
