package covid_19;

public class NodoPaciente {

	public NodoPaciente(Paciente newPaciente) {
		this.paciente = newPaciente;
	}
	
	Paciente paciente;
	NodoPaciente left;
	NodoPaciente right;
}
