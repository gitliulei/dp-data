package net.astroway.yw.rrsdp.service;

import net.astroway.yw.base.dao.Dao;
import net.astroway.yw.rrsdp.model.IndexOrder;
import net.astroway.yw.rrsdp.model.dto.IndexOrderDTO;
import net.astroway.yw.rrsdp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * RRS_INDEX_ORDER指标数据表接口
 * @author:zx
 * @create:2017 - 10 -12
 */
@Service
public class IndexTwoLevelOrderService {
    @Autowired
    private Dao<IndexOrder> indexOrderDao;

    /**
     * 查询有效接单数量折线图
     * @param indexOrder
     * @return
     */
    public List<IndexOrderDTO> getValidOrderList(IndexOrder indexOrder) {
        String startDate = DateUtil.dateDtFormat.format(new Date());//获取当前日期
        indexOrder.setStartDate(startDate);
        return  indexOrderDao.selectList("getValidOrderList",indexOrder);
    }

    /**
     * 查询有效订单数
     * @param indexOrder
     * @return
     */
    public IndexOrderDTO getValidOrderNum(IndexOrder indexOrder) {
        String dateDt = DateUtil.dateDtFormat.format(new Date());//获取当前日期
        indexOrder.setDateDt(dateDt);
        IndexOrderDTO indexOrderDTO =  indexOrderDao.selectOne("getValidOrderNum",indexOrder);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String hourBeforfOne = df.format(calendar.getTime());//当前时间前一小时
        indexOrder.setDateTime(hourBeforfOne);
        IndexOrderDTO indexOrderDTO1 = indexOrderDao.selectOne("getValidOrderNumByHour",indexOrder);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        String hourBeforfTwo = df.format(calendar.getTime());//当前时间前两小时
        indexOrder.setDateTime(hourBeforfTwo);
        IndexOrderDTO indexOrderDTO2 = indexOrderDao.selectOne("getValidOrderNumByHour",indexOrder);
        if (null != indexOrderDTO1 && null != indexOrderDTO2){
            int orderNum = indexOrderDTO1.getOrderNum();//前一小时订单数
            int orderNumTwo = indexOrderDTO2.getOrderNum();//前两个小时订单数
            int orderDiffer = orderNum - orderNumTwo;//前一小时订单数与前两个小时订单数差值
            indexOrderDTO.setOrderNum(orderNum);
            indexOrderDTO.setOrderDiffer(orderDiffer);
        }
        return indexOrderDTO;
    }


    /**
     * 查询2017年累计地区排名柱状图（大区）
     * @param indexOrder
     * @return
     */
    public List<IndexOrder> findOrderRankingRegionIdList(IndexOrder indexOrder) {
        return  indexOrderDao.selectList("findOrderRankingRegionIdList",indexOrder);
    }

    /**
     * 查询2017年累计地区排名柱状图（小微）
     * @param indexOrder
     * @return
     */
    public List<IndexOrder> findOrderRankingTradeIdList(IndexOrder indexOrder) {
        return  indexOrderDao.selectList("findOrderRankingTradeIdList",indexOrder);
    }

    /**
     * 查询2017年累计地区排名柱状图（中心）
     * @param indexOrder
     * @return
     */
    public List<IndexOrder> findOrderRankingCenterIdList(IndexOrder indexOrder) {
        return  indexOrderDao.selectList("findOrderRankingCenterIdList",indexOrder);
    }

    /**
     * 查询订单预约及时率
     * @param indexOrder
     * @return
     */
    public IndexOrder getOrderPercent(IndexOrder indexOrder){
        try {
            String dateDt=DateUtil.dateDtFormat.format(new Date());
            indexOrder.setDateDt(dateDt);
            indexOrder = indexOrderDao.selectOne("getTwoLevelIndexPercent",indexOrder);
            if (""!=indexOrder.getIndexValue() && null!=indexOrder.getIndexValue() &&
                    ""!=indexOrder.getIndexAll() && null!=indexOrder.getIndexAll()){
                int indexValue=Integer.parseInt(indexOrder.getIndexValue());
                int indexAll=Integer.parseInt(indexOrder.getIndexAll());
                DecimalFormat df=new DecimalFormat("0.00");
                String  rate = df.format(((float)(1-(indexValue/indexAll))));
                indexOrder.setRate(rate);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return indexOrder;

    }


    /**
     * @desc 查询预约完成率、配车完成率、派工完成率、签收准时率、下LES完成率（内部）
     * @param indexOrder
     * @return
     */
    public String getFinishRate(IndexOrder indexOrder) {
        String dateDt = DateUtil.dateDtFormat.format(new Date());//获取当前日期
        indexOrder.setDateDt(dateDt);
        indexOrder = indexOrderDao.selectOne("getFinishRate",indexOrder);
        String finishRate = "100";
        if(indexOrder.getIndexValue() != null && indexOrder.getIndexAll() != null){
            finishRate = String.valueOf((int)(Double.valueOf(indexOrder.getIndexValue())/Double.valueOf(indexOrder.getIndexAll())*100));
        }
        return finishRate;
    }

    /**
     * @desc 查询预约及时率/完成率趋势图（内部）
     * @param indexOrder
     * @return
     */
    public IndexOrder findRateTrendList(IndexOrder indexOrder) {
        try {
            String endDate = "20170903";//DateUtil.dateDtFormat.format(new Date());//获取当前日期
            String startDate = "20170901";//
            DateUtil.getFirstDayOfThisMonth(endDate);//获取本月第一天
            indexOrder.setStartDate(startDate);
            indexOrder.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String indexId = indexOrder.getIndexId();
        String[] str = indexId.split(",");
        indexOrder.setIndexId(str[0]);
        List<IndexOrder> timelyIndexOrderList = indexOrderDao.selectList("findRateTrendList",indexOrder);//获取及时数据
        indexOrder.setIndexId(str[1]);
        List<IndexOrder> finishIndexOrderList = indexOrderDao.selectList("findRateTrendList",indexOrder);//获取完成数据
        String rate = "100";
        List<IndexOrder> timelyRateList = new ArrayList<IndexOrder>();//及时率列表
        List<IndexOrder> finishRateList = new ArrayList<IndexOrder>();//完成率列表

        for(IndexOrder obj : timelyIndexOrderList){
            if(obj.getIndexValue() != null && obj.getIndexAll() != null){
                rate = String.valueOf((int)(Double.valueOf(obj.getIndexValue())/Double.valueOf(obj.getIndexAll())*100));
                IndexOrder rateIndexOrder = new IndexOrder();
                rateIndexOrder.setIndexId(obj.getIndexId());
                rateIndexOrder.setDateDt(obj.getDateDt());
                rateIndexOrder.setRate(rate);
                timelyRateList.add(rateIndexOrder);
            }
        }
        for(IndexOrder obj : finishIndexOrderList){
            if(obj.getIndexValue() != null && obj.getIndexAll() != null){
                rate = String.valueOf((int)(Double.valueOf(obj.getIndexValue())/Double.valueOf(obj.getIndexAll())*100));
                IndexOrder rateIndexOrder = new IndexOrder();
                rateIndexOrder.setIndexId(obj.getIndexId());
                rateIndexOrder.setDateDt(obj.getDateDt());
                rateIndexOrder.setRate(rate);
                finishRateList.add(rateIndexOrder);
            }
        }
        IndexOrder indexOrderRate = new IndexOrder();
        indexOrderRate.setTimelyRateList(timelyRateList);
        indexOrderRate.setFinishRateList(finishRateList);
        return indexOrderRate;
    }
}
