package com.zte.logaop;

import java.lang.annotation.*;

/**
 * @author shenyi
 * @data 2022/10/8
 * @apiNote
 */
@Target({ElementType.METHOD}) //用于描述方法
@Retention(RetentionPolicy.RUNTIME) //注解不仅被保存到class文件中,jvm加载class文件之后，仍然存在
@Documented //javadoc 文档是否显示
public @interface Log {

    //模块
    String value() default "";
    //功能
    String action() default "";

}


