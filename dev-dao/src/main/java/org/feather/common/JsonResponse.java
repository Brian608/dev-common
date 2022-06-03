package org.feather.common;

/**
 * @projectName: dev-common
 * @package: org.feather.common
 * @className: JsonResponse
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 10:31
 * @version: 1.0
 */
public class JsonResponse<T> {
    private String code;

    private String msg;

    private  T Data;

    public JsonResponse(String  code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public JsonResponse(T Data){
        this.Data=Data;
        this.msg="success";
        this.code="200";
    }

    public static JsonResponse<String> success(){
        return  new JsonResponse<>(null);
    }

    public static JsonResponse<String> success(String data){
        return  new JsonResponse<>(data);
    }
    public static JsonResponse<String> fail(){
        return  new JsonResponse<>("500","fail");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
