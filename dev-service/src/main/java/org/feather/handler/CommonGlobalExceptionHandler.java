package org.feather.handler;

import org.feather.common.JsonResponse;
import org.feather.exception.ConditionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dev-common
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-04-15 22:32
 **/
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResponse<String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        //初始化错误信息大小
        Map<String, String> errorMessage = new HashMap<>(errors.size());
        for (FieldError error : errors
        ) {
            errorMessage.put(error.getField(), error.getDefaultMessage());
        }
        JsonResponse<String> jsonResponse = new JsonResponse<>();
        jsonResponse.setMsg(errorMessage.toString());
        jsonResponse.setCode("500");
        jsonResponse.setData(null);
        return jsonResponse;
    }

    @ExceptionHandler(value = ConditionException.class)
    @ResponseBody
    public JsonResponse<String> commonExceptionHandler(HttpServletRequest request, Exception e){
        String errorMsg = e.getMessage();
        //if(e instanceof ConditionException){
            String errorCode = ((ConditionException)e).getCode();
            return new JsonResponse<>(errorCode, errorMsg);
        //}
//        else{
//            return new JsonResponse<>("500",errorMsg);
//        }
       // return JsonResponse.fail();
    }

}
