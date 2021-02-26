/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnavarro
 */
public class TwoThreadsSharing {

    public static void main(String args[]) {

        // Se crea un unico objeto 
        HelloRunner r = new HelloRunner();

        // el mismo objeto se comparte
        // por dos threads
        Thread t1 = new Thread(r);

        Thread t2 = new Thread(r);

        t1.start();

        t2.start();

    }

}
