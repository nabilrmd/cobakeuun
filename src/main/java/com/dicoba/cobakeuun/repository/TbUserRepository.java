package com.dicoba.cobakeuun.repository;

import com.dicoba.cobakeuun.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TbUserRepository extends JpaRepository<TbUser, Long> {

    @Query(value = "SELECT * FROM cobaa.tb_user WHERE nama_user = :namaUser", nativeQuery = true)
    TbUser getUserCheck(@Param("namaUser") String namaUser);
}
