package com.hbdemos.switchlibrary.service;

import com.hbdemos.switchlibrary.api.ApiNotFound;
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

    public UserDTO createUser(CreateUserDTO spec) {
        var entity = new UserEntity(
                null,
                spec.getName(),
                spec.getPassword(),
                List.of());
        var result = this.repository.saveAndFlush(entity);
        return result.asDto();
    }

    public List<UserDTO> listUsers() {
        var users = this.repository.findAll();
        return users.stream().map(UserEntity::asDto).toList();
    }

    public UserDTO getUser(Long id) throws ApiNotFound {
        var userOpt = this.repository.findById(id);
        return userOpt.orElseThrow(() -> new ApiNotFound(id)).asDto();
    }

    public void removeUser(Long id) throws ApiNotFound {
        this.repository.findById(id).orElseThrow(() -> new ApiNotFound(id));
        this.repository.deleteById(id);
    }
}
