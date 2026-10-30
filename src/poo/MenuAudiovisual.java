package poo;

import java.util.ArrayList;
import java.util.Scanner;
import uni1a.*;

public class MenuAudiovisual {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<ContenidoAudiovisual> contenidos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ", 0);
            switch (opcion) {
                case 1 -> registrarPelicula();
                case 2 -> registrarSerie();
                case 3 -> registrarDocumental();
                case 4 -> registrarPodcast();
                case 5 -> registrarConcierto();
                case 6 -> listarTodo();
                case 7 -> buscarPorTitulo();
                case 8 -> agregarElemento();
                case 9 -> accionesEspeciales();
                case 10 -> eliminarContenido();
                case 11 -> cargarDatosDeEjemplo();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== GESTOR DE CONTENIDO AUDIOVISUAL =====");
        System.out.println("1. Registrar película");
        System.out.println("2. Registrar serie de TV");
        System.out.println("3. Registrar documental");
        System.out.println("4. Registrar podcast");
        System.out.println("5. Registrar concierto");
        System.out.println("6. Listar todo el contenido");
        System.out.println("7. Buscar por título");
        System.out.println("8. Agregar actor/temporada/investigador/invitado/canción");
        System.out.println("9. Acciones especiales (publicar episodio, duración del setlist)");
        System.out.println("10. Eliminar contenido");
        System.out.println("11. Cargar datos de ejemplo");
        System.out.println("0. Salir");
    }

    // ---------- Registro de contenido ----------

    private static void registrarPelicula() {
        System.out.println("--- Nueva película ---");
        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ", 1);
        String genero = leerTexto("Género: ");
        String estudio = leerTexto("Estudio: ");
        Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);

