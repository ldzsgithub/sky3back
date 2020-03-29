package com.ask.sky3back.service;

import com.ask.sky3back.bean.User;

public interface OrgService {
    User selectOrgByUserId(String userId);
}
