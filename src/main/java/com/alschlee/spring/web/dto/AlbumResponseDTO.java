package com.alschlee.spring.web.dto;

import com.alschlee.spring.domain.Album;
import lombok.Data;

@Data
public class AlbumResponseDTO {
    private Long id;
    private String title;
    private String genre;
    private String artistName;

    public static AlbumResponseDTO from(Album album) {
        AlbumResponseDTO dto = new AlbumResponseDTO();
        dto.setId(album.getId());
        dto.setTitle(album.getTitle());
        dto.setGenre(album.getGenre().name());
        dto.setArtistName(album.getArtist().getName());
        return dto;
    }
}
