package poo;
import uni1a.*;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Película con actores (agregación)
        Pelicula avatar = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        Actor actor1 = new Actor("Sam Worthington", 49, "Australiana");
        Actor actor2 = new Actor("Zoe Saldaña", 48, "Estadounidense");
        avatar.agregarActor(actor1);
        avatar.agregarActor(actor2);

        // Serie con temporadas (composición)
        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy");
        got.agregarTemporada(1, 10, 2011);
        got.agregarTemporada(2, 10, 2012);
        got.agregarTemporada(3, 10, 2013);

        // Documental con investigador (asociación)
        Documental cosmos = new Documental("Cosmos", 45, "Science", "Astronomy");
        Investigador investigador = new Investigador("Carl Sagan", "Astronomía", 40);
        cosmos.setInvestigador(investigador);

        // Podcast con invitado (asociación)
        Podcast podcast = new Podcast("Entre Códigos", 60, "Tecnología",
                                      "Andrés Mora", "Spotify", 25);
        podcast.setInvitado(new Invitado("Laura Vega", "Ingeniera de software"));
        podcast.publicarEpisodio();

        // Concierto con canciones (composición)
        Concierto concierto = new Concierto("Noche de Rock", 120, "Rock",
                                            "Los Andinos", "Estadio Alejandro Serrano Aguilar", "15/11/2026");
        concierto.agregarCancion("Camino al Sur", 245);
        concierto.agregarCancion("Luces de Cuenca", 198);
        concierto.agregarCancion("Madrugada", 312);

        // Arreglo polimórfico
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];
        contenidos[0] = avatar;
        contenidos[1] = got;
        contenidos[2] = cosmos;
        contenidos[3] = podcast;
        contenidos[4] = concierto;

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
}