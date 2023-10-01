package gestorAplicacion;

//Para hacer tests
import java.util.*;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;


public class main {

    public static void main(String[] args) {
    	Random rand = new Random();
    	double lowerBound=0.2;
    	double upperBound=0.8;
    	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble(); //Generating a number within certain bouns
    	System.out.println(numRandom); 
    }
}
