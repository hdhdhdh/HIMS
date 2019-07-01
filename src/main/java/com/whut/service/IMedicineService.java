package com.whut.service;

import com.whut.bean.Medicine;

import java.util.List;

public interface IMedicineService {
    // 获取所有药品
    public List<Medicine> findAll();

    // 删除药品
    public void deleteMedicine(int id);

    // 添加药品
    public int addMedicine(Medicine medicine);

    // 药品更新
   int updateMedicine(Medicine medicine);

    // 查询药品,根据药品id来查询
    Medicine ququeryById(int id);

}
