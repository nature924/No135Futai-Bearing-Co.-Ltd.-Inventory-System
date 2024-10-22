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
 * 仓库人员
 *
 * @author 
 * @email
 */
@TableName("cangkurenyuan")
public class CangkurenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CangkurenyuanEntity() {

	}

	public CangkurenyuanEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 仓库人员姓名
     */
    @ColumnInfo(comment="仓库人员姓名",type="varchar(200)")
    @TableField(value = "cangkurenyuan_name")

    private String cangkurenyuanName;


    /**
     * 仓库人员手机号
     */
    @ColumnInfo(comment="仓库人员手机号",type="varchar(200)")
    @TableField(value = "cangkurenyuan_phone")

    private String cangkurenyuanPhone;


    /**
     * 仓库人员身份证号
     */
    @ColumnInfo(comment="仓库人员身份证号",type="varchar(200)")
    @TableField(value = "cangkurenyuan_id_number")

    private String cangkurenyuanIdNumber;


    /**
     * 仓库人员照片
     */
    @ColumnInfo(comment="仓库人员照片",type="varchar(200)")
    @TableField(value = "cangkurenyuan_photo")

    private String cangkurenyuanPhoto;


    /**
     * 现住址
     */
    @ColumnInfo(comment="现住址",type="varchar(200)")
    @TableField(value = "xiaoshourenyuan_zhuzhi")

    private String xiaoshourenyuanZhuzhi;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "cangkurenyuan_email")

    private String cangkurenyuanEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：仓库人员姓名
	 */
    public String getCangkurenyuanName() {
        return cangkurenyuanName;
    }
    /**
	 * 设置：仓库人员姓名
	 */

    public void setCangkurenyuanName(String cangkurenyuanName) {
        this.cangkurenyuanName = cangkurenyuanName;
    }
    /**
	 * 获取：仓库人员手机号
	 */
    public String getCangkurenyuanPhone() {
        return cangkurenyuanPhone;
    }
    /**
	 * 设置：仓库人员手机号
	 */

    public void setCangkurenyuanPhone(String cangkurenyuanPhone) {
        this.cangkurenyuanPhone = cangkurenyuanPhone;
    }
    /**
	 * 获取：仓库人员身份证号
	 */
    public String getCangkurenyuanIdNumber() {
        return cangkurenyuanIdNumber;
    }
    /**
	 * 设置：仓库人员身份证号
	 */

    public void setCangkurenyuanIdNumber(String cangkurenyuanIdNumber) {
        this.cangkurenyuanIdNumber = cangkurenyuanIdNumber;
    }
    /**
	 * 获取：仓库人员照片
	 */
    public String getCangkurenyuanPhoto() {
        return cangkurenyuanPhoto;
    }
    /**
	 * 设置：仓库人员照片
	 */

    public void setCangkurenyuanPhoto(String cangkurenyuanPhoto) {
        this.cangkurenyuanPhoto = cangkurenyuanPhoto;
    }
    /**
	 * 获取：现住址
	 */
    public String getXiaoshourenyuanZhuzhi() {
        return xiaoshourenyuanZhuzhi;
    }
    /**
	 * 设置：现住址
	 */

    public void setXiaoshourenyuanZhuzhi(String xiaoshourenyuanZhuzhi) {
        this.xiaoshourenyuanZhuzhi = xiaoshourenyuanZhuzhi;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getCangkurenyuanEmail() {
        return cangkurenyuanEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setCangkurenyuanEmail(String cangkurenyuanEmail) {
        this.cangkurenyuanEmail = cangkurenyuanEmail;
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
        return "Cangkurenyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", cangkurenyuanName=" + cangkurenyuanName +
            ", cangkurenyuanPhone=" + cangkurenyuanPhone +
            ", cangkurenyuanIdNumber=" + cangkurenyuanIdNumber +
            ", cangkurenyuanPhoto=" + cangkurenyuanPhoto +
            ", xiaoshourenyuanZhuzhi=" + xiaoshourenyuanZhuzhi +
            ", sexTypes=" + sexTypes +
            ", cangkurenyuanEmail=" + cangkurenyuanEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
