package com.silhouette.egobuy.result;

import com.silhouette.egobuy.base.BaseResult;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 00:06
 * @company: http://www.u7power.cn
 * @description: 专门用来封装EasyUIDataGrid的数据
 */
public class EasyUIDataGridResult extends BaseResult {
    private static final long serialVersionUID = -6592796641481965460L;

    //总条数
    private Integer total;
    //数据列表
    private List<?> rows;


    /**
     * @Title: EasyUIDataGridResult
     * @param total
     * @param rows
     */
    public EasyUIDataGridResult(Integer total, List<?> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    /**
     * @Title: EasyUIDataGridResult
     * @param total
     * @param rows
     */
    public EasyUIDataGridResult(Long total, List<?> rows) {
        super();
        this.total = total.intValue();
        this.rows = rows;
    }

    public EasyUIDataGridResult(){

    }


    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }
    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
    /**
     * @return the rows
     */
    public List<?> getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
