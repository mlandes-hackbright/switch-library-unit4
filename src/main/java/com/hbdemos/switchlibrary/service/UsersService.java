package com.hbdemos.switchlibrary.service;

import com.hbdemos.switchlibrary.dto.CreateUserDTO;
import com.hbdemos.switchlibrary.dto.UserDTO;
import com.hbdemos.switchlibrary.entity.UserEntity;
import com.hbdemos.switchlibrary.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private IUsersRepository repository;

    @Autowired
    public UsersService(IUsersRepository repository) {
        this.repository = repository;
    }

    public UserDTO createGame(CreateUserDTO spec) {
        var entity = new UserEntity(null, spec.getName(), spec.getPassword());
        var result = this.repository.saveAndFlush(entity);
        return result.asDto();
    }

    public List<UserDTO> listUsers() {
        var users = this.repository.findAll();
        return users.stream().map(UserEntity::asDto).toList();
    }

    public UserDTO getUser(Long id) {
        var userOpt = this.repository.findById(id);
        return userOpt.orElseThrow().asDto();
    }

    public void removeUser(Long id) {
        this.repository.deleteById(id);
    }
}
