package com.whut.service.imp;


import com.whut.bean.Medicine;
import com.whut.dao.IMedicineDao;
import com.whut.service.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService implements IPharmacistService {
   @Autowired
    public IMedicineDao medecineDao;

    // 获取所有药品
    @Override
    public  List<Medicine> getAllMedicine(){return medecineDao.getAllMedicine();}

    // 删除药品
    @Override
    public void deleteMedicine(String m_id){medecineDao.deleteMedicine(m_id);}

    // 添加药品
    @Override
    public void addMedicine(Medicine medicine){medecineDao.addMedicine(medicine);}

    // 药品更新
    @Override
    public  void updateMedicine(Medicine medicine){ medecineDao.updateMedicine(medicine);}

    // 查询药品,根据药品id来查询
    @Override
    public Medicine getMedicineById(String m_id){return medecineDao.getMedicineById(m_id);}

}
