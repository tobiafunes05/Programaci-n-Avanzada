/*
Welcome to JDoodle!

You can execute code here in 110+ languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/
import java.util.Random;
public class MyClass {
  public static void main(String args[]) {
   System.out.println("Tobias Funes  Legajo: 114429");    
        
    int acumulador = 0; 
    double promedio=0;
    
    Random rand = new Random();

    
    for (int x=1;x<=500;x++){
        int num = rand.nextInt(1000 - 10 + 1) + 10;
        System.out.println(num); 
        acumulador = acumulador+num;  
    }
       System.out.println("La sumna de todos los numeros es, " + acumulador);   
        
       promedio= acumulador/500;
               
        System.out.println("El promedio de los 500,  " + promedio);       
  }
}