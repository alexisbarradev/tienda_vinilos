package com.vinilos.backend.service;

import com.vinilos.backend.model.Vinyl;
import com.vinilos.backend.repository.VinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VinylService {

    @Autowired
    private VinylRepository vinylRepository;

    public List<Vinyl> getAllVinyls() {
        return vinylRepository.findAll();
    }

    public Optional<Vinyl> getVinylById(Long id) {
        return vinylRepository.findById(id);
    }

    public Vinyl saveVinyl(Vinyl vinyl) {
        return vinylRepository.save(vinyl);
    }

    public void deleteVinyl(Long id) {
        vinylRepository.deleteById(id);
    }
}
