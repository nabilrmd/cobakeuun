package com.dicoba.cobakeuun.repository;

import com.dicoba.cobakeuun.dto.AllPenjualanPojo;
import com.dicoba.cobakeuun.entity.TbPenjualan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbPenjualanRepository extends JpaRepository<TbPenjualan, Long> {
    @Query(value = "SELECT " +
            "nama_user AS namaUser, " +
            "(SELECT COUNT (*) FROM cobaa.tb_penjualan) AS totalTransaksiPenjualan, " +
            "COUNT (jumlah_barang) AS jumlahKuantitiPenjualan " +
            "FROM cobaa.tb_penjualan " +
            "GROUP BY " +
            "   nama_user " +
            "ORDER BY" +
            "   jumlahKuantitiPenjualan DESC ", nativeQuery = true)
    List<AllPenjualanPojo> getAllPenjualan();
}
