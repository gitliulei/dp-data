package net.astroway.yw.rrsdp.base;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import net.astroway.yw.base.controller.AppException;
import net.astroway.yw.base.util.Is;

/**
 * @author alex
 * @since 2017/01/09
 *
 * 转换数据库unique字段重复异常为对用户更加友好的AppException
 * @see Duplicate
 */

@Aspect
@Component
public class DuplicateAspect {

    @Around("execution(public * *(..)) && @annotation(duplicate)")
    public Object duplicateInvoke(ProceedingJoinPoint jp, net.astroway.yw.rrsdp.base.Duplicate duplicate) throws Throwable {
        try {
            return jp.proceed();
        }catch (DuplicateKeyException duplicateKeyException){
            Throwable e = duplicateKeyException;
            while(!Is.empty(e.getCause())){
                e = e.getCause();
            }
            String[] maps = duplicate.maps();
            for(String map : maps){
                String[] keyValue = map.split(":");
                Is.include(e.getMessage(), "for key '" + keyValue[0] + "'");
//                throw new AppException(keyValue[1] + "已存在", AppException.CodeEnum.已存在.code);
            }
            throw duplicateKeyException;
        }
    }

}
