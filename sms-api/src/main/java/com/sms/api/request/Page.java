package com.sms.api.request;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author chengxing
 * @date 2021/04/08
 * @decription 分页
 */
public class Page implements Serializable {

    private static final long serialVersionUID = -4459581002535608627L;
    // 当前页
    private Integer pageIndex;
    // 每页条数
    private Integer pageSize;
    // 开始记录
    private Integer pageStart;
    // null或者0分页；1：不分页
    private Integer all;
    private String startDate;
    private String endDate;
    // 排序字段
    private String sortField;
    // desc or asc
    private String orderType;

    public Integer getPageIndex() {
        if (pageIndex == null || pageIndex == 0) {
            return 1;
        }
        return Math.abs(pageIndex);
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = Math.abs(pageIndex);
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getPageStart() {
        if (pageIndex == null || pageIndex == 0) {
            return 0;
        }
        return Math.abs((pageIndex - 1) * getPageSize());
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        StringBuffer stringTemp = new StringBuffer();
        //如果是空的话返回
        if (StringUtils.isEmpty(sortField)) {
            this.sortField = sortField;
            return;
        }

        for (char charTemp : sortField.toCharArray()) {
            if (Character.isUpperCase(charTemp)) {
                stringTemp.append("_").append(Character.toLowerCase(charTemp));
            } else {
                stringTemp.append(charTemp);
            }
        }
        this.sortField = stringTemp.toString();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
