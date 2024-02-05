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
@Table(name = "tb_barang", schema = "cobaa")
public class TbBarang implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang", columnDefinition = "serial", nullable = false)
    private Long idBarang;

    @Column(name = "namaBarang")
    private String namaBarang;

    @Column(name = "stok_barang")
    private Long stokBarang;

    @Column(name = "harga_barang")
    private Long hargaBarang;

}
