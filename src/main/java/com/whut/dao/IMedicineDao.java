package com.whut.dao;

import com.whut.bean.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMedicineDao {
    // 获取所有药品
    public  List<Medicine> getAllMedicine(int page,int size);

    public  List<Medicine> getAllMedicine();

    // 删除药品
    public void deleteMedicine(String id);
    public  boolean updateMedicine(Medicine medicine);
    // 添加药品
    public boolean addMedicine(Medicine medicine);

   // 药品更新
    public  void updateMedicineNum(@Param("m_id")String m_id,@Param("m_num")int m_num);
    public List<Medicine> getMedicineByName(@Param("m_name")String m_name);
    // 查询药品,根据药品id来查询
   public Medicine getMedicineById(String id);

}
