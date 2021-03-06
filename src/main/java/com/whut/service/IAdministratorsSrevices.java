package com.whut.service;

import com.whut.bean.Administrators;

import java.util.List;

public interface IAdministratorsSrevices
{
    public List<Administrators> getAllAdministrators();//得到所有管理员
    public Administrators getAdministratorsById(String pr_id);
    public boolean addAdministrators(Administrators administrators);
    public boolean updateAdministrators(Administrators administrators);
    public boolean deleteAdministrators(String pr_id);
    public Administrators administratorsCheckLogin(String d_id,String d_password);
}
