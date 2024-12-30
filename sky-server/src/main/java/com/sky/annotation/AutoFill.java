package com.sky.annotation;

/**
 * ClassName: AutoFill
 * Package: com.sky.annotation
 * Description: This is a program for testing.
 *
 * @Author Ben
 * @Create 2024/12/30 15:54
 * @Version 1.0
 */

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标识某个方法需要进行功能字段自动填充处理
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    //数据库操作类型：UPDATE INSERT
    OperationType value();
}
