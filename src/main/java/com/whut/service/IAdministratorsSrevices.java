package com.whut.service;

import com.whut.bean.Administrators;

import java.util.List;

public interface IAdministratorsSrevices
{
    public List<Administrators> getAllAdministrators();
    public Administrators getAdministratorsById(String pr_id);
    public boolean addAdministrators(Administrators administrators);
    public boolean updateAdministrators(Administrators administrators);
    public boolean deleteAdministrators(String pr_id);
}
