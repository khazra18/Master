package Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        List<Printjob> printjobList = new ArrayList<>(Arrays.asList(new Printjob("krishanu"),new Printjob("tirthankar"),
                new Printjob("suvadip"),new Printjob("payel"),new Printjob("piyali"),new Printjob("sikta")));
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (Printjob job : printjobList){
            service.submit(job);
        }
        service.shutdown();
    }

}

class Printjob implements Runnable{

    String name;

    public Printjob(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + " job started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " job completed by " + Thread.currentThread().getName());

    }
}