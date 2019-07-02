package com.whut.service;


import com.whut.bean.Department;
import com.whut.bean.Patient;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.List;

public interface IPatientService
{
    public boolean patientLogin(Patient patient);
    public boolean addPatient(Patient patient);


}
