package com.entity.vo;

import com.entity.CangkurenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 仓库人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cangkurenyuan")
public class CangkurenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 仓库人员姓名
     */

    @TableField(value = "cangkurenyuan_name")
    private String cangkurenyuanName;


    /**
     * 仓库人员手机号
     */

    @TableField(value = "cangkurenyuan_phone")
    private String cangkurenyuanPhone;


    /**
     * 仓库人员身份证号
     */

    @TableField(value = "cangkurenyuan_id_number")
    private String cangkurenyuanIdNumber;


    /**
     * 仓库人员照片
     */

    @TableField(value = "cangkurenyuan_photo")
    private String cangkurenyuanPhoto;


    /**
     * 现住址
     */

    @TableField(value = "xiaoshourenyuan_zhuzhi")
    private String xiaoshourenyuanZhuzhi;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "cangkurenyuan_email")
    private String cangkurenyuanEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：仓库人员姓名
	 */
    public String getCangkurenyuanName() {
        return cangkurenyuanName;
    }


    /**
	 * 获取：仓库人员姓名
	 */

    public void setCangkurenyuanName(String cangkurenyuanName) {
        this.cangkurenyuanName = cangkurenyuanName;
    }
    /**
	 * 设置：仓库人员手机号
	 */
    public String getCangkurenyuanPhone() {
        return cangkurenyuanPhone;
    }


    /**
	 * 获取：仓库人员手机号
	 */

    public void setCangkurenyuanPhone(String cangkurenyuanPhone) {
        this.cangkurenyuanPhone = cangkurenyuanPhone;
    }
    /**
	 * 设置：仓库人员身份证号
	 */
    public String getCangkurenyuanIdNumber() {
        return cangkurenyuanIdNumber;
    }


    /**
	 * 获取：仓库人员身份证号
	 */

    public void setCangkurenyuanIdNumber(String cangkurenyuanIdNumber) {
        this.cangkurenyuanIdNumber = cangkurenyuanIdNumber;
    }
    /**
	 * 设置：仓库人员照片
	 */
    public String getCangkurenyuanPhoto() {
        return cangkurenyuanPhoto;
    }


    /**
	 * 获取：仓库人员照片
	 */

    public void setCangkurenyuanPhoto(String cangkurenyuanPhoto) {
        this.cangkurenyuanPhoto = cangkurenyuanPhoto;
    }
    /**
	 * 设置：现住址
	 */
    public String getXiaoshourenyuanZhuzhi() {
        return xiaoshourenyuanZhuzhi;
    }


    /**
	 * 获取：现住址
	 */

    public void setXiaoshourenyuanZhuzhi(String xiaoshourenyuanZhuzhi) {
        this.xiaoshourenyuanZhuzhi = xiaoshourenyuanZhuzhi;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getCangkurenyuanEmail() {
        return cangkurenyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setCangkurenyuanEmail(String cangkurenyuanEmail) {
        this.cangkurenyuanEmail = cangkurenyuanEmail;
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
