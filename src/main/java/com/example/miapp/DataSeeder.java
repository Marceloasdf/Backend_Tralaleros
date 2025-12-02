package com.example.miapp;

import com.example.miapp.model.Producto;
import com.example.miapp.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;

// Coso que se ejecuta al iniciar la Api para cargar datos 
@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    public DataSeeder(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo insertamos datos si la tabla está vacía para no duplicar
        if (productoRepository.count() == 0) {
            System.out.println("---- Base de datos vacía. Cargando productos iniciales... ----");

            List<Producto> productos = Arrays.asList(
                new Producto(null, "Figura Sakura Miku", 20000, "Figura oficial de Hatsune Miku.", "Figuras", "/Sakuramiku.png", List.of("/Sakuramiku.png")),
                new Producto(null, "Figura Hornet", 20000, "Figura de Hollow Knight: Silksong.", "Figuras", "/Hornet.jpg", List.of("/Hornet.jpg")),
                new Producto(null, "Nendoroid The Knight", 20000, "Nendoroid oficial de 'The Knight'.", "Figuras", "/NendoroidHollowKnight.png", List.of("/NendoroidHollowKnight.png")),
                new Producto(null, "Pack Library of Ruina", 25000, "Set de llaveros + libro de arte.", "Miscelaneos", "/LoRKeyChain+ArtBook.png", List.of("/LoRKeyChain+ArtBook.png")),
                new Producto(null, "Poster Library of Ruina", 5000, "Póster con Binah, Roland y Gebura.", "Miscelaneos", "/PosterLoR.jpg", List.of("/PosterLoR.jpg")),
                new Producto(null, "Replica Invitacion LoR", 10000, "Réplica de invitación a la biblioteca.", "Miscelaneos", "/InvitacionLoR.jpg", List.of("/InvitacionLoR.jpg")),
                new Producto(null, "Gato Básico", 5000, "Gato Básico de The Battle Cats.", "Peluches", "/BasicCat.png", List.of("/BasicCat.png")),
                new Producto(null, "Gato Hacha", 5000, "Gato Hacha de The Battle Cats.", "Peluches", "/AxeCat.png", List.of("/AxeCat.png")),
                new Producto(null, "Figura DoomSlayer", 20000, "Figura oficial de Doom: Dark Ages.", "Figuras", "/DoomSlayer.png", List.of("/DoomSlayer.png")),
                new Producto(null, "Figura Medic", 15000, "Figura del personaje Medic (TF2).", "Figuras", "/medic.png", List.of("/medic.png")),
                new Producto(null, "Figura Spy", 15000, "Figura del personaje Spy (TF2).", "Figuras", "/spy.png", List.of("/spy.png")),
                new Producto(null, "Figura Matikanetannhauser", 30000, "Figura de Uma Musume.", "Figuras", "/mambo.png", List.of("/mambo.png")),
                new Producto(null, "Figura Kasane Teto", 50000, "Figura de Synthesizer V.", "Figuras", "/gorda.png", List.of("/gorda.png")),
                new Producto(null, "Peluche Gengar", 32000, "Peluche de la saga Pokémon.", "Peluches", "/gengar.png", List.of("/gengar.png")),
                new Producto(null, "Peluche Jimbo", 15000, "Peluche del videojuego Balatro.", "Peluches", "/jimbo.png", List.of("/jimbo.png")),
                new Producto(null, "Peluche Don Quixote", 15000, "Peluche Don Quixote del videojuego Limbus Company.", "Peluches", "/DonQuixote.png", List.of("/DonQuixote.png")),
                new Producto(null, "Peluche Ishmael", 15000, "Peluche Ishmael Del videojuego Limbus Company.", "Peluches", "/Ishmael.png", List.of("/Ishmael.png")),
                new Producto(null, "Peluche Hong Lu", 15000, "Peluche Hong Lu Del videojuego Limbus Company.", "Peluches", "/HongLu.png", List.of("/HongLu.png"))
            );

            productoRepository.saveAll(productos);
            System.out.println("---- ¡Productos cargados exitosamente! ----");
        } else {
            System.out.println("---- La base de datos ya tiene productos. No se requiere carga. ----");
        }
    }
}