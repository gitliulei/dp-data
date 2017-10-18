package net.astroway.yw.rrsdp.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author alex
 * @since 2017/01/09
 *
 * 转化Unique字段已存在异常为XXX已存在AppException，这样可以省掉业务逻辑层校验
 * 例如：maps="userName:用户名"，则如果userName已存在抛出的数据库异常会被自动转化为用户名已存在AppException
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Duplicate {
    String[] maps();
}
