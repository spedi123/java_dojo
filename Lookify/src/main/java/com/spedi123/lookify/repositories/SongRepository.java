package com.spedi123.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByArtistContainingOrderByTitle(String artist);
	List<Song> findTenByOrderByRatingDesc();
}
