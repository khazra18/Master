package Thread;

public class ThreadLocalDemo1 {

    public static void main(String[] args) {

        //Thread local - how to set and remove value from a threadlocal
        /*ThreadLocal<Integer> tl = new ThreadLocal<>();
        System.out.println(tl.get());
        tl.set(10);
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());*/

        //How to initialize value to a thread local
        ThreadLocal<Integer> tl = ThreadLocal.withInitial(() -> 10);
        System.out.println(tl.get());
        tl.set(20);
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }

}
