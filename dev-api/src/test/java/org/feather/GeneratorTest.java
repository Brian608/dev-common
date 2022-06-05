package org.feather;

import org.feather.config.CodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: generator
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-10 23:11
 **/
@SpringBootTest(classes = DevCommonApplication.class)
@RunWith(SpringRunner.class)
public class GeneratorTest {

    @Autowired
    CodeGenerator codeGenerator;




    @Test
    public  void generatorTest(){
        codeGenerator.generator("user");
    }

}
