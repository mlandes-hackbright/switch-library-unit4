package com.hbdemos.switchlibrary.entity;

import com.hbdemos.switchlibrary.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    public UserEntity(UserDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.password = dto.getPassword();
    }

    public UserDTO asDto() {
        return new UserDTO(this.id, this.name, this.password);
    }
}
