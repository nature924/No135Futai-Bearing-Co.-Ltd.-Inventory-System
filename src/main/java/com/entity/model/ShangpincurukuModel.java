package com.entity.model;

import com.entity.ShangpincurukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品出入库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpincurukuModel implements Serializable {
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
     * 仓库人员
     */
    private Integer cangkurenyuanId;


    /**
     * 出入库编号
     */
    private String shangpincurukuUuidNumber;


    /**
     * 出入库标题
     */
    private String shangpincurukuName;


    /**
     * 类型
     */
    private Integer shangpincurukuTypes;


    /**
     * 操作数量
     */
    private Integer caozuoNumber;


    /**
     * 钱款结清
     */
    private Integer jieqingTypes;


    /**
     * 备注
     */
    private String shangpincurukuContent;


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

    }
