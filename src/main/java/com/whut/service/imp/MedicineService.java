package com.whut.service.imp;


import com.github.pagehelper.PageHelper;
import com.whut.bean.Department;
import com.whut.bean.Medicine;
import com.whut.bean.Prescription;
import com.whut.dao.IMedicineDao;
import com.whut.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements IMedicineService {
   @Autowired
    public IMedicineDao iMedicineDao;

    public  List<Medicine> getAllMedicine(){return iMedicineDao.getAllMedicine();}

    // 获取所有药品
    @Override
    public List<Medicine> getAllMedicine(int page, int size){
        PageHelper.startPage(page,size);
        return iMedicineDao.getAllMedicine(page,size);
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
//            iMedicineDao.updateMedicine(medicine);
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

    @Override
    public List<Medicine> getMedicineByName(String m_name)
    {
        return  iMedicineDao.getMedicineByName(m_name);
    }
    public boolean checkInventory(List<Prescription> prescriptions)//检查库存
    {
        for (Prescription p:prescriptions)
        {
            Medicine medicine = getMedicineById(p.getM_id());
            if(medicine == null || medicine.getM_num() <= 0)
                return false;
        }
        return true;
    }
    public boolean checkout(List<Prescription> prescriptions)//出库
    {
        try {
            if(checkInventory(prescriptions) == true )
            {
                System.out.println("checkout");
                for (Prescription p:prescriptions)
                {
                    Medicine medicine = getMedicineById(p.getM_id());
                    iMedicineDao.updateMedicineNum(medicine.getM_id(),medicine.getM_num()-1);
                }
            }else
            {
                return false;
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }


    }

}