        int cantidad = leerEntero("¿Cuántos actores quieres agregar? (0 = ninguno): ", 0);
        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Actor " + i + ":");
            pelicula.agregarActor(crearActor());
        }
        contenidos.add(pelicula);
        System.out.println("Película registrada con ID " + pelicula.getId() + ".");
    }

    private static void registrarSerie() {
        System.out.println("--- Nueva serie de TV ---");
        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración por episodio en minutos: ", 1);
        String genero = leerTexto("Género: ");
        SerieDeTV serie = new SerieDeTV(titulo, duracion, genero);

        int cantidad = leerEntero("¿Cuántas temporadas quieres agregar? (0 = ninguna): ", 0);
        for (int i = 0; i < cantidad; i++) {
            agregarTemporadaA(serie);
        }
        contenidos.add(serie);
        System.out.println("Serie registrada con ID " + serie.getId() + ".");
    }

    private static void registrarDocumental() {
        System.out.println("--- Nuevo documental ---");
        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ", 1);
        String genero = leerTexto("Género: ");
        String tema = leerTexto("Tema: ");
        Documental documental = new Documental(titulo, duracion, genero, tema);

        if (leerSiNo("¿Asignar un investigador?")) {
            documental.setInvestigador(crearInvestigador());
        }
        contenidos.add(documental);
        System.out.println("Documental registrado con ID " + documental.getId() + ".");
    }

    private static void registrarPodcast() {
        System.out.println("--- Nuevo podcast ---");
        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración por episodio en minutos: ", 1);
        String genero = leerTexto("Género: ");
        String anfitrion = leerTexto("Anfitrión: ");
        String plataforma = leerTexto("Plataforma: ");
        int episodios = leerEntero("Cantidad de episodios actuales: ", 0);
        Podcast podcast = new Podcast(titulo, duracion, genero, anfitrion, plataforma, episodios);

        if (leerSiNo("¿Agregar un invitado?")) {
            podcast.setInvitado(crearInvitado());
        }
        contenidos.add(podcast);
        System.out.println("Podcast registrado con ID " + podcast.getId() + ".");
    }

    private static void registrarConcierto() {
        System.out.println("--- Nuevo concierto ---");
        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ", 1);
        String genero = leerTexto("Género: ");
        String artista = leerTexto("Artista: ");
        String lugar = leerTexto("Lugar: ");
        String fecha = leerTexto("Fecha (dd/mm/aaaa): ");
        Concierto concierto = new Concierto(titulo, duracion, genero, artista, lugar, fecha);

        int cantidad = leerEntero("¿Cuántas canciones tiene el setlist? (0 = ninguna): ", 0);
        for (int i = 0; i < cantidad; i++) {
            agregarCancionA(concierto);
        }
        contenidos.add(concierto);
        System.out.println("Concierto registrado con ID " + concierto.getId() + ".");
    }

    // ---------- Creación de clases de apoyo ----------

    private static Actor crearActor() {
        String nombre = leerTexto("  Nombre del actor: ");
        int edad = leerEntero("  Edad: ", 1);
        String nacionalidad = leerTexto("  Nacionalidad: ");
        return new Actor(nombre, edad, nacionalidad);
    }

    private static Investigador crearInvestigador() {
        String nombre = leerTexto("  Nombre del investigador: ");
        String especialidad = leerTexto("  Especialidad: ");
        int anios = leerEntero("  Años de experiencia: ", 0);
        return new Investigador(nombre, especialidad, anios);
    }

    private static Invitado crearInvitado() {
        String nombre = leerTexto("  Nombre del invitado: ");
        String profesion = leerTexto("  Profesión: ");
        return new Invitado(nombre, profesion);
    }

    private static void agregarTemporadaA(SerieDeTV serie) {
        int numero = serie.getCantidadTemporadas() + 1;
        System.out.println("Temporada " + numero + ":");
        int episodios = leerEntero("  Cantidad de episodios: ", 1);
        int anio = leerEntero("  Año de estreno: ", 1900);
        serie.agregarTemporada(numero, episodios, anio);
    }

    private static void agregarCancionA(Concierto concierto) {
        System.out.println("Canción " + (concierto.getSetlist().size() + 1) + ":");
        String titulo = leerTexto("  Título: ");
        int segundos = leerEntero("  Duración en segundos: ", 1);
        concierto.agregarCancion(titulo, segundos);
    }

    // ---------- Consulta y manipulación ----------

    private static void listarTodo() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenido registrado todavía.");
            return;
        }
        for (ContenidoAudiovisual c : contenidos) {
            c.mostrarDetalles();
        }
    }

    private static void listarResumen() {
        for (ContenidoAudiovisual c : contenidos) {
            System.out.println("[" + c.getId() + "] " + c.getTitulo()
                    + " (" + c.getClass().getSimpleName() + ")");
        }
    }

    private static void buscarPorTitulo() {
        String texto = leerTexto("Texto a buscar en el título: ").toLowerCase();
        int encontrados = 0;
        for (ContenidoAudiovisual c : contenidos) {
            if (c.getTitulo().toLowerCase().contains(texto)) {
                c.mostrarDetalles();
                encontrados++;
            }
        }
        if (encontrados == 0) {
            System.out.println("No se encontró ningún contenido con ese título.");
        }
    }

    private static ContenidoAudiovisual buscarPorId(int id) {
        for (ContenidoAudiovisual c : contenidos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private static ContenidoAudiovisual elegirContenido() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenido registrado todavía.");
            return null;
        }
        listarResumen();
        int id = leerEntero("ID del contenido: ", 0);
        ContenidoAudiovisual c = buscarPorId(id);
        if (c == null) {
            System.out.println("No existe un contenido con ese ID.");
        }
        return c;
    }

    private static void agregarElemento() {
        ContenidoAudiovisual c = elegirContenido();
        if (c == null) return;

        if (c instanceof Pelicula p) {
            p.agregarActor(crearActor());
            System.out.println("Actor agregado a \"" + p.getTitulo() + "\".");
        } else if (c instanceof SerieDeTV s) {
            agregarTemporadaA(s);
            System.out.println("Temporada agregada. Total: " + s.getCantidadTemporadas() + ".");
        } else if (c instanceof Documental d) {
            d.setInvestigador(crearInvestigador());
            System.out.println("Investigador asignado a \"" + d.getTitulo() + "\".");
        } else if (c instanceof Podcast pod) {
            pod.setInvitado(crearInvitado());
            System.out.println("Invitado asignado a \"" + pod.getTitulo() + "\".");
        } else if (c instanceof Concierto con) {
            agregarCancionA(con);
            System.out.println("Canción agregada al setlist.");
        }
    }

    private static void accionesEspeciales() {
        ContenidoAudiovisual c = elegirContenido();
        if (c == null) return;

        if (c instanceof Podcast pod) {
            pod.publicarEpisodio();
            System.out.println("Episodio publicado. Total: " + pod.getCantidadEpisodios() + ".");
        } else if (c instanceof Concierto con) {
            System.out.printf("Duración del setlist: %.1f min (%d canciones)%n",
                    con.calcularDuracionSetlist(), con.getSetlist().size());
        } else {
            System.out.println("Este contenido no tiene acciones especiales.");
        }
    }

    private static void eliminarContenido() {
        ContenidoAudiovisual c = elegirContenido();
        if (c == null) return;

        if (leerSiNo("¿Seguro que quieres eliminar \"" + c.getTitulo() + "\"?")) {
            contenidos.remove(c);
            System.out.println("Contenido eliminado.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private static void cargarDatosDeEjemplo() {
        Pelicula avatar = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        avatar.agregarActor(new Actor("Sam Worthington", 49, "Australiana"));
        avatar.agregarActor(new Actor("Zoe Saldaña", 48, "Estadounidense"));

        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy");
        got.agregarTemporada(1, 10, 2011);
        got.agregarTemporada(2, 10, 2012);

        Documental cosmos = new Documental("Cosmos", 45, "Science", "Astronomy");
        cosmos.setInvestigador(new Investigador("Carl Sagan", "Astronomía", 40));

        Podcast podcast = new Podcast("Entre Códigos", 60, "Tecnología",
                "Andrés Mora", "Spotify", 25);
        podcast.setInvitado(new Invitado("Laura Vega", "Ingeniera de software"));

        Concierto concierto = new Concierto("Noche de Rock", 120, "Rock",
                "Los Andinos", "Estadio Alejandro Serrano Aguilar", "15/11/2026");
        concierto.agregarCancion("Camino al Sur", 245);
        concierto.agregarCancion("Luces de Cuenca", 198);

        contenidos.add(avatar);
        contenidos.add(got);
        contenidos.add(cosmos);
        contenidos.add(podcast);
        contenidos.add(concierto);
        System.out.println("Se cargaron 5 contenidos de ejemplo.");
    }

    // ---------- Lectura segura de datos ----------

    private static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static int leerEntero(String mensaje, int minimo) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                if (valor >= minimo) {
                    return valor;
                }
                System.out.println("El valor debe ser mayor o igual a " + minimo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    private static boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            System.out.println("Responde con 's' o 'n'.");
        }
    }
}