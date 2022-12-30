package com.hbdemos.switchlibrary.service;

import com.hbdemos.switchlibrary.api.ApiBadRequest;
import com.hbdemos.switchlibrary.api.ApiNotFound;
import com.hbdemos.switchlibrary.dto.CheckoutDTO;
import com.hbdemos.switchlibrary.dto.CheckoutSpecDTO;
import com.hbdemos.switchlibrary.entity.CheckoutEntity;
import com.hbdemos.switchlibrary.repository.ICheckoutsRepository;
import com.hbdemos.switchlibrary.repository.IGamesRepository;
import com.hbdemos.switchlibrary.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    private ICheckoutsRepository repository;
    private IUsersRepository userRepository;
    private IGamesRepository gameRepository;

    @Autowired
    public CheckoutService(ICheckoutsRepository repository, IUsersRepository userRepository, IGamesRepository gameRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public CheckoutDTO checkoutGame(CheckoutSpecDTO spec) throws ApiBadRequest {
        var user = this.userRepository.findById(spec.getUserId())
                .orElseThrow(() -> new ApiBadRequest("user with id " + spec.getUserId() + " not found"));
        var game = this.gameRepository.findById(spec.getGameId())
                .orElseThrow(() -> new ApiBadRequest("game with id " + spec.getGameId() + " not found"));

        var entity = new CheckoutEntity(null, user, game);
        var result = this.repository.saveAndFlush(entity);
        return result.asDto();
    }

    public void returnGame(Long id) throws ApiNotFound {
        this.repository.findById(id).orElseThrow(() -> new ApiNotFound(id));
        this.repository.deleteById(id);
    }
}
