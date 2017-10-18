package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.IndexOrder;
import net.astroway.yw.rrsdp.util.DateUtil;
import net.astroway.yw.rrsdp.model.dto.IndexOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @Desc 指标数据service
 * @Author: zx
 * @Date 2017/10/12
 */
@Service
public class IndexOrderService {

    @Autowired
    private Dao<IndexOrder> indexOrderDao;

    /**
     * @Desc 查询订单日趋势图数据列表
     * @param indexOrder
     * @return
     */
    public List<IndexOrder> findTrendList(IndexOrder indexOrder) {
        try {
            String endDate = DateUtil.dateDtFormat.format(new Date());//获取当前日期
            String startDate = DateUtil.getFirstDayOfThisMonth(endDate);//获取本月第一天
            indexOrder.setStartDate(startDate);
            indexOrder.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  indexOrderDao.selectList("findTrendList",indexOrder);
    }

    /**
     * @Desc 查询订单用户好评率、预约及时率、预约完成率、下LES完成率、签收准时率
     * @param indexOrder
     * @return
     */
    public IndexOrderDTO getIndexPercent(IndexOrder indexOrder){
        IndexOrderDTO indexOrderDTO = new IndexOrderDTO();
        try {
            String endDate = DateUtil.dateDtFormat.format(new Date());//获取当前日期
            String startDate = DateUtil.getDateOfLastMonth(endDate);//获取上月的同一天日期
            indexOrder.setStartDate(startDate);
            indexOrder.setEndDate(endDate);
            indexOrderDTO = indexOrderDao.selectOne("getIndexPercent",indexOrder);
            if (("" !=indexOrderDTO.getIndexValueNum() && null != indexOrderDTO.getIndexValueNum()) &&
                    ("" !=indexOrderDTO.getIndexAllNum() && null != indexOrderDTO.getIndexAllNum())){
                int indexAllNumInt = Integer.parseInt(indexOrderDTO.getIndexAllNum());
                DecimalFormat df=new DecimalFormat("0.00");
                int indexValueNumInt = Integer.parseInt(indexOrderDTO.getIndexValueNum());
                String  percent = df.format(((float)indexValueNumInt/indexAllNumInt));
                indexOrderDTO.setPercent(percent);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return indexOrderDTO;
    }

    /**
     * @Desc 查询订单热力分布图（全国）
     * @param indexOrder
     * @return
     */
    public List<IndexOrderDTO> getAllHertMap (IndexOrder indexOrder){
        return indexOrderDao.selectList("getAllHertMap",indexOrder);
    }

    /**
     * @Desc 查询订单热力分布图（大区）
     * @param indexOrder
     * @return
     */
    public List<IndexOrderDTO> getRegionHertMap (IndexOrder indexOrder){
        return indexOrderDao.selectList("getRegionHertMap",indexOrder);
    }

    /**
     * @Desc 查询订单热力分布图（小微）
     * @param indexOrder
     * @return
     */
    public List<IndexOrderDTO> getTradeHertMap (IndexOrder indexOrder){
        return indexOrderDao.selectList("getTradeHertMap",indexOrder);
    }

    /**
     * @Desc 查询当月有效接单数量
     * @param indexOrder
     * @return
     */
    public String getIndexOrders (IndexOrder indexOrder){
        String indexOrders = null;
        try {
            String endDate = DateUtil.dateDtFormat.format(new Date());//获取当前日期
            String startDate = DateUtil.getFirstDayOfThisMonth(endDate);//获取本月的第一天
            indexOrder.setStartDate(startDate);
            indexOrder.setEndDate(endDate);
            indexOrders = indexOrderDao.selectOne("getIndexOrders",indexOrder);
        }catch (Exception e){
            e.printStackTrace();
        }
        return indexOrders;
    }

}
