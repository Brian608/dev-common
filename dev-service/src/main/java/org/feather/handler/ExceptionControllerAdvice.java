//package org.feather.handler;
//
//import org.feather.common.JsonResponse;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @projectName: dev-common
// * @package: org.feather.handler
// * @className: ExceptionControllerAdvice
// * @author: feather(杜雪松)
// * @description: TODO
// * @since: 2022/6/3 12:15
// * @version: 1.0
// */
//@ControllerAdvice
//@ResponseBody
//public class ExceptionControllerAdvice {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public JsonResponse<String> handleMethodArgumentNotValidException(
//            MethodArgumentNotValidException ex) {
//        BindingResult bindingResult = ex.getBindingResult();
//        List<FieldError> errors = bindingResult.getFieldErrors();
//        //初始化错误信息大小
//        Map<String, String> errorMessage = new HashMap<>(errors.size());
//        for (FieldError error : errors
//        ) {
//            errorMessage.put(error.getField(), error.getDefaultMessage());
//        }
//        JsonResponse<String> jsonResponse = new JsonResponse<>();
//        jsonResponse.setMsg(errorMessage.toString());
//        jsonResponse.setCode("500");
//        jsonResponse.setData(null);
//        return jsonResponse;
//    }
//}
