package com.hbdemos.switchlibrary.service;

import com.hbdemos.switchlibrary.api.ApiNotFound;
import com.hbdemos.switchlibrary.dto.CreateSwitchGameDTO;
import com.hbdemos.switchlibrary.dto.SwitchGameDTO;
import com.hbdemos.switchlibrary.entity.SwitchGameEntity;
import com.hbdemos.switchlibrary.repository.IGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {
    private IGamesRepository repository;

    @Autowired
    public GamesService(IGamesRepository repository) {
        this.repository = repository;
    }

    public SwitchGameDTO createGame(CreateSwitchGameDTO spec) {
        var entity = new SwitchGameEntity(
                null,
                spec.getTitle(),
                spec.getRating(),
                spec.getPublisher(),
                List.of());
        var result = this.repository.saveAndFlush(entity);
        return result.asDto();
    }

    public List<SwitchGameDTO> listGames() {
        var games = this.repository.findAll();
        return games.stream().map(SwitchGameEntity::asDto).toList();
    }

    public SwitchGameDTO getGame(Long id) throws ApiNotFound {
        var game = this.repository.findById(id);
        return game.orElseThrow(() -> new ApiNotFound(id)).asDto();
    }

    public SwitchGameDTO updateGame(SwitchGameDTO game) throws ApiNotFound {
        var entityOpt = this.repository.findById(game.getId());
        entityOpt.ifPresent(entity -> {
            entity.setTitle(game.getTitle());
            entity.setRating(game.getRating());
            entity.setPublisher(game.getPublisher());
            this.repository.saveAndFlush(entity);
        });

        return entityOpt.orElseThrow(() -> new ApiNotFound(game.getId())).asDto();
    }

    public void removeGame(Long id) throws ApiNotFound {
        this.repository.findById(id).orElseThrow(() -> new ApiNotFound(id));
        this.repository.deleteById(id);
    }
}
