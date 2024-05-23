package pom.timeout;

public class TimeSleep {
    public static void timeout() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
