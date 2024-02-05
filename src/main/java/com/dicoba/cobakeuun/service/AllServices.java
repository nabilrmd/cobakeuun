package com.dicoba.cobakeuun.service;


import com.dicoba.cobakeuun.dto.AllPenjualanPojo;
import com.dicoba.cobakeuun.entity.TbBarang;
import com.dicoba.cobakeuun.entity.TbPenjualan;
import com.dicoba.cobakeuun.entity.TbUser;
import com.dicoba.cobakeuun.pojo.InserBarangPojo;
import com.dicoba.cobakeuun.pojo.InserUserPojo;
import com.dicoba.cobakeuun.pojo.InsertPenjualanPojo;
import com.dicoba.cobakeuun.repository.TbBarangRepository;
import com.dicoba.cobakeuun.repository.TbPenjualanRepository;
import com.dicoba.cobakeuun.repository.TbUserRepository;
import com.dicoba.cobakeuun.utility.MessageModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllServices {

    @Autowired
    TbBarangRepository tbBarangRepository;

    @Autowired
    TbPenjualanRepository tbPenjualanRepository;

    @Autowired
    TbUserRepository tbUserRepository;

    @Transactional
    public ResponseEntity<MessageModel> insertUser(InserUserPojo inserUserPojo) {
        MessageModel msg = new MessageModel();
        try {
            TbUser newUser = new TbUser();

            newUser.setNamaUser(inserUserPojo.getNamaUser());
            TbUser newestUser = tbUserRepository.save(newUser);

            if (newestUser.getIdUser() != null) {
                msg.setMessage("User berhasil ditambahkan");
                msg.setStatus(true);
                msg.setData(newestUser);
            } else {
                msg.setMessage("User gagal ditambahkan");
                msg.setStatus(false);
            }
            return ResponseEntity.ok(msg);

        } catch (Exception e) {
            msg.setMessage(e.getMessage());
            msg.setStatus(false);
            return ResponseEntity.badRequest().body(msg);
        }
    }

    @Transactional
    public ResponseEntity<MessageModel> insertBarang(InserBarangPojo inserBarangPojo) {
        MessageModel msg = new MessageModel();
        try {
            TbBarang newBarang = new TbBarang();

            newBarang.setNamaBarang(inserBarangPojo.getNamaBarang());
            newBarang.setStokBarang(inserBarangPojo.getStokBarang());
            newBarang.setHargaBarang(inserBarangPojo.getHargaBarang());
            TbBarang newestBarang = tbBarangRepository.save(newBarang);

            if (newestBarang.getIdBarang() != null) {
                msg.setMessage("User berhasil ditambahkan");
                msg.setStatus(true);
                msg.setData(newestBarang);
            } else {
                msg.setMessage("User gagal ditambahkan");
                msg.setStatus(false);
            }
            return ResponseEntity.ok(msg);

        } catch (Exception e) {
            msg.setMessage(e.getMessage());
            msg.setStatus(false);
            return ResponseEntity.badRequest().body(msg);
        }
    }

    @Transactional
    public ResponseEntity<MessageModel> inserPenjualan(InsertPenjualanPojo insertPenjualanPojo) {
        MessageModel msg = new MessageModel();
        try {
            TbUser userCheck = tbUserRepository.getUserCheck(insertPenjualanPojo.getNamaUser());
            TbBarang barangCheck = tbBarangRepository.getBarangCheck(insertPenjualanPojo.getNamaBarang());

            if (userCheck == null) {
                msg.setMessage("User tidak ditemukan");
                msg.setStatus(false);
                return ResponseEntity.badRequest().body(msg);
            } else if (barangCheck != null) {
                if (barangCheck.getStokBarang() < insertPenjualanPojo.getJumlahBarang()) {
                    msg.setMessage("Stok Tidak Cukup");
                    msg.setStatus(false);
                    return ResponseEntity.badRequest().body(msg);
                } else {
                    TbPenjualan newPenjualan = new TbPenjualan();
                    newPenjualan.setIdUser(userCheck.getIdUser());
                    newPenjualan.setNamaUser(userCheck.getNamaUser());
                    newPenjualan.setIdBarang(barangCheck.getIdBarang());
                    newPenjualan.setNamaBarang(barangCheck.getNamaBarang());
                    newPenjualan.setJumlahBarang(insertPenjualanPojo.getJumlahBarang());
                    newPenjualan.setHargaBarang(barangCheck.getHargaBarang());
                    newPenjualan.setTotalHarga(barangCheck.getHargaBarang() * insertPenjualanPojo.getJumlahBarang());

                    TbPenjualan finalTransaksi = tbPenjualanRepository.save(newPenjualan);

                    TbBarang stokLama = tbBarangRepository.getById(barangCheck.getIdBarang());
                    stokLama.setStokBarang(stokLama.getStokBarang() - insertPenjualanPojo.getJumlahBarang());
                    TbBarang updateStok = tbBarangRepository.save(stokLama);
                    if (finalTransaksi.getIdPenjualan() != null) {
                        msg.setMessage("Transaksi berhasil");
                        msg.setStatus(true);
                        msg.setData(finalTransaksi);
                    } else {
                        msg.setMessage("Transaksi gagal");
                        msg.setStatus(false);
                    }
                }
            } else {
                msg.setMessage("Barang tidak ditemukan");
                msg.setStatus(false);
            }

            return ResponseEntity.ok(msg);

        } catch (Exception e) {
            msg.setMessage(e.getMessage());
            msg.setStatus(false);
            return ResponseEntity.badRequest().body(msg);
        }
    }

    public ResponseEntity<MessageModel> getDataPenjualan() {
        MessageModel msg = new MessageModel();
        try {
            List<AllPenjualanPojo> dataPenjualan = tbPenjualanRepository.getAllPenjualan();
            if (dataPenjualan.isEmpty()) {
                msg.setMessage("Tidak ada penjualan");
                msg.setStatus(true);
                msg.setData(null);
                return ResponseEntity.ok(msg);
            } else {
                msg.setMessage("Data Penjualan");
                msg.setStatus(true);
                msg.setData(dataPenjualan);
                return ResponseEntity.ok(msg);
            }
        } catch (Exception e) {
            msg.setMessage(e.getMessage());
            msg.setStatus(false);
            return ResponseEntity.badRequest().body(msg);
        }
    }

}
