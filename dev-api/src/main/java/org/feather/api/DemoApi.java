package org.feather.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.feather.annoation.Log;
import org.feather.common.JsonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: dev-common
 * @package: org.feather.api
 * @className: DemoApi
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 10:34
 * @version: 1.0
 */
@Api(tags = "测试demo")
@RestController
@RequestMapping("/demo")
public class DemoApi {


    @Log(description = "测试日志")
    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperation(value = "分页查询所有数据",httpMethod = "GET", notes = "分页查询所有数据", produces = "application/json")
    @GetMapping("/test")
    public JsonResponse<String> test(@RequestParam(name = "name")String name) {
        return  JsonResponse.success("hello"+name);
    }


}
