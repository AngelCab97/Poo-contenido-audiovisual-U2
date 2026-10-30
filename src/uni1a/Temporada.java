package uni1a;

public class Temporada {
    private int numero;
    private int cantidadEpisodios;
    private int anioEstreno;

    public Temporada(int numero, int cantidadEpisodios, int anioEstreno) {
        this.numero = numero;
        this.cantidadEpisodios = cantidadEpisodios;
        this.anioEstreno = anioEstreno;
    }

    public int getNumero() { return numero; }
    public int getCantidadEpisodios() { return cantidadEpisodios; }
    public int getAnioEstreno() { return anioEstreno; }

    @Override
    public String toString() {
        return "Temporada " + numero + " - " + cantidadEpisodios
               + " episodios (" + anioEstreno + ")";
    }
}