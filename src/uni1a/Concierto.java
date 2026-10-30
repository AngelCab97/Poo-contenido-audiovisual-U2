package uni1a;

import java.util.ArrayList;

//Subclase Concierto que extiende de ContenidoAudiovisual
public class Concierto extends ContenidoAudiovisual {
 private String artista;
 private String lugar;
 private String fecha;
 private ArrayList<Cancion> setlist = new ArrayList<>(); // Composición con Cancion

 public Concierto(String titulo, int duracionEnMinutos, String genero,
                  String artista, String lugar, String fecha) {
     super(titulo, duracionEnMinutos, genero);
     this.artista = artista;
     this.lugar = lugar;
     this.fecha = fecha;
 }

 public String getArtista() { return artista; }
 public void setArtista(String artista) { this.artista = artista; }

 public String getLugar() { return lugar; }
 public void setLugar(String lugar) { this.lugar = lugar; }

 public String getFecha() { return fecha; }
 public void setFecha(String fecha) { this.fecha = fecha; }

 // El concierto crea la canción por dentro (composición)
 public void agregarCancion(String titulo, int duracionSegundos) {
     setlist.add(new Cancion(titulo, duracionSegundos));
 }

 public ArrayList<Cancion> getSetlist() { return setlist; }

 // Suma la duración de todas las canciones y la devuelve en minutos
 public double calcularDuracionSetlist() {
     int totalSegundos = 0;
     for (Cancion cancion : setlist) {
         totalSegundos += cancion.getDuracionSegundos();
     }
     return totalSegundos / 60.0;
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Detalles del concierto:");
     System.out.println("ID: " + getId());
     System.out.println("Título: " + getTitulo());
     System.out.println("Duración en minutos: " + getDuracionEnMinutos());
     System.out.println("Género: " + getGenero());
     System.out.println("Artista: " + artista);
     System.out.println("Lugar: " + lugar);
     System.out.println("Fecha: " + fecha);
     if (!setlist.isEmpty()) {
         System.out.println("Setlist (" + setlist.size() + " canciones, "
                 + String.format("%.1f", calcularDuracionSetlist()) + " min):");
         for (Cancion cancion : setlist) {
             System.out.println(" - " + cancion);
         }
     }
     System.out.println();
 }
}