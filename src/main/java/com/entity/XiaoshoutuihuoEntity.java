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
 * 商品退货
 *
 * @author 
 * @email
 */
@TableName("xiaoshoutuihuo")
public class XiaoshoutuihuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoshoutuihuoEntity() {

	}

	public XiaoshoutuihuoEntity(T t) {
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
     * 商品销售
     */
    @ColumnInfo(comment="商品销售",type="int(11)")
    @TableField(value = "shangpinxiaoshou_id")

    private Integer shangpinxiaoshouId;


    /**
     * 退货编号
     */
    @ColumnInfo(comment="退货编号",type="varchar(200)")
    @TableField(value = "xiaoshoutuihuo_uuid_number")

    private String xiaoshoutuihuoUuidNumber;


    /**
     * 退货数量
     */
    @ColumnInfo(comment="退货数量",type="int(11)")
    @TableField(value = "caozuo_number")

    private Integer caozuoNumber;


    /**
     * 退货缘由
     */
    @ColumnInfo(comment="退货缘由",type="text")
    @TableField(value = "xiaoshoutuihuo_yuanyou_content")

    private String xiaoshoutuihuoYuanyouContent;


    /**
     * 退还金额
     */
    @ColumnInfo(comment="退还金额",type="decimal(10,2)")
    @TableField(value = "tuihuan_jine")

    private Double tuihuanJine;


    /**
     * 退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="退货时间",type="timestamp")
    @TableField(value = "tuihuo_time")

    private Date tuihuoTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "xiaoshoutuihuo_content")

    private String xiaoshoutuihuoContent;


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

    @Override
    public String toString() {
        return "Xiaoshoutuihuo{" +
            ", id=" + id +
            ", shangpinxiaoshouId=" + shangpinxiaoshouId +
            ", xiaoshoutuihuoUuidNumber=" + xiaoshoutuihuoUuidNumber +
            ", caozuoNumber=" + caozuoNumber +
            ", xiaoshoutuihuoYuanyouContent=" + xiaoshoutuihuoYuanyouContent +
            ", tuihuanJine=" + tuihuanJine +
            ", tuihuoTime=" + DateUtil.convertString(tuihuoTime,"yyyy-MM-dd") +
            ", xiaoshoutuihuoContent=" + xiaoshoutuihuoContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
