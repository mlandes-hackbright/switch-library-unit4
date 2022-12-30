package com.hbdemos.switchlibrary.api;

import com.hbdemos.switchlibrary.dto.CreateUserDTO;
import com.hbdemos.switchlibrary.dto.UserDTO;
import com.hbdemos.switchlibrary.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersRestController {
    UsersService service;

    @Autowired
    public UsersRestController(UsersService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> listUsers() {
        var result = this.service.listUsers();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> viewUser(@PathVariable Long id) {
        var result = this.service.getUser(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO item) {
        var result = this.service.createUser(item);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(@PathVariable Long id) {
        this.service.removeUser(id);
        return ResponseEntity.noContent().build();
    }
}
