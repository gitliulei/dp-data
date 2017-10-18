package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;

/**
 * Created by 98794 on 2017/9/29.
 */
@Table("test")
@Data
public class Test {
    private String id;
    private String name;
}
