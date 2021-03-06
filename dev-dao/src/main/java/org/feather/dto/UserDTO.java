package org.feather.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.feather.annoation.EnumValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @projectName: dev-common
 * @package: org.feather.domain
 * @className: UserDTO
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 12:01
 * @version: 1.0
 */
@Data
public class UserDTO {

    @Length(max = 50,message = "姓名最长50")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "用户名只能包含数字和字母，并且不能超过50个字符")
    @NotNull(message = "用户名不能为空")
    @ApiModelProperty(name = "username" , value = "用户名",required = true)
    private String username;

    @ApiModelProperty(name = "realName" , value = "真实姓名")
    private String realName;


    @NotNull(message = "密码不能为空")
   // @Pattern(regexp = "^^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\\\W_]+$)(?![a-z0-9]+$)(?![a-z\\\\W_]+$)(?![0-9\\\\W_]+$)[a-zA-Z0-9\\\\W_]{8,}$",message = "密码格式错误，密码必须是包含大写字母、小写字母、数字、特殊符号组合")
    @ApiModelProperty(name = "password" , value = "密码",required = true)
    private String password;


    @NotNull(message = "手机号不能为空")
    @Length(max = 11)
    @Pattern(regexp = "1[3|4|5|7|8][0-9]{9}$",message = "手机号格式错误")
    @ApiModelProperty(name = "phone" , value = "手机号 格式：11位手机号",required = true)
    private String phone;



    @NotNull(message = "邮箱不能为空")
    @Length(max = 50)
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",message = "邮箱格式错误")
    @ApiModelProperty(name = "email" , value = "邮箱",required = true)
    private String email;


    @EnumValue(intValues = {1,2}, message = "性别只能为1或2")
    @ApiModelProperty(name = "gender" , value = "性别 1 男    2 女",required = true)
    @NotNull(message = "性别")
    private Integer gender;


    @ApiModelProperty(name = "areaCode" , value = "区域code",required = true)
    @NotNull(message = "区域不能为空")
    private String areaCode;
}
