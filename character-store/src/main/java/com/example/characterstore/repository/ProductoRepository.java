package com.example.characterstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.characterstore.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	boolean existsByUniversoAndApiId(String universo, Integer apiId);

    List<Producto> findByUniversoOrderByNombreAsc(String universo);

    List<Producto> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

}
