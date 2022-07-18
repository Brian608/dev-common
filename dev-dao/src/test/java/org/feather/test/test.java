package org.feather.test;

import java.util.regex.Pattern;

/**
 * @projectName: dev-common
 * @package: org.feather.test
 * @className: test
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 13:31
 * @version: 1.0
 */
public class test {
    public static void main(String[] args) {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        System.out.println(Pattern.matches(check,"1123@qq.com"));

    }
}
