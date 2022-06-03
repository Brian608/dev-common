package org.feather.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.feather.common.JsonResponse;
import org.feather.domain.UserDTO;
import org.feather.service.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: dev-common
 * @package: org.feather.api
 * @className: UserApi
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 12:11
 * @version: 1.0
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserApi {

        private  final  IUserService userService;

        public UserApi(IUserService userService){
            this.userService=userService;
        }


    @ApiOperation(value = "添加用户",httpMethod = "POST", produces = "application/json")
    @PostMapping("/addUser")
    public JsonResponse<String> addUser(@RequestBody @Validated UserDTO userDTO) {
        userService.addUser(userDTO);
        return JsonResponse.success();
    }
}
