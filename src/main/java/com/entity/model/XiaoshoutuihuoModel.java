package com.entity.model;

import com.entity.XiaoshoutuihuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品退货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoshoutuihuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品销售
     */
    private Integer shangpinxiaoshouId;


    /**
     * 退货编号
     */
    private String xiaoshoutuihuoUuidNumber;


    /**
     * 退货数量
     */
    private Integer caozuoNumber;


    /**
     * 退货缘由
     */
    private String xiaoshoutuihuoYuanyouContent;


    /**
     * 退还金额
     */
    private Double tuihuanJine;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tuihuoTime;


    /**
     * 备注
     */
    private String xiaoshoutuihuoContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商品销售
	 */
    public Integer getShangpinxiaoshouId() {
        return shangpinxiaoshouId;
    }


    /**
	 * 设置：商品销售
	 */
    public void setShangpinxiaoshouId(Integer shangpinxiaoshouId) {
        this.shangpinxiaoshouId = shangpinxiaoshouId;
    }
    /**
	 * 获取：退货编号
	 */
    public String getXiaoshoutuihuoUuidNumber() {
        return xiaoshoutuihuoUuidNumber;
    }


    /**
	 * 设置：退货编号
	 */
    public void setXiaoshoutuihuoUuidNumber(String xiaoshoutuihuoUuidNumber) {
        this.xiaoshoutuihuoUuidNumber = xiaoshoutuihuoUuidNumber;
    }
    /**
	 * 获取：退货数量
	 */
    public Integer getCaozuoNumber() {
        return caozuoNumber;
    }


    /**
	 * 设置：退货数量
	 */
    public void setCaozuoNumber(Integer caozuoNumber) {
        this.caozuoNumber = caozuoNumber;
    }
    /**
	 * 获取：退货缘由
	 */
    public String getXiaoshoutuihuoYuanyouContent() {
        return xiaoshoutuihuoYuanyouContent;
    }


    /**
	 * 设置：退货缘由
	 */
    public void setXiaoshoutuihuoYuanyouContent(String xiaoshoutuihuoYuanyouContent) {
        this.xiaoshoutuihuoYuanyouContent = xiaoshoutuihuoYuanyouContent;
    }
    /**
	 * 获取：退还金额
	 */
    public Double getTuihuanJine() {
        return tuihuanJine;
    }


    /**
	 * 设置：退还金额
	 */
    public void setTuihuanJine(Double tuihuanJine) {
        this.tuihuanJine = tuihuanJine;
    }
    /**
	 * 获取：退货时间
	 */
    public Date getTuihuoTime() {
        return tuihuoTime;
    }


    /**
	 * 设置：退货时间
	 */
    public void setTuihuoTime(Date tuihuoTime) {
        this.tuihuoTime = tuihuoTime;
    }
    /**
	 * 获取：备注
	 */
    public String getXiaoshoutuihuoContent() {
        return xiaoshoutuihuoContent;
    }


    /**
	 * 设置：备注
	 */
    public void setXiaoshoutuihuoContent(String xiaoshoutuihuoContent) {
        this.xiaoshoutuihuoContent = xiaoshoutuihuoContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
