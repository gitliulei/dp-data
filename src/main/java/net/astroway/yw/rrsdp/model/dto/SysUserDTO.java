package net.astroway.yw.rrsdp.model.dto;

import lombok.Data;
import net.astroway.yw.rrsdp.model.SysUser;
import net.astroway.yw.rrsdp.util.SessionUtil;

/**
 * Created by syk on 2017/10/11.
 */
@Data
public class SysUserDTO extends SysUser{
    private String token;
    public String getToken(){
        return SessionUtil.getSessionId();
    }
}
