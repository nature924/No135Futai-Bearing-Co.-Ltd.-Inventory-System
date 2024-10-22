package com.entity.model;

import com.entity.ShangpinxiaoshouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品销售
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpinxiaoshouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品
     */
    private Integer shangpinId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 销售人员
     */
    private Integer xiaoshourenyuanId;


    /**
     * 销售编号
     */
    private String shangpinxiaoshouUuidNumber;


    /**
     * 销售标题
     */
    private String shangpinxiaoshouName;


    /**
     * 销售数量
     */
    private Integer caozuoNumber;


    /**
     * 钱款结清
     */
    private Integer jieqingTypes;


    /**
     * 销售金额
     */
    private Double huafeiMoney;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiaoshouTime;


    /**
     * 备注
     */
    private String shangpinxiaoshouContent;


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
	 * 获取：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 设置：商品
	 */
    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：销售人员
	 */
    public Integer getXiaoshourenyuanId() {
        return xiaoshourenyuanId;
    }


    /**
	 * 设置：销售人员
	 */
    public void setXiaoshourenyuanId(Integer xiaoshourenyuanId) {
        this.xiaoshourenyuanId = xiaoshourenyuanId;
    }
    /**
	 * 获取：销售编号
	 */
    public String getShangpinxiaoshouUuidNumber() {
        return shangpinxiaoshouUuidNumber;
    }


    /**
	 * 设置：销售编号
	 */
    public void setShangpinxiaoshouUuidNumber(String shangpinxiaoshouUuidNumber) {
        this.shangpinxiaoshouUuidNumber = shangpinxiaoshouUuidNumber;
    }
    /**
	 * 获取：销售标题
	 */
    public String getShangpinxiaoshouName() {
        return shangpinxiaoshouName;
    }


    /**
	 * 设置：销售标题
	 */
    public void setShangpinxiaoshouName(String shangpinxiaoshouName) {
        this.shangpinxiaoshouName = shangpinxiaoshouName;
    }
    /**
	 * 获取：销售数量
	 */
    public Integer getCaozuoNumber() {
        return caozuoNumber;
    }


    /**
	 * 设置：销售数量
	 */
    public void setCaozuoNumber(Integer caozuoNumber) {
        this.caozuoNumber = caozuoNumber;
    }
    /**
	 * 获取：钱款结清
	 */
    public Integer getJieqingTypes() {
        return jieqingTypes;
    }


    /**
	 * 设置：钱款结清
	 */
    public void setJieqingTypes(Integer jieqingTypes) {
        this.jieqingTypes = jieqingTypes;
    }
    /**
	 * 获取：销售金额
	 */
    public Double getHuafeiMoney() {
        return huafeiMoney;
    }


    /**
	 * 设置：销售金额
	 */
    public void setHuafeiMoney(Double huafeiMoney) {
        this.huafeiMoney = huafeiMoney;
    }
    /**
	 * 获取：销售时间
	 */
    public Date getXiaoshouTime() {
        return xiaoshouTime;
    }


    /**
	 * 设置：销售时间
	 */
    public void setXiaoshouTime(Date xiaoshouTime) {
        this.xiaoshouTime = xiaoshouTime;
    }
    /**
	 * 获取：备注
	 */
    public String getShangpinxiaoshouContent() {
        return shangpinxiaoshouContent;
    }


    /**
	 * 设置：备注
	 */
    public void setShangpinxiaoshouContent(String shangpinxiaoshouContent) {
        this.shangpinxiaoshouContent = shangpinxiaoshouContent;
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
