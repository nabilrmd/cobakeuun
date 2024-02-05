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
@Table(name = "tb_penjualan", schema = "cobaa")
public class TbPenjualan implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_penjualan", columnDefinition = "serial", nullable = false)
    private Long idPenjualan;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "nama_user")
    private String namaUser;

    @Column(name = "id_barang")
    private Long idBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "jumlah_barang")
    private Long jumlahBarang;

    @Column(name = "harga_barang")
    private Long hargaBarang;

    @Column(name = "total_harga")
    private Long totalHarga;


}
