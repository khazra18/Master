package Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {

    public static void main(String[] args) throws Exception {

        List<MyCallable> myCallableList = new ArrayList<>(Arrays.asList(new MyCallable(10), new MyCallable(20),
                new MyCallable(30), new MyCallable(40), new MyCallable(50), new MyCallable(60)));
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (MyCallable c : myCallableList) {
            Future<Integer> future = service.submit(c);
            System.out.println(future.get());
        }
        service.shutdown();
    }

}

class MyCallable implements Callable<Integer> {

    int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName() + " is responsible for the sum of : " + num);
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        return sum;
    }
}