package com.eko.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eko.common.PageParams;
import com.eko.model.Agency;
import com.eko.model.User;

@Mapper
public interface AgencyMapper {

  List<Agency> select(Agency agency);
  
  int insert(Agency agency);
  
  List<User> selectAgent(@Param("user") User user,@Param("pageParams") PageParams pageParams);
  
  Long selectAgentCount(@Param("user") User user);
}
