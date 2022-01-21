import java.util.Objects;

public class Streams {
    private final Object m = new Object();
    private String sign = "Ping!";
    private final int numPP = 25;

    public static void main(String[] args) {
        Streams wn = new Streams();

        new Thread(wn::printA).start();
        new Thread(wn::printB).start();

    }

    public void printA() {
        synchronized (m) {
            try {
                for (byte i = 0; i < numPP; i++ ) {
                    while (!Objects.equals(sign, "Ping!")) {
                        m.wait();
                    }
                    System.out.println(sign);
                    sign = "Pong!";
                    m.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (m) {
            try {
                for (byte i = 0; i < numPP; i++ ) {
                    while (!Objects.equals(sign, "Pong!")) {
                        m.wait();
                    }
                    System.out.println(sign);
                    sign = "Ping!";
                    m.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}