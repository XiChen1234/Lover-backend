package com.example.loverbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loverbackend.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
