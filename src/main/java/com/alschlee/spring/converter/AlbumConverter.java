package com.alschlee.spring.converter;

import com.alschlee.spring.domain.Album;
import com.alschlee.spring.web.dto.AlbumResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AlbumConverter {

    public AlbumResponseDTO convertToDto(Album album) {
        return AlbumResponseDTO.from(album);
    }
}
