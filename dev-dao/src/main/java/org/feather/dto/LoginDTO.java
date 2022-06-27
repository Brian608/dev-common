package org.feather.dto;

import lombok.Data;

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

    private String phone;

}
