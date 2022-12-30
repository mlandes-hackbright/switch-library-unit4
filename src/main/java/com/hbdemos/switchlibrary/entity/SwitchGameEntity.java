package com.hbdemos.switchlibrary.entity;

import com.hbdemos.switchlibrary.dto.SwitchGameDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Games")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SwitchGameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="rating")
    private String rating;

    @Column(name="publisher")
    private String publisher;

    @OneToOne(mappedBy="game")
    private CheckoutEntity checkout;

    public SwitchGameEntity(SwitchGameDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.rating = dto.getRating();
        this.publisher = dto.getPublisher();
    }

    public SwitchGameDTO asDto() {
        return new SwitchGameDTO(this.id, this.title, this.rating, this.publisher);
    }
}
