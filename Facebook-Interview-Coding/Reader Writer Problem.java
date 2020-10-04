Reader Writer Problem
给定：
  Mutex:. 
    void lock();
    bool unlock();

  SharedMutex:
    void readerLock();.
    void readerUnlock();
    void writerLock();
    void writerUnlock();


实现下面4个api，自己定义mutex和variable，不管starvation。
    
public class ReadWriteLock{ 
    private int readers       = 0;
    private int writers       = 0;
    private int writeRequests = 0;

    public void lockRead() throws InterruptedException{
        lock();
        while(writers > 0 || writeRequests > 0)    await();
        readers++;
        unlock();    
    }

    public void unlockRead(){
        lock();
        readers--;
        signal();
        unlock();
    }

    public void lockWrite() throws InterruptedException{
        lock();
        writeRequests++;
        while(readers > 0 || writers > 0)   await();
        writeRequests--;
        writers++;
        unlock();
    }

    public void unlockWrite() throws InterruptedException{
        lock();
        writers--;
        notifyAll();
        unlock();
    }
}


// http://www.1point3acres.com/bbs/forum.php?%20mod=viewthread&tid=215980&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchop%20tion%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%2%206sortid%3D311


