package com.whut.dao;

import com.whut.bean.Medicine;

import java.util.List;

public interface IMedicineDao {
    // 获取所有药品
    public    List<Medicine> getAllMedicine();

    // 删除药品
    public void deleteMedicine(String id);

    // 添加药品
   public void addMedicine(Medicine medicine);

   // 药品更新
    public  void updateMedicine(Medicine medicine);

    // 查询药品,根据药品id来查询
   public Medicine getMedicineById(String id);

}
