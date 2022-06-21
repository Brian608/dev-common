package org.feather.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.feather.common.JsonResponse;
import org.feather.dto.UserDTO;
import org.feather.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
//构造注入
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/user")
public class UserApi {

        private  final  IUserService userService;


    @ApiOperation(value = "添加用户",httpMethod = "POST", produces = "application/json")
    @PostMapping("/addUser")
    public JsonResponse<String> addUser(@RequestBody @Validated UserDTO userDTO) {
        userService.addUser(userDTO);
        return JsonResponse.success();
    }

    @ApiOperation(value = "导出用户",httpMethod = "POST", produces = "application/json")
    @PostMapping("/exportExcel")
    public  JsonResponse<String> exportExcel(){
            userService.exportExcel();
            return JsonResponse.success("导出成功");
    }

    @ApiOperation(value = "导入用户",httpMethod = "POST", produces = "application/json")
    @PostMapping("/importUser")
    public  JsonResponse<String> importUser(@RequestPart("file") MultipartFile file) throws IOException {
        userService.importUser(file);
        return JsonResponse.success("导入成功");
    }
}
