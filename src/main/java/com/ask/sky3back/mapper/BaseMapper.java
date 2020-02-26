package com.ask.sky3back.mapper;

import com.ask.sky3back.bean.User;
import org.springframework.stereotype.Repository;

@Repository("baseMapper")
public interface BaseMapper {
    User selectUserById (String userId);
}
