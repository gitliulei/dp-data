package net.astroway.yw.rrsdp.model;

import lombok.Data;
import net.astroway.yw.base.dao.Table;
import oracle.sql.DATE;

/**
 * @Author: liguohua
 * @Date 2017/10/10 0010
 */
@Table("RRS_PAGE_MODULAR")
@Data
public class Template {

    private String id;

    private String page_id;

    private String modular_id;

    private String position;

    private String create_by;

    private DATE create_date;

    private String update_by;

    private DATE update_date;

    private String remarks;

    private int status;



}
