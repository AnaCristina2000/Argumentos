public class ArgumentoS {
    public static void main(String[] args) {
        System.out.printf("numero de argumentos: %d\n", args.length);
        if (args.length>0){
            for(String argumento: args){
                System.out.println(argumento);
                
                
            }
            System.out.println("La sumatoria es: " );
            System.out.println(suma(args));
            System.out.println("la media es: ");
            System.out.println(media(args));
            System.out.println("El mayor es: ");
            System.out.println(mayor(args));
            System.out.println("el menor es: ");
            System.out.println(menor(args));
        }  

    }
    
static int suma(String[] args) { 
    int suma=0;
      for(int i=0; i<args.length; i++){
            int a=Integer.parseInt(args[i]);
                
                suma=suma + a;
        }   
     return suma;
     }
static int media(String[] args) { 
    int suma=0;
      for(int i=0; i<args.length; i++){
            int a=Integer.parseInt(args[i]); 
                suma=suma + a;
               
        }   
     return suma/args.length;
     }

static int mayor(String[] args) { 
    int mayor=-1;
      for(int i=0; i<args.length; i++){
            int a=Integer.parseInt(args[i]); 
              if(a>mayor){
                  mayor=a;
              }
        }   
     return mayor;
     }
static int menor(String[] args) { 
    int menor=0;
      for(int i=0; i<args.length; i++){
            int a=Integer.parseInt(args[i]); 
              if(i==0){
                  menor=a;
              }else{
                 if(a<menor){
                  menor=a;
              }
              }
        }   
     return menor;
     }
    
}
