package com.whut.service;


import com.whut.bean.Patient;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

public interface IPatientService
{
    public boolean patientLogin(Patient patient);
    public boolean addPatient(Patient patient);
    public boolean appointment(String p_id, String dp_id);
}
