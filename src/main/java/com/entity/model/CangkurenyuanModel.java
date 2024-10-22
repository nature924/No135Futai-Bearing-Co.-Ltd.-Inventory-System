package com.entity.model;

import com.entity.CangkurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 仓库人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CangkurenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 仓库人员姓名
     */
    private String cangkurenyuanName;


    /**
     * 仓库人员手机号
     */
    private String cangkurenyuanPhone;


    /**
     * 仓库人员身份证号
     */
    private String cangkurenyuanIdNumber;


    /**
     * 仓库人员照片
     */
    private String cangkurenyuanPhoto;


    /**
     * 现住址
     */
    private String xiaoshourenyuanZhuzhi;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String cangkurenyuanEmail;


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

    }
