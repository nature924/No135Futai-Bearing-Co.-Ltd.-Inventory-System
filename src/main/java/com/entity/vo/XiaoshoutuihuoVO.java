package com.entity.vo;

import com.entity.XiaoshoutuihuoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品退货
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoshoutuihuo")
public class XiaoshoutuihuoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品销售
     */

    @TableField(value = "shangpinxiaoshou_id")
    private Integer shangpinxiaoshouId;


    /**
     * 退货编号
     */

    @TableField(value = "xiaoshoutuihuo_uuid_number")
    private String xiaoshoutuihuoUuidNumber;


    /**
     * 退货数量
     */

    @TableField(value = "caozuo_number")
    private Integer caozuoNumber;


    /**
     * 退货缘由
     */

    @TableField(value = "xiaoshoutuihuo_yuanyou_content")
    private String xiaoshoutuihuoYuanyouContent;


    /**
     * 退还金额
     */

    @TableField(value = "tuihuan_jine")
    private Double tuihuanJine;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tuihuo_time")
    private Date tuihuoTime;


    /**
     * 备注
     */

    @TableField(value = "xiaoshoutuihuo_content")
    private String xiaoshoutuihuoContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：商品销售
	 */
    public Integer getShangpinxiaoshouId() {
        return shangpinxiaoshouId;
    }


    /**
	 * 获取：商品销售
	 */

    public void setShangpinxiaoshouId(Integer shangpinxiaoshouId) {
        this.shangpinxiaoshouId = shangpinxiaoshouId;
    }
    /**
	 * 设置：退货编号
	 */
    public String getXiaoshoutuihuoUuidNumber() {
        return xiaoshoutuihuoUuidNumber;
    }


    /**
	 * 获取：退货编号
	 */

    public void setXiaoshoutuihuoUuidNumber(String xiaoshoutuihuoUuidNumber) {
        this.xiaoshoutuihuoUuidNumber = xiaoshoutuihuoUuidNumber;
    }
    /**
	 * 设置：退货数量
	 */
    public Integer getCaozuoNumber() {
        return caozuoNumber;
    }


    /**
	 * 获取：退货数量
	 */

    public void setCaozuoNumber(Integer caozuoNumber) {
        this.caozuoNumber = caozuoNumber;
    }
    /**
	 * 设置：退货缘由
	 */
    public String getXiaoshoutuihuoYuanyouContent() {
        return xiaoshoutuihuoYuanyouContent;
    }


    /**
	 * 获取：退货缘由
	 */

    public void setXiaoshoutuihuoYuanyouContent(String xiaoshoutuihuoYuanyouContent) {
        this.xiaoshoutuihuoYuanyouContent = xiaoshoutuihuoYuanyouContent;
    }
    /**
	 * 设置：退还金额
	 */
    public Double getTuihuanJine() {
        return tuihuanJine;
    }


    /**
	 * 获取：退还金额
	 */

    public void setTuihuanJine(Double tuihuanJine) {
        this.tuihuanJine = tuihuanJine;
    }
    /**
	 * 设置：退货时间
	 */
    public Date getTuihuoTime() {
        return tuihuoTime;
    }


    /**
	 * 获取：退货时间
	 */

    public void setTuihuoTime(Date tuihuoTime) {
        this.tuihuoTime = tuihuoTime;
    }
    /**
	 * 设置：备注
	 */
    public String getXiaoshoutuihuoContent() {
        return xiaoshoutuihuoContent;
    }


    /**
	 * 获取：备注
	 */

    public void setXiaoshoutuihuoContent(String xiaoshoutuihuoContent) {
        this.xiaoshoutuihuoContent = xiaoshoutuihuoContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
