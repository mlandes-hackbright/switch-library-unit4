package com.hbdemos.switchlibrary;

import com.hbdemos.switchlibrary.dto.CreateSwitchGameDTO;
import com.hbdemos.switchlibrary.dto.CreateUserDTO;
import com.hbdemos.switchlibrary.service.GamesService;
import com.hbdemos.switchlibrary.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AppStartupEventHandler {
    private GamesService gamesService;
    private UsersService userService;

    @Autowired
    public AppStartupEventHandler(GamesService gamesService, UsersService userService) {
        this.gamesService = gamesService;
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void appReadyHandler() {
        // initial data injection
        var games = new ArrayList<CreateSwitchGameDTO>();
        games.add(new CreateSwitchGameDTO("The Legend of Zelda: Breath of the Wild", "E10+", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Super Mario Odyssey", "E10+", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Super Mario Party", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Cars 3: Driven to Win", "E10+", "WB Games"));
        games.add(new CreateSwitchGameDTO("Super Mario Bros. U Deluxe", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Yoshi's Crafted World", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Donkey Kong Country: Tropical Freeze", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Mario & Sonic at the Olympic Games", "E10+", "Sega"));
        games.add(new CreateSwitchGameDTO("Super Smash Bros. Ultimate", "E10+", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Mario + Rabbids: Kingdom Battle", "E10+", "Ubisoft"));
        games.add(new CreateSwitchGameDTO("Hyrule Warriors: Age of Calamity", "T", "Nintendo"));
        games.add(new CreateSwitchGameDTO("The Legend of Zelda: Link's Awakening", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Paper Mario: The Origami King", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Paw Patrol Mighty Pups: Save Adventure Bay", "E", "Outright Games"));
        games.add(new CreateSwitchGameDTO("The Legend of Zelda: Skyward Sword HD", "E10+", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Metroid Dread", "T", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Octopath Traveler", "T", "Square Enix"));
        games.add(new CreateSwitchGameDTO("Kirby and the Forgotten Land", "E10+", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Game Builder Garage", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Sonic Frontiers", "E10+", "Sega"));
        games.add(new CreateSwitchGameDTO("Super Mario 3D World + Bowser's Fury", "E", "Nintendo"));
        games.add(new CreateSwitchGameDTO("Splatoon 3", "E10+", "Nintendo"));

        for (var game : games) {
            this.gamesService.createGame(game);
        }

        this.userService.createUser(new CreateUserDTO("mlandes", "1234"));
        this.userService.createUser(new CreateUserDTO("rlandes", "1234"));
    }
}
