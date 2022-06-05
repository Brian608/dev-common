package org.feather.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.feather.domain.User;

/**
 * @projectName: dev-common
 * @package: org.feather.mapper
 * @className: UserMapper
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/5 18:50
 * @version: 1.0
 */
@Mapper
public interface UserMapper  extends BaseMapper<User>{


}
