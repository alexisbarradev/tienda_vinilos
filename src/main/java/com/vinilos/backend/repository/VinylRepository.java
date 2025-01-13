package com.vinilos.backend.repository;

import com.vinilos.backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinylRepository extends JpaRepository<Vinyl, Long> {
}