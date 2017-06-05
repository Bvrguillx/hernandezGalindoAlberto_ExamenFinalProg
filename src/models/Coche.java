package models;

public class Coche {

	// ATRIBUTOS
	protected String horaSubida;
	protected String horaSalida;
	protected String matricula;

	// CONSTRUCTOR
	public Coche(String matricula) {
		this.matricula = matricula;
	}

	public Coche(String horaSubida, String matricula, String horaSalida) {
		super();
		this.horaSubida = horaSubida;
		this.matricula = matricula;
		this.horaSalida = horaSalida;
	}

	// GETTERS AND SETTERS
	public String getHoraSubida() {
		return horaSubida;
	}

	public void setHoraSubida(String horaSubida) {
		this.horaSubida = horaSubida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + "]";
	}

}
