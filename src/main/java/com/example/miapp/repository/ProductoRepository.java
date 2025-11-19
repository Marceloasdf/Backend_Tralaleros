package com.example.miapp.repository;
import com.example.miapp.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    //Metodo para la pagina de categorias
    List<Producto> findByCategory(String category);
}