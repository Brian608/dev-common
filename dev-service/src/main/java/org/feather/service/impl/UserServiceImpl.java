package org.feather.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.feather.domain.User;
import org.feather.dto.UserDTO;
import org.feather.exception.ConditionException;
import org.feather.mapper.UserMapper;
import org.feather.service.IUserService;
import org.feather.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @projectName: dev-common
 * @package: org.feather.service.impl
 * @className: UserServiceImpl
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 12:09
 * @version: 1.0
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements IUserService {

    @Value("${excel.location:}")
    private String location;

    @Override
    public void addUser(UserDTO userDTO) {
        log.info("入参user:{}",userDTO);
        User user= new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setCreateTime(new Date());
        this.save(user);
    }

    @Override
    public List<User> getAll() {
        return  this.getBaseMapper().selectList(null);
    }

    @Override
    public void exportExcel() {
        // 实现excel写操作
        //1.设置写入文件夹地址和excel文件名称
       // String fileName = "/Users/zzs/temp/excel/.xlsx";
        //调用easyExcel里面的方法实现写操作
        //2个参数，第一个参数是文件名称，第二个参数是实体类
        EasyExcel.write(location+"用户表.xlsx", User.class).sheet("用户信息表").doWrite(this.getAll());
    }

}
