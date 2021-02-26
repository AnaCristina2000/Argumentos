package postfija;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfija implements Runnable{
    //No evalua expresiones con numeros negativos 
    File archivo = new File("C:/Users/noloo/Documents/NetBeansProjects/Framework02/infija.txt");
   
    
    public void run() {          
           try{
            if(archivo.exists()){//esta condicion permite saber si existe el archivo
              BufferedReader archivolectura= new BufferedReader(new FileReader(archivo));  
              String infija;  
              
               
              while((infija= archivolectura.readLine()) !=null){//Mientras la linea leida no sea null                
                 System.out.println("Notación infija: "+infija);
                 String postfija=postfija(infija);//se pasa la notacion infija al metodo ´postica paraconvertirlo a notacion postfija
                 System.out.println("Posfija: "+postfija);//expresion en notacion postfija
                 System.out.println("Resultado: "+evaluar(postfija)+"\n");//evalua la expresion aritnmetica 
                  
                  StringTokenizer st= new StringTokenizer(infija);//Aqui contamos las palbras de la linea
              }
            archivolectura.close();
            }else{
            System.out.println("NO HAY ARCHIVO EXISTENTE :´v");  
            } 
          }catch(Exception e){
              System.out.println(e.getMessage()); 
          }
           
    }
    public static void main(String[] args) {
        System.out.println(" ");
         Thread t = new Thread( new Postfija() );
         t.start();
      }
    
public static String postfija(String infija){
    //le pasamos la cadena infija, el true indica que tambien regrese los separadores 
     StringTokenizer st=new StringTokenizer(infija, "()+-/* ",true);//separa en simbolos una cadena , indicamos los caracteres que vamos a emprear 
     
     Stack<String> pilaOperadores = new  Stack<String>();//creamos la pila que utilizaremos
     
     StringBuilder postfija = new StringBuilder();//cadena para guardar la expresion posfija 
    
     String token=null;  
     
      while(st.hasMoreTokens()){//verifica si hay simbolos que se puedan recuperar
         String simbolo= st.nextToken().trim();//nos regresa el siguiente simbolo
         
          if(simbolo.isEmpty()){//se verifica si la cadena esta vacia
            continue;
            }
          if(simbolo.equals("(")){//si el simbolo es el parentesis que abre
            pilaOperadores.push(simbolo);
            continue;  
          }
          if(simbolo.equals(")")){ 
             do{
                token=pilaOperadores.pop();//sacamos todos losoperadores hasta que encontremos el parentesis que abre 
                if(!token.equals("(")){
                   postfija.append(token);//agregamos el operando 
                   postfija.append("");
                }
            }while(!token.equals("("));
            //pilaOperadores.push(token);
            continue;
         }
         
        if(esOperador(simbolo.trim())){//si no es un oprador e mete a la pila 
           while(!pilaOperadores.empty()){
               
               token = pilaOperadores.peek();//con peeak revisamos el elemnto al tope de la pila
               if(precedencia(token) < precedencia(simbolo)){
                  postfija.append(pilaOperadores.pop());
                  postfija.append(" ");
                  continue;
               }else{
                   break;
               }
           } 
           pilaOperadores.push(simbolo);
           continue;
        } 
        postfija.append(simbolo);
        postfija.append(" ");
     }
      while(!pilaOperadores.empty()){
       postfija.append(pilaOperadores.pop());
       postfija.append(" ");
      }
     return postfija.toString();
     
     } 
     
 public static double evaluar(String postfija){
     double result= 0.0;
     
     Stack<Double> pila= new Stack<Double>();//aqui en al pila tenemos los numeros
     
     StringTokenizer st=new StringTokenizer(postfija, "+-/* ",true);//separacadenas en toke
     
     while(st.hasMoreTokens()){
       String simbolo=st.nextToken().trim();
       if(simbolo.isEmpty()){
           continue;
       }
       if(simbolo.equals("*")||simbolo.equals("/")||simbolo.equals("+")||simbolo.equals("-")){
        double o2=pila.pop();
        double o1=pila.pop();
        
        pila.push(calcular(o1,o2, simbolo));
       }else{
           Double value = Double.parseDouble(simbolo);
           pila.push(value);
       }     
     }
     if(!pila.empty()){
        result =pila.pop();
     }
     return result;
 }  
     
 public static double calcular(double o1, double o2, String oper) {
   double resultado=0.0;
   switch (oper){
       case "*":
           resultado=o1*o2;
           break;
       case "/":
           resultado=o1/o2;
           break;
       case "+":
           resultado=o1+o2;
           break;
        case "-":
           resultado=o1-o2;
           break;  
   }
 return resultado;
 }  
 
 public static boolean esOperador(String token) {
        return "*/+-".contains(token);
    }

   
 public static int precedencia(String token) {
    int precedencia =100;//Se inicia con 100 para asi no regrese valor fuera del rango
    if(token.equals("+")||token.equals("-")){
      precedencia=2;  
    }
    if(token.equals("*")||token.equals("/")){
      precedencia=1;  
    }
    return precedencia;

  }

   
 
 

    
    
}
