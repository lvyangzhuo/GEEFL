package com.jeefl.sys.user.mapper;


import com.jeefl.sys.user.domain.UserEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * Created by lyz on 2017-8-26.
 */
@Repository
public interface UserMapper extends Mapper<UserEntity>{

}
