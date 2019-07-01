package com.whut.service;


import com.whut.bean.Patient;
import org.springframework.stereotype.Service;

public interface IPatientService
{
    public Patient getPatienById(String p_id);
}
