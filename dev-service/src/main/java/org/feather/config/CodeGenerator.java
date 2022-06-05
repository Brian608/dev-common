package org.feather.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: mybatis-plus-generator
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-10 21:56
 **/
@Slf4j
@Component
public class CodeGenerator {
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driver;
//
//    @Value("${spring.datasource.password}")
//    private String password;

    public static final String url = "jdbc:mysql://localhost:3306/lottery?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
    public static final String username = "root";
    public static final String password = "root";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String AUTHOR = "feather(杜雪松)";
    public static final String PACKAGE = "org.feather";
    //TODO 更多配置请参考http://mp.baomidou.com/#/generate-code


        public    void generator(String tableName){

            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();

            // 1.全局配置
            GlobalConfig gc = new GlobalConfig();
            gc.setActiveRecord(true);//支持AR模式
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath+"/src/main/java");
            gc.setFileOverride(true);//文件覆盖
            gc.setIdType(IdType.AUTO);//主键自增
            // gc.setServiceName("%sService");//设置接口名称是否有I
            gc.setAuthor(AUTHOR);
            gc.setBaseResultMap(true);//xml映射
            gc.setBaseColumnList(true);//sql片段
            mpg.setGlobalConfig(gc);

            // 2.数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl(url);
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName(driver);
            dsc.setUsername(username);
            dsc.setPassword(password);
            mpg.setDataSource(dsc);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();

            //设置字段和表名的是否把下划线完成驼峰命名规则
            strategy.setNaming(NamingStrategy.underline_to_camel);

            strategy.setColumnNaming(NamingStrategy.underline_to_camel);

            //是否启动lombok
            strategy.setEntityLombokModel(true);

            //是否生成resetController
            strategy.setRestControllerStyle(true);


            //要设置生成哪些表 如果不设置就是生成所有的表
            strategy.setInclude(tableName.split(","));

            strategy.setControllerMappingHyphenStyle(true);

            //strategy.setTablePrefix(pc.getModuleName() + "_");
            // strategy.setTablePrefix("sys_");

            mpg.setStrategy(strategy);


            // 4.包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent(PACKAGE);
            pc.setMapper("mapper");
            pc.setService("service");
            pc.setController("controller");
            pc.setEntity("entity");
            pc.setXml("mapper");
            mpg.setPackageInfo(pc);
            // 5.执行
            mpg.execute();


        }



    }
