package org.feather.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @projectName: dev-common
 * @package: org.feather.utils
 * @className: CommonUtils
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/7/13 22:07
 * @version: 1.0
 */
public class CommonUtils {
    /**
     * list<实体>中根据key移除重复
     * @param keyExtractor
     * @param <T>
     * @return
     */

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        return t -> concurrentHashMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
