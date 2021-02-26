/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
@author rnavarro
 */
public class TwoThreadsNoSharing {
    public static void main(String args[]) {
        
        System.out.println("Main: inicio");
        HelloRunner r1 = new HelloRunner();
        Thread t1 = new Thread(r1);
        HelloRunner r2 = new HelloRunner();
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        System.out.println("Main: fin");

    }

}