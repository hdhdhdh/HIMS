package com.whut.service;

import com.whut.bean.Medicine;
import com.whut.bean.Prescription;
import com.whut.bean.UncheckoutPrescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMedicineService {

    public  List<Medicine> getAllMedicine();

    // 获取所有药品
    public List<Medicine> getAllMedicine(int page,int size);

    // 删除药品
    public boolean deleteMedicine(String m_id);

    // 添加药品
    public boolean addMedicine(Medicine medicine);

    // 药品更新
    public boolean updateMedicine(Medicine medicine);

    public boolean checkInventory(List<Prescription> prescriptions);//检查库存

    public boolean checkout(List<Prescription> prescriptions);//出库

    // 查询药品,根据药品id来查询
    Medicine getMedicineById(String m_id);

    public List<Medicine> getMedicineByName(String m_name);


}
