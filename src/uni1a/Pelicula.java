/**
 * Class Pelicula
 */
package uni1a;

import java.util.ArrayList;

//Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
 private String estudio;
 private ArrayList<Actor> actores = new ArrayList<>(); // Agregación con Actor

 public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
     super(titulo, duracionEnMinutos, genero);
     this.estudio = estudio;
 }

 public String getEstudio() {
     return estudio;
 }

 public void setEstudio(String estudio) {
     this.estudio = estudio;
 }

 public void agregarActor(Actor actor) {
     actores.add(actor);
 }

 public ArrayList<Actor> getActores() {
     return actores;
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Detalles de la película:");
     System.out.println("ID: " + getId());
     System.out.println("Título: " + getTitulo());
     System.out.println("Duración en minutos: " + getDuracionEnMinutos());
     System.out.println("Género: " + getGenero());
     System.out.println("Estudio: " + estudio);
     if (!actores.isEmpty()) {
         System.out.println("Reparto:");
         for (Actor actor : actores) {
             System.out.println(" - " + actor);
         }
     }
     System.out.println();
 }
}