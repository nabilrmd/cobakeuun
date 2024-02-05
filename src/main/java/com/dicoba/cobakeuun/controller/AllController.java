package com.dicoba.cobakeuun.controller;


import com.dicoba.cobakeuun.pojo.InserBarangPojo;
import com.dicoba.cobakeuun.pojo.InserUserPojo;
import com.dicoba.cobakeuun.pojo.InsertPenjualanPojo;
import com.dicoba.cobakeuun.service.AllServices;
import com.dicoba.cobakeuun.utility.MessageModel;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AllController {

    @Autowired
    private AllServices allServices;

    @PostMapping("/insertUser")
    public ResponseEntity<MessageModel> insertUser(InserUserPojo inserUserPojo){
        return allServices.insertUser(inserUserPojo);
    }

    @PostMapping("/inserBarang")
    public ResponseEntity<MessageModel> insertBarang(InserBarangPojo inserBarangPojo){
        return allServices.insertBarang(inserBarangPojo);
    }

    @PostMapping("/insertPenjualan")
    public ResponseEntity<MessageModel> insertPenjualan(InsertPenjualanPojo insertPenjualanPojo){
        return allServices.inserPenjualan(insertPenjualanPojo);
    }

    @GetMapping("/getDataPenjualan")
    public ResponseEntity<MessageModel> getDataPenjualan () {
        return allServices.getDataPenjualan();
    }

}
