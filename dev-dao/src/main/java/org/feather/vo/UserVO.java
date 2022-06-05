package org.feather.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author feather(杜雪松)
 * @since 2022-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVO  {



    @ExcelProperty(index = 0, value = "姓名")
    private String name;

    @ExcelProperty(index = 2, value = "手机")
    private String phone;

    @ExcelProperty(index = 3, value = "邮箱")
    private String email;

    /**
     * 1 男 2 女
     */
    @ExcelProperty(index = 1, value = "性别")
    private String  gender;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 4, value = "创建时间")
    private Date createTime;


}
