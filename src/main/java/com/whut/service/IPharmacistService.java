package com.whut.service;

import com.whut.bean.Medicine;

import java.util.List;

public interface IPharmacistService {
    // 获取所有药品
    public List<Medicine> getAllMedicine();

    // 删除药品
    public void deleteMedicine(String m_id);

    // 添加药品
    public void addMedicine(Medicine medicine);

    // 药品更新
    public void updateMedicine(Medicine medicine);

    // 查询药品,根据药品id来查询
    Medicine getMedicineById(String m_id);

}
