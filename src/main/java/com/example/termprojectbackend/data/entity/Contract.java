package com.example.termprojectbackend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nft_name")
    private String nftName;

    @Column(name = "nft_uri")
    private String nftUri;

    @Column(name = "is_mintable")
    private Boolean isMintable;

    @Column(name = "is_burnable")
    private Boolean isBurnable;

    @Column(name = "is_ownable")
    private Boolean isOwnable;


}
