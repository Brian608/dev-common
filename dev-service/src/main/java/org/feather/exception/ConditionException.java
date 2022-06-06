package org.feather.exception;

/**
 * @program: dev-common
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-04-15 22:36
 **/
public class ConditionException extends  RuntimeException{
    private  static  final long serialVersionUID=1L;

    private String code;

    public ConditionException(String code, String name){
        super(name);
        this.code=code;
    }

    public ConditionException(String name){
        super(name);
        code="500";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
