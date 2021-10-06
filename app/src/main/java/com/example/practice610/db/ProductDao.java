package com.example.practice610.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    long insertProduct(Product product);



    @Query("Select * from products")
    List<Product> getAllProduct();

}
