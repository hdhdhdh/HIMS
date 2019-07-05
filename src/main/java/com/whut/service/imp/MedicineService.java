package com.whut.service.imp;


import com.whut.bean.Medicine;
import com.whut.dao.IMedicineDao;
import com.whut.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements IMedicineService {
   @Autowired
    public IMedicineDao iMedicineDao;

    // 获取所有药品
    @Override
    public  List<Medicine> getAllMedicine()
    {
        return iMedicineDao.getAllMedicine();
    }

    // 删除药品
    @Override
    public boolean deleteMedicine(String m_id)
    {
        try
        {
            iMedicineDao.deleteMedicine(m_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // 添加药品
    @Override
    public boolean addMedicine(Medicine medicine)
    {

        try
        {
            iMedicineDao.addMedicine(medicine);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // 药品更新
    @Override
    public  boolean updateMedicine(Medicine medicine)
    {
        try
        {
            iMedicineDao.updateMedicine(medicine);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // 查询药品,根据药品id来查询
    @Override
    public Medicine getMedicineById(String m_id){return iMedicineDao.getMedicineById(m_id);}

}
