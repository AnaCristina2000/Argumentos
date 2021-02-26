package com.mycompany.ordenar;
import java.io.*;
public class orden {
public static void main(String[] args) throws IOException {
    crear();
        File archivo = new File("C:/materias/datos/AnaC.txt");//es donde se guarda el archivo la ruta donde estara 
        FileReader fr=new FileReader(archivo);
        BufferedReader br=new BufferedReader(fr);
           
        int leer[]=new int[5000];
        String texto;
        
        
        System.out.println( "NUMEROS ORDENADOS DEL 100 AL 500");
        leer=ordenar(leer);
        
        System.out.println( "");
        
        for (int i = 0; i < 5000; i++) {
            texto=br.readLine();
            leer[i]=Integer.parseInt(texto);
        }
       // for (int i = 0; i < 5000; i++) {
          //  System.out.println(leer[i]);}
        //System.out.println(buscar(389,leer));
        //System.out.println("El numero se repite "+buscar2(389,leer)+" veces");
        for(int i=100; i<=500;i++){
        System.out.println( "El número "+i+" se repite "+buscar2(i,leer)+" veces");
        }
           
    }
    
    
   
   
    
    
    
    static int buscar2(int x, int [] read){
    //arreglo leer[5000]
       int cont=0;
     for (int i=0; i<5000; i++){
        
     if(read[i]==x){
     //System.out.println("El valor está en la posición:"+i);   
     cont=cont+1;
     
            
     }  
     }
     return cont;
    }  
    
    static int[] ordenar(int[] d) {
int t=d.length;
for(int j=1;j<5000;j++) {
int menor = 1000000000; 
int pos = 0; 
for (int i = j; i<t; i++) { 
      if (d[i] < menor) {
menor = d[i]; 
pos = i;
      } 
    }
int temp=d[pos]; 
d[pos]=d[j];
 d[j] =temp;


       
 } 
return d;
} 
 
 
    
static void crear() throws IOException {
    int inicial = 100;
    int fin = 501;
    int datos[] = new int[5000];
      File archivo = new File("C:/materias/datos/AnaC.txt");

    FileWriter fw = new FileWriter(archivo);
    BufferedWriter bw = new BufferedWriter(fw);

 

    for (int i = 0; i < 5000; i++) {
        datos[i] = (int) (Math.random() * (fin - inicial) + inicial);
        //System.out.println("datos = " + datos[i]);
        bw.write(Integer.toString(datos[i]));
        bw.newLine();
    }
    bw.flush();
}
}
        

