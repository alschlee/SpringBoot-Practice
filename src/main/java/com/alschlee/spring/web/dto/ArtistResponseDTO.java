package com.alschlee.spring.web.dto;

import com.alschlee.spring.domain.Artist;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ArtistResponseDTO {
    private Long id;
    private String name;
    private String bio;
    private List<AlbumResponseDTO> albums;

    public static ArtistResponseDTO from(Artist artist) {
        ArtistResponseDTO dto = new ArtistResponseDTO();
        dto.setId(artist.getId());
        dto.setName(artist.getName());
        dto.setBio(artist.getBio());

        dto.setAlbums(artist.getAlbums().stream()
                .map(album -> AlbumResponseDTO.from(album))
                .collect(Collectors.toList()));
        return dto;
    }
}
