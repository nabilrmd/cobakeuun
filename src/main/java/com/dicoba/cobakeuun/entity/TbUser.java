package com.dicoba.cobakeuun.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user", schema = "cobaa")
public class TbUser implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", columnDefinition = "serial", nullable = false)
    private Long idUser;

    @Column(name = "nama_user")
    private String namaUser;



}
