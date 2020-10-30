package covid_19;

public class Paciente {
	
	public Paciente(String nombre, int id, String fiebre, String tos, String cansancio, String dolorDeCabeza,String perderGusto) {

		this.nombre = nombre;
		this.id = id;
		this.sintomas[0] = fiebre;
		this.sintomas[1] = tos;
		this.sintomas[2] = cansancio;
		this.sintomas[3] = dolorDeCabeza;
		this.sintomas[4] = perderGusto;
		
	}

	public String nombre;
	public int id;
	String[] sintomas = {"fiebre","tos","cansancio","dolorDeCabeza","perderGusto"};
	
	public int cantSintomas() {
		int total = 0;
	for (int i = 0; i < sintomas.length; i++) {
		if (!sintomas[i].equals("null")) {
			total++;
		}
	}
	return total;
	}
	
	public float TarifaPaciente() {
		float total = 0;
		total = cantSintomas() * 100;
		return total;
	}
}
