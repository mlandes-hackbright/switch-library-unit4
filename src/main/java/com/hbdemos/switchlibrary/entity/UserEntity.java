package com.hbdemos.switchlibrary.entity;

import com.hbdemos.switchlibrary.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy="user")
    private List<CheckoutEntity> checkouts;

    public UserEntity(UserDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.password = dto.getPassword();
    }

    public UserDTO asDto() {
        return new UserDTO(this.id, this.name, this.password);
    }
}
