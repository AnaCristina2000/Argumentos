package com.mycompany.ordenar;
import java.io.*;
public class Ordenar1 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
         //crear();
         File archivo = new File("C:/materias/datos/Ana.txt");//es donde se guarda el archivo la ruta donde estara 
        FileReader fr=new FileReader(archivo);
        BufferedReader br=new BufferedReader(fr);
        int leer[]=new int[5000];
        String texto;//texto es la variable string , nota:lo que esta escrito es en el documento txt es es en string y solo se puede gurdar en string
        for (int i = 0; i < 5000; i++) {//se inicializa en cero la i se cicla 5000 veces para guardar los 5000 datos del arcivo Ana.txt
            texto=br.readLine();//el readline lee lo que esta en una linea  y lo guarda en la variable texto
            leer[i]=Integer.parseInt(texto);//entonces nota: transforma lo que esta en texto de strin a entero(int) y guarda el valor en el arregolo leer y lo hace con cada linea por que es un for 
        }
    }
    
            
 
    
    
    
   
        
    static void crear() throws IOException {//este es el metodo statico llamado crrear su funcion es llenar el archivo txt con 5000 datos del 100 a 500(los numeros son alatorios y se crean con el random con el rango de 1000 a500)
    int inicial = 100;//estamos indicando que el 100 es el rango inicial es decir los numeros inician en 100 
    int fin = 501;//se coloca el 501 para que de esa modo aparezca el 500 en el texto o txt, y finalizan en 500
    int datos[] = new int[5000];// creamos el arreglo con los 5000 datos es un arreglo unidimensional
    File archivo = new File("C:/materias/datos/Ana.txt");//estamos guardando la ruta en la variable file esto lee 

    FileWriter fw = new FileWriter(archivo);//crea una variable para escribir en el archivo con la ruta anterior 
    BufferedWriter bw = new BufferedWriter(fw);//ayuda a escribir mejor en el archivo 

    for (int i = 0; i < 5000; i++) {//es un ciclo de 5000 veces 
        datos[i] = (int) (Math.random() * (fin - inicial) + inicial);//es el raamdonesta haciendo el rango de  100 a 500 y los archovos randos los guada en array
        System.out.println("datos = " + datos[i]);
        bw.write(Integer.toString(datos[i]));//pasa los datos de int a string y luego lo escribe
        bw.newLine();//salto de linea
    }
    bw.flush();//cierre de archivo , se asegura de que escriba el BufferedWriter
}
        
        
}