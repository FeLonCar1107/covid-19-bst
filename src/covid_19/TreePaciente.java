package covid_19;

import java.util.Arrays;

public class TreePaciente {

	NodoPaciente root;
	int mayor = 0;
	int cantFiebres = 0;
	float sumaTarifa = 0;
	int cantPacientes = 0;
	
	public void addPaciente(Paciente newPaciente) {
		
		if (root == null) {
			
			root = new NodoPaciente(newPaciente);
	        System.out.println(newPaciente.nombre + " registrado exitosamente ");
	        sumaTarifa = sumaTarifa + newPaciente.TarifaPaciente();
	        cantPacientes++;
	        if (newPaciente.cantSintomas() > mayor) {
				mayor = newPaciente.cantSintomas();
			}
	    	for (int i = 0; i < newPaciente.sintomas.length; i++) {
	    		if (newPaciente.sintomas[i].equals("fiebre")) {
	    			cantFiebres++;
	    		}
	    	}
			return;
			
		}else 
		
		addPaciente(root,newPaciente);
	}
	
	private void addPaciente(NodoPaciente nodo, Paciente newPaciente) {
		
		if (nodo == null) {
			return;
		}
		if(newPaciente.id > nodo.paciente.id) {
			
		   if(nodo.right == null) {
			nodo.right = new NodoPaciente(newPaciente);
			sumaTarifa = sumaTarifa + newPaciente.TarifaPaciente();
			cantPacientes++;
			 if (newPaciente.cantSintomas() > mayor) {
					mayor = newPaciente.cantSintomas();
				}
			 for (int i = 0; i < newPaciente.sintomas.length; i++) {
		    		if (newPaciente.sintomas[i].equals("fiebre")) {
		    			cantFiebres++;
		    		}
		    	}
	        System.out.println(newPaciente.nombre + " registrado exitosamente ");

		   }
		   else {
			addPaciente(nodo.right, newPaciente);
		   }
	    }
	       else if(newPaciente.id < nodo.paciente.id) {
	    	        
	    	        if(nodo.left == null) {
			        nodo.left = new NodoPaciente(newPaciente);
			        sumaTarifa = sumaTarifa + newPaciente.TarifaPaciente();
			        cantPacientes++;
			        if (newPaciente.cantSintomas() > mayor) {
						mayor = newPaciente.cantSintomas();
					}
			        for (int i = 0; i < newPaciente.sintomas.length; i++) {
			    		if (newPaciente.sintomas[i].equals("fiebre")) {
			    			cantFiebres++;
			    		}
			    	}
	                System.out.println(newPaciente.nombre + " registrado exitosamente ");
	                
	    	        }
		             else {
			               addPaciente(nodo.left, newPaciente);
		            }
	       }
		else {
			System.out.println("El ID de " + newPaciente.nombre + " ya habia sido registrado");
		}
	   }
	
	public Paciente registrado() {
		return registrado(root, root.paciente.id);
	}

	private Paciente registrado(NodoPaciente nodo, int id) {

		if(nodo == null) {
			return null;
		}

		if(nodo.paciente.id == id){
			System.out.println("El paciente " + nodo.paciente.nombre + " ya esta registrado en el sistema");
			return nodo.paciente;
		}

		if(nodo.paciente.id < id) {
			return registrado(nodo.right, id);
		}

		return registrado(nodo.left, id);
	}
	
	public Paciente sintomas(int id) {
		return sintomas(root, id);
	}
	
	private Paciente sintomas(NodoPaciente nodo, int id) {

		if(nodo == null) {
			return null;
		}

		if(nodo.paciente.id == id){
	
			System.out.println("El paciente " + nodo.paciente.nombre + " presenta "+ nodo.paciente.cantSintomas() + " sintomas: " + Arrays.toString(nodo.paciente.sintomas) + " debe pagar: " + nodo.paciente.TarifaPaciente());
			return nodo.paciente;
		}

		if(nodo.paciente.id < id) {
			return sintomas(nodo.right, id);
		}

		return sintomas(nodo.left, id);
	}

	public float obtenerPromedio() {
		float total = 0;
	    total = sumaTarifa / cantPacientes;
		return total;
	}
	
	public int obtenerMayor() {
		int total = 0;
	    total = total + mayor;
		return total;
	}
	
	public int obtenerCantFiebres() {
		int total = 0;
		total = total + cantFiebres;
		return total;
	}
}
	
