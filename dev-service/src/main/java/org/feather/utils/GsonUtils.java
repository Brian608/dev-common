package org.feather.utils;

import com.google.gson.Gson;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 27-Jun-22 3:20 PM
 */
public class GsonUtils {
  private static  final   Gson gson=new Gson();


    public String ObjToStr(Object src){
        return gson.toJson(src);
    }

    public static <T> T strToObj(String str, Class<T> cls) {
        return gson.fromJson(str,cls);
    }

}
