package com.whut.service.imp;

import com.whut.bean.Case;
import com.whut.service.ICaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService implements ICaseService {
    @Override
    public List<Case> getAllCase() {
        return null;
    }

    @Override
    public Case getCaseById(String c_id) {
        return null;
    }

    @Override
    public boolean addCase(Case ncase) {
        return false;
    }

    @Override
    public boolean updateCase(Case ncase) {
        return false;
    }

    @Override
    public boolean deleteCase(String c_id) {
        return false;
    }
}
