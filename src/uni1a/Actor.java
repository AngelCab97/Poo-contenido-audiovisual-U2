package uni1a;

public class Actor {
    private String nombre;
    private int edad;
    private String nacionalidad;

    public Actor(String nombre, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getNacionalidad() { return nacionalidad; }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + nacionalidad + ")";
    }
}