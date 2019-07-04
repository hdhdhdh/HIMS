package com.whut.service;

import com.whut.bean.Administrators;

import java.util.List;

public interface IAdministratorsSrevices
{
    public List<Administrators> getAllAdministrators();//得到所有预约信息
    public Administrators getAdministratorsById(String pr_id);
    public boolean addAdministrators(Administrators administrators);
    public boolean updateAdministrators(Administrators administrators);
    public boolean deleteAdministrators(String pr_id);
}
