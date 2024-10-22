package com.entity.model;

import com.entity.XiaoshourenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 销售人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoshourenyuanModel implements Serializable {
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
     * 销售人员姓名
     */
    private String xiaoshourenyuanName;


    /**
     * 销售人员手机号
     */
    private String xiaoshourenyuanPhone;


    /**
     * 销售人员身份证号
     */
    private String xiaoshourenyuanIdNumber;


    /**
     * 销售人员照片
     */
    private String xiaoshourenyuanPhoto;


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
    private String xiaoshourenyuanEmail;


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
	 * 获取：销售人员姓名
	 */
    public String getXiaoshourenyuanName() {
        return xiaoshourenyuanName;
    }


    /**
	 * 设置：销售人员姓名
	 */
    public void setXiaoshourenyuanName(String xiaoshourenyuanName) {
        this.xiaoshourenyuanName = xiaoshourenyuanName;
    }
    /**
	 * 获取：销售人员手机号
	 */
    public String getXiaoshourenyuanPhone() {
        return xiaoshourenyuanPhone;
    }


    /**
	 * 设置：销售人员手机号
	 */
    public void setXiaoshourenyuanPhone(String xiaoshourenyuanPhone) {
        this.xiaoshourenyuanPhone = xiaoshourenyuanPhone;
    }
    /**
	 * 获取：销售人员身份证号
	 */
    public String getXiaoshourenyuanIdNumber() {
        return xiaoshourenyuanIdNumber;
    }


    /**
	 * 设置：销售人员身份证号
	 */
    public void setXiaoshourenyuanIdNumber(String xiaoshourenyuanIdNumber) {
        this.xiaoshourenyuanIdNumber = xiaoshourenyuanIdNumber;
    }
    /**
	 * 获取：销售人员照片
	 */
    public String getXiaoshourenyuanPhoto() {
        return xiaoshourenyuanPhoto;
    }


    /**
	 * 设置：销售人员照片
	 */
    public void setXiaoshourenyuanPhoto(String xiaoshourenyuanPhoto) {
        this.xiaoshourenyuanPhoto = xiaoshourenyuanPhoto;
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
    public String getXiaoshourenyuanEmail() {
        return xiaoshourenyuanEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setXiaoshourenyuanEmail(String xiaoshourenyuanEmail) {
        this.xiaoshourenyuanEmail = xiaoshourenyuanEmail;
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
