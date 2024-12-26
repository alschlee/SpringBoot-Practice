package com.alschlee.spring.web.controller;

import com.alschlee.spring.converter.AlbumConverter;
import com.alschlee.spring.domain.Album;
import com.alschlee.spring.domain.Artist;
import com.alschlee.spring.domain.Track;
import com.alschlee.spring.service.AlbumService;
import com.alschlee.spring.web.dto.AlbumResponseDTO;
import com.alschlee.spring.web.dto.ArtistResponseDTO;
import com.alschlee.spring.web.dto.TrackResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumConverter albumConverter;

    // 가수별 앨범 조회
    @GetMapping("/artists/{artistId}/albums")
    public List<AlbumResponseDTO> getAlbumsByArtist(@PathVariable Long artistId) {
        List<Album> albums = albumService.getAlbumsByArtist(artistId);
        return albums.stream()
                .map(albumConverter::convertToDto)
                .collect(Collectors.toList());
    }

    // 가수 조회
    @GetMapping("/artists/{id}")
    public ArtistResponseDTO getArtist(@PathVariable Long id) {
        Optional<Artist> artist = albumService.getArtistById(id);
        return artist.map(ArtistResponseDTO::from).orElse(null);
    }

    // 앨범별 노래 조회
    @GetMapping("/albums/{albumId}/tracks")
    public List<TrackResponseDTO> getTracksByAlbum(@PathVariable Long albumId) {
        List<Track> tracks = albumService.getTracksByAlbum(albumId);
        return tracks.stream()
                .map(track -> new TrackResponseDTO(track.getId(), track.getTitle(), track.getDuration()))
                .collect(Collectors.toList());
    }

    // 전체 앨범 조회
    @GetMapping("/albums")
    public List<AlbumResponseDTO> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return albums.stream()
                .map(albumConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
