package com.entity.vo;

import com.entity.ShangpincurukuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品出入库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangpincuruku")
public class ShangpincurukuVO implements Serializable {
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
     * 仓库人员
     */

    @TableField(value = "cangkurenyuan_id")
    private Integer cangkurenyuanId;


    /**
     * 出入库编号
     */

    @TableField(value = "shangpincuruku_uuid_number")
    private String shangpincurukuUuidNumber;


    /**
     * 出入库标题
     */

    @TableField(value = "shangpincuruku_name")
    private String shangpincurukuName;


    /**
     * 类型
     */

    @TableField(value = "shangpincuruku_types")
    private Integer shangpincurukuTypes;


    /**
     * 操作数量
     */

    @TableField(value = "caozuo_number")
    private Integer caozuoNumber;


    /**
     * 钱款结清
     */

    @TableField(value = "jieqing_types")
    private Integer jieqingTypes;


    /**
     * 备注
     */

    @TableField(value = "shangpincuruku_content")
    private String shangpincurukuContent;


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
	 * 设置：仓库人员
	 */
    public Integer getCangkurenyuanId() {
        return cangkurenyuanId;
    }


    /**
	 * 获取：仓库人员
	 */

    public void setCangkurenyuanId(Integer cangkurenyuanId) {
        this.cangkurenyuanId = cangkurenyuanId;
    }
    /**
	 * 设置：出入库编号
	 */
    public String getShangpincurukuUuidNumber() {
        return shangpincurukuUuidNumber;
    }


    /**
	 * 获取：出入库编号
	 */

    public void setShangpincurukuUuidNumber(String shangpincurukuUuidNumber) {
        this.shangpincurukuUuidNumber = shangpincurukuUuidNumber;
    }
    /**
	 * 设置：出入库标题
	 */
    public String getShangpincurukuName() {
        return shangpincurukuName;
    }


    /**
	 * 获取：出入库标题
	 */

    public void setShangpincurukuName(String shangpincurukuName) {
        this.shangpincurukuName = shangpincurukuName;
    }
    /**
	 * 设置：类型
	 */
    public Integer getShangpincurukuTypes() {
        return shangpincurukuTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setShangpincurukuTypes(Integer shangpincurukuTypes) {
        this.shangpincurukuTypes = shangpincurukuTypes;
    }
    /**
	 * 设置：操作数量
	 */
    public Integer getCaozuoNumber() {
        return caozuoNumber;
    }


    /**
	 * 获取：操作数量
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
	 * 设置：备注
	 */
    public String getShangpincurukuContent() {
        return shangpincurukuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setShangpincurukuContent(String shangpincurukuContent) {
        this.shangpincurukuContent = shangpincurukuContent;
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
