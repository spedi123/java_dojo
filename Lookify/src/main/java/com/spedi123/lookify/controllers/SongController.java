package com.spedi123.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spedi123.lookify.models.Song;
import com.spedi123.lookify.services.SongService;

@Controller
public class SongController {

	@Autowired
	private SongService songServ;
	
	// ========== Display ==========
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/songs")
	public String dashboard(@ModelAttribute("song")Song song, Model model) {
		List<Song> songList = songServ.getAll();
		model.addAttribute("songList", songList);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String create(@ModelAttribute("song") Song song) {
			return "create.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String detail(@PathVariable("id")Long id, Model model) {
		Song song = songServ.getOne(id);
		model.addAttribute("song", song);
		return "detail.jsp";
	}
	
	@GetMapping("/songs/search/{artist}")
	public String getSongByArsit(@PathVariable("artist")String artist, Model model) {
		List<Song> songs = songServ.getSongByArist(artist);
		if (songs.size()==0) {
			return "redirect:/songs";
		} 
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@GetMapping("/songs/search/topten")
	public String topTen(Model model) {
		List<Song> tenSong = songServ.tenSongs();
		model.addAttribute("tenSong", tenSong);
		return "ten.jsp";
	}

	// ========== Action ==========
	
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("song")Song song, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			songServ.create(song);
			return "redirect:/songs";
		}
	}
	
	@PostMapping("/songs/search")
	public String searchArtist(@RequestParam("artist")String artist, Model model) {
		model.addAttribute("artist", artist);
		return "redirect:/songs/search/"+artist;
	}
	
	@DeleteMapping("/songs/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		songServ.deleteSong(id);
		return "redirect:/songs";
	}
}












