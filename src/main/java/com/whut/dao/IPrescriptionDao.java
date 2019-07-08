package com.whut.dao;

import com.whut.bean.Prescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPrescriptionDao 
{
    public List<Prescription> getPrescriptionByCaseId(int c_id);
    public void addPrescription(@Param("c_id")int c_id,@Param("m_id")String m_id);
    public void deletePrescription(@Param("c_id")int c_id,@Param("m_id")String m_id);
}
