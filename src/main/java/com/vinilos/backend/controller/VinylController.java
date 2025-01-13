package com.vinilos.backend.controller;

import com.vinilos.backend.model.Vinyl;
import com.vinilos.backend.service.VinylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vinyls")
public class VinylController {

    @Autowired
    private VinylService vinylService;

    @GetMapping
    public List<Vinyl> getAllVinyls() {
        return vinylService.getAllVinyls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vinyl> getVinylById(@PathVariable Long id) {
        return vinylService.getVinylById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vinyl createVinyl(@RequestBody Vinyl vinyl) {
        return vinylService.saveVinyl(vinyl);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vinyl> updateVinyl(@PathVariable Long id, @RequestBody Vinyl vinylDetails) {
        return vinylService.getVinylById(id)
                .map(existingVinyl -> {
                    existingVinyl.setTitle(vinylDetails.getTitle());
                    existingVinyl.setArtist(vinylDetails.getArtist());
                    existingVinyl.setGenre(vinylDetails.getGenre());
                    existingVinyl.setReleaseDate(vinylDetails.getReleaseDate());
                    existingVinyl.setPrice(vinylDetails.getPrice());
                    existingVinyl.setStock(vinylDetails.getStock());
                    existingVinyl.setDescription(vinylDetails.getDescription());
                    existingVinyl.setCoverImageUrl(vinylDetails.getCoverImageUrl());
                    return ResponseEntity.ok(vinylService.saveVinyl(existingVinyl));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVinyl(@PathVariable Long id) {
        if (vinylService.getVinylById(id).isPresent()) {
            vinylService.deleteVinyl(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
