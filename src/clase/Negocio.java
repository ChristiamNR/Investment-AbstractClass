package clase;

public class Negocio extends Inversion {    
/*----------------------------------------------------------------------------*/        
public Negocio(double inv, double ta, double[] f) {
		super(inv, ta, f);
		// TODO Auto-generated constructor stub
	}
/*----------------------------------------------------------------------------*/           
//Implementar método
    public void mostrarConclusion(){  
    	if (getVAN()>0) 
    		System.out.println("CONCLUSIÓN : SÍ ES RENTABLE"+"\n"); 
        else if (getVAN()==0)
            System.out.println("CONCLUSIÓN : NO GENERA GANANCIAS NI PÉRDIDAS"+"\n"); 
        else 
        	System.out.println("CONCLUSIÓN : NO ES RENTABLE"+"\n");    
    }     
/*----------------------------------------------------------------------------*/
}
