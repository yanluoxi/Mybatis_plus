package com.dxc.mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dxc.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yanji
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-05-25 15:44:21
* @Entity com.dxc.mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
	int insertSelective(User user);

	int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

	int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

	List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

	List<User> selectAllOrderByAgeDesc();
}




