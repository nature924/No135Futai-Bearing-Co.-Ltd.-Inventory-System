package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KehuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 客户
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kehu")
public class KehuView extends KehuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 客户来源的值
	*/
	@ColumnInfo(comment="客户来源的字典表值",type="varchar(200)")
	private String laiyuanValue;
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;

	//级联表 销售人员
		/**
		* 销售人员姓名
		*/

		@ColumnInfo(comment="销售人员姓名",type="varchar(200)")
		private String xiaoshourenyuanName;
		/**
		* 销售人员手机号
		*/

		@ColumnInfo(comment="销售人员手机号",type="varchar(200)")
		private String xiaoshourenyuanPhone;
		/**
		* 销售人员身份证号
		*/

		@ColumnInfo(comment="销售人员身份证号",type="varchar(200)")
		private String xiaoshourenyuanIdNumber;
		/**
		* 销售人员照片
		*/

		@ColumnInfo(comment="销售人员照片",type="varchar(200)")
		private String xiaoshourenyuanPhoto;
		/**
		* 现住址
		*/

		@ColumnInfo(comment="现住址",type="varchar(200)")
		private String xiaoshourenyuanZhuzhi;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String xiaoshourenyuanEmail;

	//重复字段


	public KehuView() {

	}

	public KehuView(KehuEntity kehuEntity) {
		try {
			BeanUtils.copyProperties(this, kehuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 客户来源的值
	*/
	public String getLaiyuanValue() {
		return laiyuanValue;
	}
	/**
	* 设置： 客户来源的值
	*/
	public void setLaiyuanValue(String laiyuanValue) {
		this.laiyuanValue = laiyuanValue;
	}
	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}


	//级联表的get和set 销售人员

		/**
		* 获取： 销售人员姓名
		*/
		public String getXiaoshourenyuanName() {
			return xiaoshourenyuanName;
		}
		/**
		* 设置： 销售人员姓名
		*/
		public void setXiaoshourenyuanName(String xiaoshourenyuanName) {
			this.xiaoshourenyuanName = xiaoshourenyuanName;
		}

		/**
		* 获取： 销售人员手机号
		*/
		public String getXiaoshourenyuanPhone() {
			return xiaoshourenyuanPhone;
		}
		/**
		* 设置： 销售人员手机号
		*/
		public void setXiaoshourenyuanPhone(String xiaoshourenyuanPhone) {
			this.xiaoshourenyuanPhone = xiaoshourenyuanPhone;
		}

		/**
		* 获取： 销售人员身份证号
		*/
		public String getXiaoshourenyuanIdNumber() {
			return xiaoshourenyuanIdNumber;
		}
		/**
		* 设置： 销售人员身份证号
		*/
		public void setXiaoshourenyuanIdNumber(String xiaoshourenyuanIdNumber) {
			this.xiaoshourenyuanIdNumber = xiaoshourenyuanIdNumber;
		}

		/**
		* 获取： 销售人员照片
		*/
		public String getXiaoshourenyuanPhoto() {
			return xiaoshourenyuanPhoto;
		}
		/**
		* 设置： 销售人员照片
		*/
		public void setXiaoshourenyuanPhoto(String xiaoshourenyuanPhoto) {
			this.xiaoshourenyuanPhoto = xiaoshourenyuanPhoto;
		}

		/**
		* 获取： 现住址
		*/
		public String getXiaoshourenyuanZhuzhi() {
			return xiaoshourenyuanZhuzhi;
		}
		/**
		* 设置： 现住址
		*/
		public void setXiaoshourenyuanZhuzhi(String xiaoshourenyuanZhuzhi) {
			this.xiaoshourenyuanZhuzhi = xiaoshourenyuanZhuzhi;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getXiaoshourenyuanEmail() {
			return xiaoshourenyuanEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setXiaoshourenyuanEmail(String xiaoshourenyuanEmail) {
			this.xiaoshourenyuanEmail = xiaoshourenyuanEmail;
		}

	//重复字段

	@Override
	public String toString() {
		return "KehuView{" +
			", laiyuanValue=" + laiyuanValue +
			", sexValue=" + sexValue +
			", xiaoshourenyuanName=" + xiaoshourenyuanName +
			", xiaoshourenyuanPhone=" + xiaoshourenyuanPhone +
			", xiaoshourenyuanIdNumber=" + xiaoshourenyuanIdNumber +
			", xiaoshourenyuanPhoto=" + xiaoshourenyuanPhoto +
			", xiaoshourenyuanZhuzhi=" + xiaoshourenyuanZhuzhi +
			", xiaoshourenyuanEmail=" + xiaoshourenyuanEmail +
			"} " + super.toString();
	}
}
