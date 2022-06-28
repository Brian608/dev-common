package org.feather.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 27-Jun-22 3:48 PM
 */
@Data
public class LoginDTO {

    private String username;

    private String password;

    private String  kaptcha;

    @NotNull(message = "手机号不能为空")
    @Length(max = 11)
    @Pattern(regexp = "1[3|4|5|7|8][0-9]{9}$",message = "手机号格式错误")
    @ApiModelProperty(name = "phone" , value = "手机号 格式：11位手机号",required = true)
    private String phone;

}
