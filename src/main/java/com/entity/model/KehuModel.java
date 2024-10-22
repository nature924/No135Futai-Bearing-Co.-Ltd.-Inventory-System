package com.entity.model;

import com.entity.KehuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KehuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 销售人员
     */
    private Integer xiaoshourenyuanId;


    /**
     * 客户编号
     */
    private String kehuUuidNumber;


    /**
     * 客户姓名
     */
    private String kehuName;


    /**
     * 客户手机号
     */
    private String kehuPhone;


    /**
     * 客户身份证号
     */
    private String kehuIdNumber;


    /**
     * 客户照片
     */
    private String kehuPhoto;


    /**
     * 客户住址
     */
    private String kehuZhuzhi;


    /**
     * 客户来源
     */
    private Integer laiyuanTypes;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 客户邮箱
     */
    private String kehuEmail;


    /**
     * 客户备注
     */
    private String kehuContent;


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
	 * 获取：销售人员
	 */
    public Integer getXiaoshourenyuanId() {
        return xiaoshourenyuanId;
    }


    /**
	 * 设置：销售人员
	 */
    public void setXiaoshourenyuanId(Integer xiaoshourenyuanId) {
        this.xiaoshourenyuanId = xiaoshourenyuanId;
    }
    /**
	 * 获取：客户编号
	 */
    public String getKehuUuidNumber() {
        return kehuUuidNumber;
    }


    /**
	 * 设置：客户编号
	 */
    public void setKehuUuidNumber(String kehuUuidNumber) {
        this.kehuUuidNumber = kehuUuidNumber;
    }
    /**
	 * 获取：客户姓名
	 */
    public String getKehuName() {
        return kehuName;
    }


    /**
	 * 设置：客户姓名
	 */
    public void setKehuName(String kehuName) {
        this.kehuName = kehuName;
    }
    /**
	 * 获取：客户手机号
	 */
    public String getKehuPhone() {
        return kehuPhone;
    }


    /**
	 * 设置：客户手机号
	 */
    public void setKehuPhone(String kehuPhone) {
        this.kehuPhone = kehuPhone;
    }
    /**
	 * 获取：客户身份证号
	 */
    public String getKehuIdNumber() {
        return kehuIdNumber;
    }


    /**
	 * 设置：客户身份证号
	 */
    public void setKehuIdNumber(String kehuIdNumber) {
        this.kehuIdNumber = kehuIdNumber;
    }
    /**
	 * 获取：客户照片
	 */
    public String getKehuPhoto() {
        return kehuPhoto;
    }


    /**
	 * 设置：客户照片
	 */
    public void setKehuPhoto(String kehuPhoto) {
        this.kehuPhoto = kehuPhoto;
    }
    /**
	 * 获取：客户住址
	 */
    public String getKehuZhuzhi() {
        return kehuZhuzhi;
    }


    /**
	 * 设置：客户住址
	 */
    public void setKehuZhuzhi(String kehuZhuzhi) {
        this.kehuZhuzhi = kehuZhuzhi;
    }
    /**
	 * 获取：客户来源
	 */
    public Integer getLaiyuanTypes() {
        return laiyuanTypes;
    }


    /**
	 * 设置：客户来源
	 */
    public void setLaiyuanTypes(Integer laiyuanTypes) {
        this.laiyuanTypes = laiyuanTypes;
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
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 设置：年龄
	 */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：客户邮箱
	 */
    public String getKehuEmail() {
        return kehuEmail;
    }


    /**
	 * 设置：客户邮箱
	 */
    public void setKehuEmail(String kehuEmail) {
        this.kehuEmail = kehuEmail;
    }
    /**
	 * 获取：客户备注
	 */
    public String getKehuContent() {
        return kehuContent;
    }


    /**
	 * 设置：客户备注
	 */
    public void setKehuContent(String kehuContent) {
        this.kehuContent = kehuContent;
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
