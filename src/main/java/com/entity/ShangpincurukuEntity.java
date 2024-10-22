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
 * 商品出入库
 *
 * @author 
 * @email
 */
@TableName("shangpincuruku")
public class ShangpincurukuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpincurukuEntity() {

	}

	public ShangpincurukuEntity(T t) {
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
     * 仓库人员
     */
    @ColumnInfo(comment="仓库人员",type="int(11)")
    @TableField(value = "cangkurenyuan_id")

    private Integer cangkurenyuanId;


    /**
     * 出入库编号
     */
    @ColumnInfo(comment="出入库编号",type="varchar(200)")
    @TableField(value = "shangpincuruku_uuid_number")

    private String shangpincurukuUuidNumber;


    /**
     * 出入库标题
     */
    @ColumnInfo(comment="出入库标题",type="varchar(200)")
    @TableField(value = "shangpincuruku_name")

    private String shangpincurukuName;


    /**
     * 类型
     */
    @ColumnInfo(comment="类型",type="int(11)")
    @TableField(value = "shangpincuruku_types")

    private Integer shangpincurukuTypes;


    /**
     * 操作数量
     */
    @ColumnInfo(comment="操作数量",type="int(11)")
    @TableField(value = "caozuo_number")

    private Integer caozuoNumber;


    /**
     * 钱款结清
     */
    @ColumnInfo(comment="钱款结清",type="int(11)")
    @TableField(value = "jieqing_types")

    private Integer jieqingTypes;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "shangpincuruku_content")

    private String shangpincurukuContent;


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
	 * 获取：仓库人员
	 */
    public Integer getCangkurenyuanId() {
        return cangkurenyuanId;
    }
    /**
	 * 设置：仓库人员
	 */

    public void setCangkurenyuanId(Integer cangkurenyuanId) {
        this.cangkurenyuanId = cangkurenyuanId;
    }
    /**
	 * 获取：出入库编号
	 */
    public String getShangpincurukuUuidNumber() {
        return shangpincurukuUuidNumber;
    }
    /**
	 * 设置：出入库编号
	 */

    public void setShangpincurukuUuidNumber(String shangpincurukuUuidNumber) {
        this.shangpincurukuUuidNumber = shangpincurukuUuidNumber;
    }
    /**
	 * 获取：出入库标题
	 */
    public String getShangpincurukuName() {
        return shangpincurukuName;
    }
    /**
	 * 设置：出入库标题
	 */

    public void setShangpincurukuName(String shangpincurukuName) {
        this.shangpincurukuName = shangpincurukuName;
    }
    /**
	 * 获取：类型
	 */
    public Integer getShangpincurukuTypes() {
        return shangpincurukuTypes;
    }
    /**
	 * 设置：类型
	 */

    public void setShangpincurukuTypes(Integer shangpincurukuTypes) {
        this.shangpincurukuTypes = shangpincurukuTypes;
    }
    /**
	 * 获取：操作数量
	 */
    public Integer getCaozuoNumber() {
        return caozuoNumber;
    }
    /**
	 * 设置：操作数量
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
	 * 获取：备注
	 */
    public String getShangpincurukuContent() {
        return shangpincurukuContent;
    }
    /**
	 * 设置：备注
	 */

    public void setShangpincurukuContent(String shangpincurukuContent) {
        this.shangpincurukuContent = shangpincurukuContent;
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
        return "Shangpincuruku{" +
            ", id=" + id +
            ", shangpinId=" + shangpinId +
            ", cangkurenyuanId=" + cangkurenyuanId +
            ", shangpincurukuUuidNumber=" + shangpincurukuUuidNumber +
            ", shangpincurukuName=" + shangpincurukuName +
            ", shangpincurukuTypes=" + shangpincurukuTypes +
            ", caozuoNumber=" + caozuoNumber +
            ", jieqingTypes=" + jieqingTypes +
            ", shangpincurukuContent=" + shangpincurukuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
