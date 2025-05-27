
class MessagePrinter extends Thread {
    private String message;
    public MessagePrinter(String message) {
        this.message = message;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        MessagePrinter t1 = new MessagePrinter("Thread 1 Running");
        MessagePrinter t2 = new MessagePrinter("Thread 2 Running");
        t1.start();
        t2.start();
    }
}
