package com.example.miapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List; 

@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    // Mantenemos el nombre 'desc' para que el Frontend siga funcionando,
    // pero en la base de datos la columna se llamará 'descripcion_producto'
    // para evitar el error de sintaxis
    @Column(name = "descripcion_producto")
    private String desc;
    

    private String category;

    // imagen de la portada
    private String img; 

    // Array de imagenes que se usan en el detalle del producto, aunque siempre se usaba 1 imagen nomas xd  
    @ElementCollection
    @CollectionTable(name = "producto_imagenes", joinColumns = @JoinColumn(name = "producto_id"))
    @Column(name = "imagen_url")
    private List<String> images; 
}