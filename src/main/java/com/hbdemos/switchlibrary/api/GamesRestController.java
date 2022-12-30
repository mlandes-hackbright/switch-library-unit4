package com.hbdemos.switchlibrary.api;

import com.hbdemos.switchlibrary.dto.CreateSwitchGameDTO;
import com.hbdemos.switchlibrary.dto.SwitchGameDTO;
import com.hbdemos.switchlibrary.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GamesRestController {
    GamesService service;

    @Autowired
    public GamesRestController(GamesService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<SwitchGameDTO>> listGames() {
        var result = this.service.listGames();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SwitchGameDTO> viewGame(@PathVariable Long id) throws ApiBadRequest {
        var result = this.service.getGame(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<SwitchGameDTO> createGame(@RequestBody CreateSwitchGameDTO item) {
        var result = this.service.createGame(item);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SwitchGameDTO> updateGame(@RequestBody SwitchGameDTO item) throws ApiBadRequest {
        var result = this.service.updateGame(item);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeGame(@PathVariable Long id) throws ApiBadRequest {
        this.service.removeGame(id);
        return ResponseEntity.noContent().build();
    }
}
