package org.feather.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.feather.annoation.Log;
import org.feather.common.JsonResponse;
import org.feather.dto.LoginDTO;
import org.feather.dto.UserDTO;
import org.feather.service.IUserService;
import org.feather.support.UserSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

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

    private final IUserService userService;

    private final UserSupport userSupport;


    @Log(description = "添加用户")
    @ApiOperation(value = "添加用户",httpMethod = "POST", produces = "application/json")
    @PostMapping("/addUser")
    public JsonResponse<String> addUser(@RequestBody @Validated UserDTO userDTO) {
        userService.addUser(userDTO);
        return JsonResponse.success();
    }

    @Log(description = "登录")
    @ApiOperation(value = "登录",httpMethod = "POST", produces = "application/json")
    @PostMapping("/login")
    public JsonResponse<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
        Map<String, Object> map = userService.login(loginDTO);
        return new JsonResponse(map);
    }

    @ApiOperation(value = "退出登录",httpMethod = "POST", produces = "application/json")
    @PostMapping("/loginOut")
    public JsonResponse<String> loginOut(HttpServletRequest request) {
        String refreshToken = request.getHeader("refreshToken");
        Long userId = userSupport.getCurrentUserInfo().getId();
        userService.loginOut(refreshToken,userId);
        return JsonResponse.success();
    }

    @ApiOperation(value = "退出登录",httpMethod = "POST", produces = "application/json")
    @PostMapping("/access-token")
    public JsonResponse<String> refreshAccessToken(HttpServletRequest request) throws Exception {
        String refreshToken = request.getHeader("refreshToken");
        return JsonResponse.success(userService.refreshAccessToken(refreshToken));
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
