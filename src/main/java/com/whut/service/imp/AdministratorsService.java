package com.whut.service.imp;

import com.whut.bean.Administrators;
import com.whut.dao.IAdministratorsDao;
import com.whut.service.IAdministratorsSrevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorsService implements IAdministratorsSrevices
{
    @Autowired
    IAdministratorsDao iAdministratorsDao;
    @Override
    public List<Administrators> getAllAdministrators() {
        return null;
    }

    @Override
    public Administrators getAdministratorsById(String pr_id) {
        return null;
    }

    @Override
    public boolean addAdministrators(Administrators administrators) {
        return false;
    }

    @Override
    public boolean updateAdministrators(Administrators administrators) {
        return false;
    }

    @Override
    public boolean deleteAdministrators(String pr_id) {
        return false;
    }

    @Override
    public Administrators administratorsCheckLogin(String ad_id, String ad_password)//放回对象的管理员登录
    {
        Administrators administrators1 = iAdministratorsDao.getAdministratorsById(ad_id);
        if(administrators1 == null || administrators1.getAd_password().equals(ad_password) == false)
            return null;
        return administrators1;
    }
}
