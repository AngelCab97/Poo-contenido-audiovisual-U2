/**
 * Class SerieDeTV
 */
package uni1a;

import java.util.ArrayList;

//Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
 private ArrayList<Temporada> temporadas = new ArrayList<>(); // Composición con Temporada

 public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
     super(titulo, duracionEnMinutos, genero);
 }

 // La serie crea la temporada por dentro (composición)
 public void agregarTemporada(int numero, int cantidadEpisodios, int anioEstreno) {
     temporadas.add(new Temporada(numero, cantidadEpisodios, anioEstreno));
 }

 public ArrayList<Temporada> getTemporadas() {
     return temporadas;
 }

 public int getCantidadTemporadas() {
     return temporadas.size();
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Detalles de la serie de TV:");
     System.out.println("ID: " + getId());
     System.out.println("Título: " + getTitulo());
     System.out.println("Duración en minutos: " + getDuracionEnMinutos());
     System.out.println("Género: " + getGenero());
     System.out.println("Temporadas: " + getCantidadTemporadas());
     for (Temporada temporada : temporadas) {
         System.out.println(" - " + temporada);
     }
     System.out.println();
 }
}