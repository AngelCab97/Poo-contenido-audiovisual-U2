package uni1a;

public class Cancion {
    private String titulo;
    private int duracionSegundos;

    public Cancion(String titulo, int duracionSegundos) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
    }

    public String getTitulo() { return titulo; }
    public int getDuracionSegundos() { return duracionSegundos; }

    @Override
    public String toString() {
        int min = duracionSegundos / 60;
        int seg = duracionSegundos % 60;
        return titulo + " (" + min + ":" + String.format("%02d", seg) + ")";
    }
}