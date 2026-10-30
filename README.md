# Gestor de Contenido Audiovisual

Programación Orientada a Objetos (Unidad 2: Relación entre clases)  
Universidad Politécnica Salesiana

**Autor:** Angel Cabrera

## Descripción y objetivos

Aplicación en Java que modela distintos tipos de contenido audiovisual (películas, series, documentales, podcasts y conciertos) a partir de una clase base. Su objetivo es practicar herencia, asociación, agregación y composición entre clases, y ofrecer un sistema funcional por consola para crear y manipular objetos de todas ellas.

## Estructura del proyecto

```
src/
├── poo/
│   ├── MenuAudiovisual.java      (menú interactivo por consola)
│   └── PruebaAudioVisual.java    (prueba rápida con datos fijos)
└── uni1a/
    └── (clases del modelo)
```

## Clases del modelo

**Clases originales:** `ContenidoAudiovisual` (clase base abstracta), `Pelicula`, `SerieDeTV` y `Documental`.

**Clases nuevas y sus relaciones:**

| Clase | Relación | Con |
|---|---|---|
| `Actor` | Agregación | `Pelicula` |
| `Temporada` | Composición | `SerieDeTV` |
| `Investigador` | Asociación | `Documental` |
| `Podcast` (subclase) | Herencia | `ContenidoAudiovisual` |
| `Concierto` (subclase) | Herencia | `ContenidoAudiovisual` |
| `Invitado` | Asociación | `Podcast` |
| `Cancion` | Composición | `Concierto` |

## Funcionalidades

- Registrar películas, series, documentales, podcasts y conciertos.
- Agregar actores, temporadas, investigadores, invitados y canciones a contenidos ya creados.
- Listar todo el contenido y buscar por título.
- Publicar episodios de un podcast y calcular la duración del setlist de un concierto.
- Eliminar contenido y cargar datos de ejemplo.

## Cómo clonar y ejecutar

1. Clona el repositorio:
   ```
   git clone https://github.com/AngelCab97/Poo-contenido-audiovisual-U2.git
   ```
2. En Eclipse: **File → Import → Existing Projects into Workspace** y selecciona la carpeta clonada.
3. Verifica que el proyecto use Java 17 o superior.
4. Ejecuta `src/poo/MenuAudiovisual.java` con **Run As → Java Application**.
5. Usa la opción **11** del menú para cargar datos de ejemplo y probar el resto de opciones.

## Mejoras adicionales

- Menú interactivo por consola con validación de entradas (campos vacíos, letras en campos numéricos, valores fuera de rango).
- Confirmación antes de eliminar contenido.
- Polimorfismo: todo el contenido se maneja en una sola lista de `ContenidoAudiovisual`.