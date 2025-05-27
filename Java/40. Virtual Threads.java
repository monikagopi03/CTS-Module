public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("Hello from virtual thread " + Thread.currentThread());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(task);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        Thread.sleep(2000);
    }
}
