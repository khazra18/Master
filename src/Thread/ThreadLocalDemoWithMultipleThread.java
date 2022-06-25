package Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemoWithMultipleThread {

    public static void main(String[] args) {

        List<CustomerThread> customerThreadList = new ArrayList<>(Arrays.asList(new CustomerThread("krishanu"),new CustomerThread("tirthankar"),
                new CustomerThread("suvadip"),new CustomerThread("payel"),new CustomerThread("piyali"),new CustomerThread("sikta")));
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (CustomerThread customerThread : customerThreadList){
            service.submit(customerThread);
        }
        service.shutdown();

    }

}

class CustomerThread implements Runnable {

    String name;
    static int count = 0;

    public CustomerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing with customer id - " + threadLocal.get());
    }

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> ++count);
}
