package com.whut.service;


import com.whut.bean.Patient;

public interface IPatientService
{
    public boolean patientLogin(Patient patient);
    public boolean addPatient(Patient patient);
}
