import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();
        Lock lock = new ReentrantLock();
        for(int i=0; i<200; i++) {
            CounterThread ct = new CounterThread(counter, lock);
            ct.start();
        }
        Thread.sleep(1000);

        System.out.println("Counter:" + counter.getCounter());
    }
}

class Counter1 {
    private long counter = 0L;

    public synchronized void increaseCounter() {
        counter++;
        System.out.println("Counter:" + getCounter());
    }

    public long getCounter() {
        return counter;
    }
}

class CounterThread extends Thread {
    private final Counter1 counter;
    private final Lock lock;

    public CounterThread(Counter1 counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0; i < 1000; i++) {
            try {
                if(lock.tryLock(10, TimeUnit.SECONDS)){
                    counter.increaseCounter();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
}

