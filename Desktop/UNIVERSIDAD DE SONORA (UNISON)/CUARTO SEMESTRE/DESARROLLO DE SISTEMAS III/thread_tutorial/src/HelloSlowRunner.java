import java.util.logging.Level;
import java.util.logging.Logger;

class HelloSlowRunner implements Runnable {
    public static final int MAX = 500;
    
    private int i;

    public void run() {
        i = 0;

        while (true) {
            String name = Thread.currentThread().getName();
            System.out.printf("%s: Hello %d\n",name, i++);
            
            if (i == MAX) {
                break;
            }
            
            try {
                // descansar medio segundo
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloSlowRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        
        Thread t = new Thread( new HelloRunner() );
        
        t.start();

    }
}
