package org.feather.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import org.feather.domain.User;

import java.util.Map;

/**
 * @projectName: dev-common
 * @package: org.feather.listener
 * @className: ExcelListener
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/7 08:00
 * @version: 1.0
 */
@Slf4j
public class ExcelListener extends AnalysisEventListener<User> {

    /**
     * 一行一行的读取excel内容
     */
    @Override
    public void invoke(User data, AnalysisContext analysisContext) {
        log.info("读取内容****{}",data);
    }

    /**
     * 读取表头内容
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("表头*****{}",headMap);
    }

    /**
     * 读取完成操作
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("读取Excel完毕");
    }
}

