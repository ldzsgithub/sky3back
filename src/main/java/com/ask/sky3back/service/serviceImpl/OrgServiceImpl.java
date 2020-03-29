package com.ask.sky3back.service.serviceImpl;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.service.OrgService;
import org.springframework.stereotype.Service;

@Service("orgService")
public class OrgServiceImpl implements OrgService {

    @Override
    public User selectOrgByUserId(String userId) {
        return null;
    }
}
