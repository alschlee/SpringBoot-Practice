package com.alschlee.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer duration; // in seconds

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public void setDurationFromString(String durationStr) {
        String[] parts = durationStr.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        this.duration = minutes * 60 + seconds;
    }
}
