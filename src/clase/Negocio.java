package clase;

public class Negocio extends Inversion {    
/*----------------------------------------------------------------------------*/        
public Negocio(double inv, double ta, double[] f) {
		super(inv, ta, f);
		// TODO Auto-generated constructor stub
	}
/*----------------------------------------------------------------------------*/           
//Implementar m�todo
    public void mostrarConclusion(){  
    	if (getVAN()>0) 
    		System.out.println("CONCLUSI�N : S� ES RENTABLE"+"\n"); 
        else if (getVAN()==0)
            System.out.println("CONCLUSI�N : NO GENERA GANANCIAS NI P�RDIDAS"+"\n"); 
        else 
        	System.out.println("CONCLUSI�N : NO ES RENTABLE"+"\n");    
    }     
/*----------------------------------------------------------------------------*/
}
