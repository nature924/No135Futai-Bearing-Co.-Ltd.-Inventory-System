package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 商品销售
 *
 * @author 
 * @email
 */
@TableName("shangpinxiaoshou")
public class ShangpinxiaoshouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinxiaoshouEntity() {

	}

	public ShangpinxiaoshouEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 商品
     */
    @ColumnInfo(comment="商品",type="int(11)")
    @TableField(value = "shangpin_id")

    private Integer shangpinId;


    /**
     * 客户
     */
    @ColumnInfo(comment="客户",type="int(11)")
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 销售人员
     */
    @ColumnInfo(comment="销售人员",type="int(11)")
    @TableField(value = "xiaoshourenyuan_id")

    private Integer xiaoshourenyuanId;


    /**
     * 销售编号
     */
    @ColumnInfo(comment="销售编号",type="varchar(200)")
    @TableField(value = "shangpinxiaoshou_uuid_number")

    private String shangpinxiaoshouUuidNumber;


    /**
     * 销售标题
     */
    @ColumnInfo(comment="销售标题",type="varchar(200)")
    @TableField(value = "shangpinxiaoshou_name")

    private String shangpinxiaoshouName;


    /**
     * 销售数量
     */
    @ColumnInfo(comment="销售数量",type="int(11)")
    @TableField(value = "caozuo_number")

    private Integer caozuoNumber;


    /**
     * 钱款结清
     */
    @ColumnInfo(comment="钱款结清",type="int(11)")
    @TableField(value = "jieqing_types")

    private Integer jieqingTypes;


    /**
     * 销售金额
     */
    @ColumnInfo(comment="销售金额",type="decimal(10,2)")
    @TableField(value = "huafei_money")

    private Double huafeiMoney;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="销售时间",type="timestamp")
    @TableField(value = "xiaoshou_time")

    private Date xiaoshouTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "shangpinxiaoshou_content")

    private String shangpinxiaoshouContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Shangpinxiaoshou{" +
            ", id=" + id +
            ", shangpinId=" + shangpinId +
            ", kehuId=" + kehuId +
            ", xiaoshourenyuanId=" + xiaoshourenyuanId +
            ", shangpinxiaoshouUuidNumber=" + shangpinxiaoshouUuidNumber +
            ", shangpinxiaoshouName=" + shangpinxiaoshouName +
            ", caozuoNumber=" + caozuoNumber +
            ", jieqingTypes=" + jieqingTypes +
            ", huafeiMoney=" + huafeiMoney +
            ", xiaoshouTime=" + DateUtil.convertString(xiaoshouTime,"yyyy-MM-dd") +
            ", shangpinxiaoshouContent=" + shangpinxiaoshouContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
