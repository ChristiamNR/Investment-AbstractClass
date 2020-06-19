package consola;
import clase.*;

public class Principal {
	public static void main(String[] args) {
		
//CASO ÓPTIMO	
		System.out.println("---------------------------------");
		
		System.out.println("\n"+"CASO OPTIMO: USUARIO INGRESA TASA POSITIVA"+"\n");
		
		Negocio nego1 = new Negocio(500, 20, new double[] {100,200,300,400,500});
		nego1.evaluarRentabilidad();
				
		Negocio nego2 = new Negocio(500, 20, new double[] {100,200,300,400,500});
		nego2.setInversion(500);
		nego2.setTasa(40);
		nego2.setFlujos(new double[] {100,200,300,400,500});		
		nego2.evaluarRentabilidad();

		System.out.println("---------------------------------");
	
//CASO DE ERROR N.1 : USUARIO INTRODUCE TASA NEGATIVA
		System.out.println("\n"+"CASO DE ERROR : USUARIO INGRESA TASA NEGATIVA"+"\n");
		
		System.out.println("Objeto nego3: ");
		Negocio nego3 = new Negocio(500, -20, new double[] {100,200,300,400,500});
		nego3.evaluarRentabilidad();
		
		System.out.println("Objeto nego4: ");
		Negocio nego4 = new Negocio(500, 20, new double[] {100,200,300,400,500});
		nego4.setInversion(500);
		nego4.setTasa(-40);
		nego4.setFlujos(new double[] {100,200,300,400,500});		
		nego4.evaluarRentabilidad();
	
	}
}
