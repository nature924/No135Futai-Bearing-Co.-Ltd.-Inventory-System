package com.entity.vo;

import com.entity.KehuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kehu")
public class KehuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 销售人员
     */

    @TableField(value = "xiaoshourenyuan_id")
    private Integer xiaoshourenyuanId;


    /**
     * 客户编号
     */

    @TableField(value = "kehu_uuid_number")
    private String kehuUuidNumber;


    /**
     * 客户姓名
     */

    @TableField(value = "kehu_name")
    private String kehuName;


    /**
     * 客户手机号
     */

    @TableField(value = "kehu_phone")
    private String kehuPhone;


    /**
     * 客户身份证号
     */

    @TableField(value = "kehu_id_number")
    private String kehuIdNumber;


    /**
     * 客户照片
     */

    @TableField(value = "kehu_photo")
    private String kehuPhoto;


    /**
     * 客户住址
     */

    @TableField(value = "kehu_zhuzhi")
    private String kehuZhuzhi;


    /**
     * 客户来源
     */

    @TableField(value = "laiyuan_types")
    private Integer laiyuanTypes;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 客户邮箱
     */

    @TableField(value = "kehu_email")
    private String kehuEmail;


    /**
     * 客户备注
     */

    @TableField(value = "kehu_content")
    private String kehuContent;


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
	 * 设置：销售人员
	 */
    public Integer getXiaoshourenyuanId() {
        return xiaoshourenyuanId;
    }


    /**
	 * 获取：销售人员
	 */

    public void setXiaoshourenyuanId(Integer xiaoshourenyuanId) {
        this.xiaoshourenyuanId = xiaoshourenyuanId;
    }
    /**
	 * 设置：客户编号
	 */
    public String getKehuUuidNumber() {
        return kehuUuidNumber;
    }


    /**
	 * 获取：客户编号
	 */

    public void setKehuUuidNumber(String kehuUuidNumber) {
        this.kehuUuidNumber = kehuUuidNumber;
    }
    /**
	 * 设置：客户姓名
	 */
    public String getKehuName() {
        return kehuName;
    }


    /**
	 * 获取：客户姓名
	 */

    public void setKehuName(String kehuName) {
        this.kehuName = kehuName;
    }
    /**
	 * 设置：客户手机号
	 */
    public String getKehuPhone() {
        return kehuPhone;
    }


    /**
	 * 获取：客户手机号
	 */

    public void setKehuPhone(String kehuPhone) {
        this.kehuPhone = kehuPhone;
    }
    /**
	 * 设置：客户身份证号
	 */
    public String getKehuIdNumber() {
        return kehuIdNumber;
    }


    /**
	 * 获取：客户身份证号
	 */

    public void setKehuIdNumber(String kehuIdNumber) {
        this.kehuIdNumber = kehuIdNumber;
    }
    /**
	 * 设置：客户照片
	 */
    public String getKehuPhoto() {
        return kehuPhoto;
    }


    /**
	 * 获取：客户照片
	 */

    public void setKehuPhoto(String kehuPhoto) {
        this.kehuPhoto = kehuPhoto;
    }
    /**
	 * 设置：客户住址
	 */
    public String getKehuZhuzhi() {
        return kehuZhuzhi;
    }


    /**
	 * 获取：客户住址
	 */

    public void setKehuZhuzhi(String kehuZhuzhi) {
        this.kehuZhuzhi = kehuZhuzhi;
    }
    /**
	 * 设置：客户来源
	 */
    public Integer getLaiyuanTypes() {
        return laiyuanTypes;
    }


    /**
	 * 获取：客户来源
	 */

    public void setLaiyuanTypes(Integer laiyuanTypes) {
        this.laiyuanTypes = laiyuanTypes;
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
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：客户邮箱
	 */
    public String getKehuEmail() {
        return kehuEmail;
    }


    /**
	 * 获取：客户邮箱
	 */

    public void setKehuEmail(String kehuEmail) {
        this.kehuEmail = kehuEmail;
    }
    /**
	 * 设置：客户备注
	 */
    public String getKehuContent() {
        return kehuContent;
    }


    /**
	 * 获取：客户备注
	 */

    public void setKehuContent(String kehuContent) {
        this.kehuContent = kehuContent;
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
