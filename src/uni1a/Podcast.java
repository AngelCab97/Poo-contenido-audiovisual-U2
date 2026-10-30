package uni1a;

//Subclase Podcast que extiende de ContenidoAudiovisual
public class Podcast extends ContenidoAudiovisual {
 private String anfitrion;
 private String plataforma;
 private int cantidadEpisodios;
 private Invitado invitado; // Asociación con Invitado

 public Podcast(String titulo, int duracionEnMinutos, String genero,
                String anfitrion, String plataforma, int cantidadEpisodios) {
     super(titulo, duracionEnMinutos, genero);
     this.anfitrion = anfitrion;
     this.plataforma = plataforma;
     this.cantidadEpisodios = cantidadEpisodios;
 }

 public String getAnfitrion() { return anfitrion; }
 public void setAnfitrion(String anfitrion) { this.anfitrion = anfitrion; }

 public String getPlataforma() { return plataforma; }
 public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

 public int getCantidadEpisodios() { return cantidadEpisodios; }
 public void setCantidadEpisodios(int cantidadEpisodios) { this.cantidadEpisodios = cantidadEpisodios; }

 public Invitado getInvitado() { return invitado; }
 public void setInvitado(Invitado invitado) { this.invitado = invitado; }

 // Suma un episodio nuevo al podcast
 public void publicarEpisodio() {
     cantidadEpisodios++;
 }

 @Override
 public void mostrarDetalles() {
     System.out.println("Detalles del podcast:");
     System.out.println("ID: " + getId());
     System.out.println("Título: " + getTitulo());
     System.out.println("Duración en minutos: " + getDuracionEnMinutos());
     System.out.println("Género: " + getGenero());
     System.out.println("Anfitrión: " + anfitrion);
     System.out.println("Plataforma: " + plataforma);
     System.out.println("Episodios: " + cantidadEpisodios);
     if (invitado != null) {
         System.out.println("Invitado: " + invitado);
     }
     System.out.println();
 }
}