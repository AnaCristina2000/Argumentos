/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnavarro
 */
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        
        // crear el objeto thread
        Thread t = new Thread( new HelloRunnable() );
        
        
        // iniciar la ejecución del thread
        t.start();

    }

}
