package com.dicoba.cobakeuun.repository;

import com.dicoba.cobakeuun.entity.TbBarang;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TbBarangRepository extends JpaRepository<TbBarang, Long> {

    @Query(value = "SELECT * FROM cobaa.tb_barang WHERE nama_barang = :namaBarang", nativeQuery = true)
    TbBarang getBarangCheck(@Param("namaBarang") String namaBarang);
}
