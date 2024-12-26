package com.alschlee.spring.web.dto;

import com.alschlee.spring.domain.enums.Genre;
import lombok.Data;

@Data
public class AlbumRequestDTO {
    private String title;
    private Genre genre;
    private Long artistId;
}
