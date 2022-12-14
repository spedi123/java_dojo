package com.spedi123.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.lookify.models.Song;
import com.spedi123.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo;
	
	// ========== Create / Update ==========
	
	public Song create(Song song) {
		return songRepo.save(song);
	}
	
	public Song update(Song song) {
		return songRepo.save(song);
	}
	

	// ========== Read ==========
	
	public List<Song> getAll() {
		return songRepo.findAll();
	}
	
	public Song getOne(Long id) {
		Optional<Song> optSong = songRepo.findById(id);
		if(optSong.isPresent()) {
			return optSong.get();
		} else {
			return null;
		}
	}
	
	// find singer's song
	public List<Song> getSongByArist(String artist) {
		return songRepo.findByArtistContainingOrderByTitle(artist);
	}
	
	// find top 10 songs
	public List<Song> tenSongs() {
		return songRepo.findTenByOrderByRatingDesc();
	}
	

	// ========== Delete ==========
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	
	
}
