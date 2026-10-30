package uni1a;

public class Invitado {
    private String nombre;
    private String profesion;

    public Invitado(String nombre, String profesion) {
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public String getNombre() { return nombre; }
    public String getProfesion() { return profesion; }

    @Override
    public String toString() {
        return nombre + " (" + profesion + ")";
    }
}