package com.example.db_dealer.dao;


import com.example.db_dealer.pojo.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Dao {
	List<UserData> selectRecord(@Param("left") String left, @Param("right") String right, @Param("start") int start);
}
