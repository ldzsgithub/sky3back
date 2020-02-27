package com.ask.sky3back.service.serviceImpl;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.mapper.BaseMapper;
import com.ask.sky3back.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseMapper baseMapper;

    @Override
    public User selectUserById(String id) {
        return baseMapper.selectUserById(id);
    }
}
