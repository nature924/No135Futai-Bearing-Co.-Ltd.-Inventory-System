package com.entity.vo;

import com.entity.ShangpinxiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品销售
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangpinxiaoshou")
public class ShangpinxiaoshouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品
     */

    @TableField(value = "shangpin_id")
    private Integer shangpinId;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 销售人员
     */

    @TableField(value = "xiaoshourenyuan_id")
    private Integer xiaoshourenyuanId;


    /**
     * 销售编号
     */

    @TableField(value = "shangpinxiaoshou_uuid_number")
    private String shangpinxiaoshouUuidNumber;


    /**
     * 销售标题
     */

    @TableField(value = "shangpinxiaoshou_name")
    private String shangpinxiaoshouName;


    /**
     * 销售数量
     */

    @TableField(value = "caozuo_number")
    private Integer caozuoNumber;


    /**
     * 钱款结清
     */

    @TableField(value = "jieqing_types")
    private Integer jieqingTypes;


    /**
     * 销售金额
     */

    @TableField(value = "huafei_money")
    private Double huafeiMoney;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiaoshou_time")
    private Date xiaoshouTime;


    /**
     * 备注
     */

    @TableField(value = "shangpinxiaoshou_content")
    private String shangpinxiaoshouContent;


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
	 * 设置：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 获取：商品
	 */

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：销售人员
	 */
    public Integer getXiaoshourenyuanId() {
        return xiaoshourenyuanId;
    }


    /**
	 * 获取：销售人员
	 */

    public void setXiaoshourenyuanId(Integer xiaoshourenyuanId) {
        this.xiaoshourenyuanId = xiaoshourenyuanId;
    }
    /**
	 * 设置：销售编号
	 */
    public String getShangpinxiaoshouUuidNumber() {
        return shangpinxiaoshouUuidNumber;
    }


    /**
	 * 获取：销售编号
	 */

    public void setShangpinxiaoshouUuidNumber(String shangpinxiaoshouUuidNumber) {
        this.shangpinxiaoshouUuidNumber = shangpinxiaoshouUuidNumber;
    }
    /**
	 * 设置：销售标题
	 */
    public String getShangpinxiaoshouName() {
        return shangpinxiaoshouName;
    }


    /**
	 * 获取：销售标题
	 */

    public void setShangpinxiaoshouName(String shangpinxiaoshouName) {
        this.shangpinxiaoshouName = shangpinxiaoshouName;
    }
    /**
	 * 设置：销售数量
	 */
    public Integer getCaozuoNumber() {
        return caozuoNumber;
    }


    /**
	 * 获取：销售数量
	 */

    public void setCaozuoNumber(Integer caozuoNumber) {
        this.caozuoNumber = caozuoNumber;
    }
    /**
	 * 设置：钱款结清
	 */
    public Integer getJieqingTypes() {
        return jieqingTypes;
    }


    /**
	 * 获取：钱款结清
	 */

    public void setJieqingTypes(Integer jieqingTypes) {
        this.jieqingTypes = jieqingTypes;
    }
    /**
	 * 设置：销售金额
	 */
    public Double getHuafeiMoney() {
        return huafeiMoney;
    }


    /**
	 * 获取：销售金额
	 */

    public void setHuafeiMoney(Double huafeiMoney) {
        this.huafeiMoney = huafeiMoney;
    }
    /**
	 * 设置：销售时间
	 */
    public Date getXiaoshouTime() {
        return xiaoshouTime;
    }


    /**
	 * 获取：销售时间
	 */

    public void setXiaoshouTime(Date xiaoshouTime) {
        this.xiaoshouTime = xiaoshouTime;
    }
    /**
	 * 设置：备注
	 */
    public String getShangpinxiaoshouContent() {
        return shangpinxiaoshouContent;
    }


    /**
	 * 获取：备注
	 */

    public void setShangpinxiaoshouContent(String shangpinxiaoshouContent) {
        this.shangpinxiaoshouContent = shangpinxiaoshouContent;
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
