package com.eya.livres.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eya.livres.entities.Genre;
public interface GenreRepository extends JpaRepository<Genre, Long>{

}

