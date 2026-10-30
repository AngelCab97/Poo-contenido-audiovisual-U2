package uni1a;

public class Investigador {
    private String nombre;
    private String especialidad;
    private int aniosExperiencia;

    public Investigador(String nombre, String especialidad, int aniosExperiencia) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public int getAniosExperiencia() { return aniosExperiencia; }

    @Override
    public String toString() {
        return nombre + " - " + especialidad + " (" + aniosExperiencia + " años de experiencia)";
    }
}