package com.mycompany.ordenar;
import java.io.*;
import java.util.Scanner;
public class Ordenar2 {
    public static void main(String[] args) throws IOException {
        //crear();
        File archivo = new File("C:/materias/datos/datos1.txt");
        FileReader fr=new FileReader(archivo);
        BufferedReader br=new BufferedReader(fr);
        int leer[]=new int[5000];
        String texto;
        for (int i = 0; i < 5000; i++) {
            texto=br.readLine();
            leer[i]=Integer.parseInt(texto);
        }
        //for (int i = 0; i < 5000; i++) {
        //  System.out.println(leer[i]);
        //}
      leer=ordenar(leer); 
 for (int i=0; i<5000; i++){
     System.out.println(leer [i]);
      }
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRUDUCE EL NUMERO QUE DESEAS BUSCAR");
          int numero= sc.nextInt();
         buscar0(300,leer,501);

   for(int i=100; i<=500;i++){
        System.out.println( "El número"+i+" se repite "+buscar0(i,leer)+" veces");
        }
   
   
   
   
   
 //System.out.println(buscar0(300, leer,0,leer.length-1));
    }
    
    static int buscar0(int x, int[] ll){
        for (int i=0;i<ll.length;i++){
            if(ll[i]==x) {
                //System.out.println("El valor esta en la pos=" + i);
               // return i;//en cuantro encuentra la primera posicionen donde esta el valor buscado imprime la primera posicion y a la vez cierra el metodo
            }//comentamos el retur i para qyue no se ciere el ciclo y muestre todas las posiciones 
        }
       //return -1;
        return 0;
    }
    
   static void  buscar0(int x, int[] ll, int y){
        for (int i=y;i<ll.length;i++){
            if(ll[i]==x) {
               //System.out.println("El valor esta en la pos=" + i);
               // return i;
            }
        } 
    }
 
    
 static int buscar1(int x, int [] leer){
     //arreglo leer[5000]
     int contador=0;
     for (int i=0; i<5000; i++){
     if(leer[i]==x){
     //System.out.println("El valor está en la posición:"+i);  
     contador=contador+1; 
          }
        }
     return contador;
    }

 static int buscar2(int x, int [] leer){
       //arreglo leer[5000]
     int contador=0;
     for (int i=0; i<5000; i++){
     if(leer[i]==55){
     //System.out.println("El valor está en la posición:"+i);  
     contador=contador+1;
            }
        }
     return contador;
    } 

     
 
 


static boolean buscaBin(int x, int[] arr,int i, int j){
    int   tam=j-i; //tam=arr.length;
    int centro=tam/2+i;
    // mitad =>  centro     arriba =>  centro+1, tam    abajo => o, o j  , centro-1
    if(arr[centro]==x) return true;
    else{
        if(arr[centro]>x) buscaBin(x,arr,i, centro-1);
        else buscaBin(x,arr,centro+1,j);
    }
    return false;
}
 
 static boolean buscaBin1(int x, int[] arr,int i, int j){
    while(i>=j){
        int centro=(j-i)/2;
         if(arr[centro]==300){ return true;
    }else if(300>=arr[centro]){
        j=centro-1;
    }else{
       i=centro+1; 
    }
    }
 return false;
 }
 
static int[] ordenarbs(int[] d){
boolean intercambio=true; 
while(intercambio){
intercambio=false; 
for(int i=0;i<d.length-1;i++) {
 if (d[i] > d[i + 1]) {
   int temp=d[i+1]; 
   d[i+1]=d[i];
   d[i]=temp;
   intercambio = true;
    }
   }
 }
return d;
 }


static int[] ordenarIS(int[] d){
    // aqui va el codigo
    int temporal=0, apuntador;
    //desde el segundo hasta el final repito...
    for(int i=1;i<d.length;i++) {
        temporal = d[i];
        apuntador=i;
        for (int j = i - 1; j >= 0; j--) {
            if(temporal<d[j]){
                d[apuntador]=d[j];
                apuntador--;
            }
            else{
                d[apuntador]=temporal;
                break;
            }
        }
    }
    //reviso los anteriores para encontrar el lugar...
    //coloco en el lugar y continuo
    return d;
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
    File archivo = new File("C:/materias/datos/datos1.txt");
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


	
