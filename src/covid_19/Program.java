package covid_19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {

		TreePaciente tree = new TreePaciente();	
		
        BufferedReader bf = new BufferedReader(new FileReader("datos-covid19.txt"));
		
		int pacientes = Integer.parseInt(bf.readLine());
		
		String[] arrDataPacientes;
		
		for(int i=0; i<pacientes; i++) {
			arrDataPacientes = bf.readLine().split(",");
			Paciente p = new Paciente(arrDataPacientes[0],Integer.parseInt(arrDataPacientes[1]),arrDataPacientes[2],arrDataPacientes[3],arrDataPacientes[4],arrDataPacientes[5],arrDataPacientes[6]);
			tree.addPaciente(p);
			}	
	    
		tree.sintomas(54);
	    tree.sintomas(17);
	    tree.sintomas(45);
	    tree.sintomas(11);
	    tree.sintomas(17);
	    
	   System.out.println("El promedio por concepto de tarifas es: " + tree.obtenerPromedio());
	   System.out.println("El Paciente con mayor numero de sintomas tiene " + tree.obtenerMayor());
	   System.out.println("La cantidad de pacientes con fiebre es: " + tree.cantFiebres);
	    
	}
}



