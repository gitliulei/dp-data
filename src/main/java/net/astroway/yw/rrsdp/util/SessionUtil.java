package net.astroway.yw.rrsdp.util;

import com.alibaba.fastjson.JSON;
import net.astroway.yw.base.util.Is;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by syk on 2017/10/11.
 */
public class SessionUtil {
    public SessionUtil() {
    }

    public static SessionSysUser getUser() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String userJson = (String)attr.getRequest().getSession().getAttribute("SESSION_USER");
        return (SessionSysUser) JSON.parseObject(userJson, SessionSysUser.class);
    }

    public static void setUser(String userJson) {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession().setAttribute("SESSION_USER", userJson);
    }

    public static void removeUser() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession().removeAttribute("SESSION_USER");
    }

    public static String getSessionId() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attr.getSessionId();
    }

    public static boolean checkUserHasPrivilege(String privilegeUrl) {
        if(Is.empty(getUser().getPrivileges())) {
            return false;
        } else {
            List<String> privilegeUrls = (List)getUser().getPrivileges().stream().map((privilege) -> {
                return privilege.getUrl();
            }).collect(Collectors.toList());
            return privilegeUrls.contains(privilegeUrl);
        }
    }
}
