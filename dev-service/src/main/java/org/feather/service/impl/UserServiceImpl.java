package org.feather.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.feather.domain.User;
import org.feather.dto.UserDTO;
import org.feather.listener.ExcelListener;
import org.feather.mapper.UserMapper;
import org.feather.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    public User getCurrentUserByToken(String token) {
        if (StrUtil.isBlank(token)) {
            log.info("accessToken为空");
            return null;
        }
        return null;
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

    @Override
    public void importExcel() {
        // 实现excel写操作
        //1.设置写入文件夹地址和excel文件名称
       // String fileName = "/Users/zzs/temp/excel/write.xlsx";
        //调用easyExcel里面的方法实现写操作
        //2个参数，第一个参数是文件名称，第二个参数是实体类
        EasyExcel.read(location+"用户表.xlsx", User.class, new ExcelListener()).sheet().doRead();
    }

    @Override
    public void importUser(MultipartFile file) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<UserDTO> readList= reader.readAll(UserDTO.class);
        if (!readList.isEmpty()){
            //去除第一行的中文标题
            readList.remove(0);
            List<User> list=new ArrayList<>();
            readList.forEach(item->{
                User user=new User();
                BeanUtils.copyProperties(item,user);
                user.setCreateTime(new Date());
                list.add(user);
            });
            this.saveBatch(list);
        }

    }


}
