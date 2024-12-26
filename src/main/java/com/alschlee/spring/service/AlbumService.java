package com.alschlee.spring.service;

import com.alschlee.spring.domain.Album;
import com.alschlee.spring.domain.Artist;
import com.alschlee.spring.domain.Track;
import com.alschlee.spring.repository.AlbumRepository;
import com.alschlee.spring.repository.ArtistRepository;
import com.alschlee.spring.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TrackRepository trackRepository;

    // 가수별 앨범 조회
    public List<Album> getAlbumsByArtist(Long artistId) {
        return albumRepository.findByArtistId(artistId);
    }

    // 가수 조회
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    // 앨범별 노래 조회
    public List<Track> getTracksByAlbum(Long albumId) {
        return trackRepository.findByAlbumId(albumId);
    }

    // 전체 앨범 조회
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }
}