package com.hbdemos.switchlibrary.entity;

import com.hbdemos.switchlibrary.dto.CheckoutDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Checkouts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="game_id")
    private SwitchGameEntity game;

    public CheckoutDTO asDto() {
        return new CheckoutDTO(this.id, this.user.getId(), this.game.getId());
    }
}
