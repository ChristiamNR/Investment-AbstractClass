package clase;
import java.util.Scanner;
import javax.swing.JOptionPane;
public abstract class Inversion {
	Scanner leer = new Scanner(System.in);
/*----------------------------------------------------------------------------*/ 	
//Declarar variables
    private double   inversion, tasa, van, tir, prd;
    private double[] flujos;	
/*----------------------------------------------------------------------------*/ 
//Constructor  
    public Inversion(double inv, double ta, double[] f) {
    	this.inversion = inv;
		this.tasa = ta;
		this.flujos = f;
  }
/*----------------------------------------------------------------------------*/     
//Método principal   
    public void evaluarRentabilidad(){ 	
	    //Entrada de datos
	    inversion = getInversion();
	    tasa = getTasa(); 
	    if (tasa<0){
	    	System.out.println("Error en tasa"+"\n");
	    }
	    else{
		    flujos = getFlujos();	    
		    //Procesar
		    van = calcularVAN();
		    tir = calcularTIR();
		    prd = calcularPRD();
			    
		    //Salida de datos
		    mostrarVAN();
		    mostrarTIR();
		    mostrarPRD(); 
		    mostrarConclusion();
	    }
  }
/*----------------------------------------------------------------------------*/        
//Entrada de datos
  	//Getter
    public double getInversion(){
      	if(inversion>=0) {
      		return inversion=inversion*(-1);	
      	}  
  		else{
  			return inversion;
  		}    	
    }
    public double getTasa(){
      	return tasa/100;
    }  
  	public double[] getFlujos() {
		return flujos;
	}
  	public double getVAN(){
  		return van;
  	}
	//Setter
  	public void setInversion(double inv){
  		this.inversion = inv;
  	}
  	public void setTasa(double ta){
  		this.tasa= ta;
  	}
  	public void setFlujos(double[] f){
  		this.flujos = f;
  	}
/*----------------------------------------------------------------------------*/
//Procesar      
    public double calcularVAN(){
        double sum=0;
    	for (int i=0; i<flujos.length; i++){
            sum = sum + flujos[i]/Math.pow((1+tasa),(i+1));              
    	}       
        //Sumar inversion y flujos
        return Math.round((inversion + sum)*100d)/100d;
    }    	 	
    public double calcularTIR(){
        //Declarar constantes
        double RATIO_MIN = 0.01; 
        double RATIO_MAX = 0.5; 
        double REPETICION_MAX = 1000; 
        double PRECISION = 0.00000001; 
        
       //Declarar variables
        double anterior = 0.00;
        double nuevo = 0.00;	
        double nuevoRatioEstimado = RATIO_MIN; 
        double ratioEstimado = RATIO_MIN; 
        double minRatioEstimado = RATIO_MIN; 
        double maxRatioEstimado = RATIO_MAX; 
        double npv;
        double denom;
 
        for(int i=0; i<REPETICION_MAX; i++) {
            npv = 0.00;
            npv = npv + inversion;
                for(int j=0; j<flujos.length; j++) {
                    denom = Math.pow((1 + ratioEstimado),(j+1));
                    npv = npv + (flujos[j]/denom);
                }
  
            /* Se detiene cuando el VAN iguala a variable PRECISION */
            if((npv > 0) && (npv < PRECISION))
                break;
            if(anterior == 0)
                anterior = npv;
            else
                anterior = nuevo;
            nuevo = npv;
            if(i > 0) {
                if(anterior < nuevo) {
                    if(anterior < 0 && nuevo < 0)
                        maxRatioEstimado = nuevoRatioEstimado;
                    else
                        minRatioEstimado = nuevoRatioEstimado;
                }
                else {
                    if(anterior > 0 && nuevo > 0)
                        minRatioEstimado = nuevoRatioEstimado;
                    else
                        maxRatioEstimado = nuevoRatioEstimado;
                }
            }
            ratioEstimado = (minRatioEstimado + maxRatioEstimado)/2;
            nuevoRatioEstimado = ratioEstimado;
        }
        return Math.round(ratioEstimado*10000d)/10000d;
    }
	public double calcularPRD(){
    	double sum=0;
        int i=0;
        while(i<flujos.length){  
            sum = sum + flujos[i]/Math.pow((1+tasa),(i+1));          
            if(sum>(inversion*-1)){
                sum = sum - flujos[i]/Math.pow((1+tasa),(i+1));
                return Math.round((i-(inversion+sum)/(flujos[i]/Math.pow((1+tasa),(i+1))))*100d)/100d;
            }
            i++;
        }      
        return -99;
	}
/*----------------------------------------------------------------------------*/           
//Salida de datos 
    public abstract void mostrarConclusion();
    
    public void mostrarVAN(){
        System.out.println("Su Valorización : "+van); 
    }
    public void mostrarTIR() {
    	System.out.println("Su Rentabilidad : "+tir*100+"%"); 
    }
    public void mostrarPRD(){
    	System.out.println("Años para recuperarse : "+prd); 
    }
}