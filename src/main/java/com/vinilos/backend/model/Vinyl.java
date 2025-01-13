package com.vinilos.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "VINYLS")
public class Vinyl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VINYL_ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ARTIST", nullable = false)
    private String artist;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COVER_IMAGE_URL")
    private String coverImageUrl;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
}
