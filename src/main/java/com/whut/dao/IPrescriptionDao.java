package com.whut.dao;

import com.whut.bean.Prescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPrescriptionDao 
{
    public List<Prescription> getPrescriptionByCaseId(int c_id);
    public void addPrescription(Prescription prescription);
    public void deletePrescription( Prescription prescription);
}
