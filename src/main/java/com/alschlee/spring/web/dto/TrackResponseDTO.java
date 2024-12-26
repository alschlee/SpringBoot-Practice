package com.alschlee.spring.web.dto;

import com.alschlee.spring.domain.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackResponseDTO {
    private Long id;
    private String title;
    private Integer duration;

    public static TrackResponseDTO from(Track track) {
        TrackResponseDTO dto = new TrackResponseDTO();
        dto.setId(track.getId());
        dto.setTitle(track.getTitle());
        dto.setDuration(track.getDuration());
        return dto;
    }
}
