package com.entity.vo;

import com.entity.XiaoshourenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 销售人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoshourenyuan")
public class XiaoshourenyuanVO implements Serializable {
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
     * 销售人员姓名
     */

    @TableField(value = "xiaoshourenyuan_name")
    private String xiaoshourenyuanName;


    /**
     * 销售人员手机号
     */

    @TableField(value = "xiaoshourenyuan_phone")
    private String xiaoshourenyuanPhone;


    /**
     * 销售人员身份证号
     */

    @TableField(value = "xiaoshourenyuan_id_number")
    private String xiaoshourenyuanIdNumber;


    /**
     * 销售人员照片
     */

    @TableField(value = "xiaoshourenyuan_photo")
    private String xiaoshourenyuanPhoto;


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

    @TableField(value = "xiaoshourenyuan_email")
    private String xiaoshourenyuanEmail;


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
	 * 设置：销售人员姓名
	 */
    public String getXiaoshourenyuanName() {
        return xiaoshourenyuanName;
    }


    /**
	 * 获取：销售人员姓名
	 */

    public void setXiaoshourenyuanName(String xiaoshourenyuanName) {
        this.xiaoshourenyuanName = xiaoshourenyuanName;
    }
    /**
	 * 设置：销售人员手机号
	 */
    public String getXiaoshourenyuanPhone() {
        return xiaoshourenyuanPhone;
    }


    /**
	 * 获取：销售人员手机号
	 */

    public void setXiaoshourenyuanPhone(String xiaoshourenyuanPhone) {
        this.xiaoshourenyuanPhone = xiaoshourenyuanPhone;
    }
    /**
	 * 设置：销售人员身份证号
	 */
    public String getXiaoshourenyuanIdNumber() {
        return xiaoshourenyuanIdNumber;
    }


    /**
	 * 获取：销售人员身份证号
	 */

    public void setXiaoshourenyuanIdNumber(String xiaoshourenyuanIdNumber) {
        this.xiaoshourenyuanIdNumber = xiaoshourenyuanIdNumber;
    }
    /**
	 * 设置：销售人员照片
	 */
    public String getXiaoshourenyuanPhoto() {
        return xiaoshourenyuanPhoto;
    }


    /**
	 * 获取：销售人员照片
	 */

    public void setXiaoshourenyuanPhoto(String xiaoshourenyuanPhoto) {
        this.xiaoshourenyuanPhoto = xiaoshourenyuanPhoto;
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
    public String getXiaoshourenyuanEmail() {
        return xiaoshourenyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setXiaoshourenyuanEmail(String xiaoshourenyuanEmail) {
        this.xiaoshourenyuanEmail = xiaoshourenyuanEmail;
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
