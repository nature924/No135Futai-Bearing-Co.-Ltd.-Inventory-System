package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinxiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品销售
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpinxiaoshou")
public class ShangpinxiaoshouView extends ShangpinxiaoshouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 钱款结清的值
	*/
	@ColumnInfo(comment="钱款结清的字典表值",type="varchar(200)")
	private String jieqingValue;

	//级联表 客户
					 
		/**
		* 客户 的 销售人员
		*/
		@ColumnInfo(comment="销售人员",type="int(11)")
		private Integer kehuXiaoshourenyuanId;
		/**
		* 客户编号
		*/

		@ColumnInfo(comment="客户编号",type="varchar(200)")
		private String kehuUuidNumber;
		/**
		* 客户姓名
		*/

		@ColumnInfo(comment="客户姓名",type="varchar(200)")
		private String kehuName;
		/**
		* 客户手机号
		*/

		@ColumnInfo(comment="客户手机号",type="varchar(200)")
		private String kehuPhone;
		/**
		* 客户身份证号
		*/

		@ColumnInfo(comment="客户身份证号",type="varchar(200)")
		private String kehuIdNumber;
		/**
		* 客户照片
		*/

		@ColumnInfo(comment="客户照片",type="varchar(200)")
		private String kehuPhoto;
		/**
		* 客户住址
		*/

		@ColumnInfo(comment="客户住址",type="varchar(200)")
		private String kehuZhuzhi;
		/**
		* 客户来源
		*/
		@ColumnInfo(comment="客户来源",type="int(11)")
		private Integer laiyuanTypes;
			/**
			* 客户来源的值
			*/
			@ColumnInfo(comment="客户来源的字典表值",type="varchar(200)")
			private String laiyuanValue;
		/**
		* 年龄
		*/

		@ColumnInfo(comment="年龄",type="int(11)")
		private Integer age;
		/**
		* 客户邮箱
		*/

		@ColumnInfo(comment="客户邮箱",type="varchar(200)")
		private String kehuEmail;
		/**
		* 客户备注
		*/

		@ColumnInfo(comment="客户备注",type="text")
		private String kehuContent;
	//级联表 商品
							/**
		* 商品编号
		*/

		@ColumnInfo(comment="商品编号",type="varchar(200)")
		private String shangpinUuidNumber;
		/**
		* 商品名称
		*/

		@ColumnInfo(comment="商品名称",type="varchar(200)")
		private String shangpinName;
		/**
		* 商品照片
		*/

		@ColumnInfo(comment="商品照片",type="varchar(200)")
		private String shangpinPhoto;
		/**
		* 单位
		*/

		@ColumnInfo(comment="单位",type="varchar(200)")
		private String shangpinDanwei;
		/**
		* 商品类型
		*/
		@ColumnInfo(comment="商品类型",type="int(11)")
		private Integer shangpinTypes;
			/**
			* 商品类型的值
			*/
			@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
			private String shangpinValue;
		/**
		* 商品库存
		*/

		@ColumnInfo(comment="商品库存",type="int(11)")
		private Integer shangpinKucunNumber;
		/**
		* 进价
		*/
		@ColumnInfo(comment="进价",type="decimal(10,2)")
		private Double shangpinNewMoney;
		/**
		* 售价
		*/
		@ColumnInfo(comment="售价",type="decimal(10,2)")
		private Double shangpinOldMoney;
		/**
		* 仓库
		*/
		@ColumnInfo(comment="仓库",type="int(11)")
		private Integer cangkuTypes;
			/**
			* 仓库的值
			*/
			@ColumnInfo(comment="仓库的字典表值",type="varchar(200)")
			private String cangkuValue;
		/**
		* 到期时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="到期时间",type="timestamp")
		private Date daoqiTime;
		/**
		* 商品介绍
		*/

		@ColumnInfo(comment="商品介绍",type="text")
		private String shangpinContent;
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
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ShangpinxiaoshouView() {

	}

	public ShangpinxiaoshouView(ShangpinxiaoshouEntity shangpinxiaoshouEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinxiaoshouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 钱款结清的值
	*/
	public String getJieqingValue() {
		return jieqingValue;
	}
	/**
	* 设置： 钱款结清的值
	*/
	public void setJieqingValue(String jieqingValue) {
		this.jieqingValue = jieqingValue;
	}


	//级联表的get和set 客户
		/**
		* 获取：客户 的 销售人员
		*/
		public Integer getKehuXiaoshourenyuanId() {
			return kehuXiaoshourenyuanId;
		}
		/**
		* 设置：客户 的 销售人员
		*/
		public void setKehuXiaoshourenyuanId(Integer kehuXiaoshourenyuanId) {
			this.kehuXiaoshourenyuanId = kehuXiaoshourenyuanId;
		}

		/**
		* 获取： 客户编号
		*/
		public String getKehuUuidNumber() {
			return kehuUuidNumber;
		}
		/**
		* 设置： 客户编号
		*/
		public void setKehuUuidNumber(String kehuUuidNumber) {
			this.kehuUuidNumber = kehuUuidNumber;
		}

		/**
		* 获取： 客户姓名
		*/
		public String getKehuName() {
			return kehuName;
		}
		/**
		* 设置： 客户姓名
		*/
		public void setKehuName(String kehuName) {
			this.kehuName = kehuName;
		}

		/**
		* 获取： 客户手机号
		*/
		public String getKehuPhone() {
			return kehuPhone;
		}
		/**
		* 设置： 客户手机号
		*/
		public void setKehuPhone(String kehuPhone) {
			this.kehuPhone = kehuPhone;
		}

		/**
		* 获取： 客户身份证号
		*/
		public String getKehuIdNumber() {
			return kehuIdNumber;
		}
		/**
		* 设置： 客户身份证号
		*/
		public void setKehuIdNumber(String kehuIdNumber) {
			this.kehuIdNumber = kehuIdNumber;
		}

		/**
		* 获取： 客户照片
		*/
		public String getKehuPhoto() {
			return kehuPhoto;
		}
		/**
		* 设置： 客户照片
		*/
		public void setKehuPhoto(String kehuPhoto) {
			this.kehuPhoto = kehuPhoto;
		}

		/**
		* 获取： 客户住址
		*/
		public String getKehuZhuzhi() {
			return kehuZhuzhi;
		}
		/**
		* 设置： 客户住址
		*/
		public void setKehuZhuzhi(String kehuZhuzhi) {
			this.kehuZhuzhi = kehuZhuzhi;
		}
		/**
		* 获取： 客户来源
		*/
		public Integer getLaiyuanTypes() {
			return laiyuanTypes;
		}
		/**
		* 设置： 客户来源
		*/
		public void setLaiyuanTypes(Integer laiyuanTypes) {
			this.laiyuanTypes = laiyuanTypes;
		}


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

		/**
		* 获取： 年龄
		*/
		public Integer getAge() {
			return age;
		}
		/**
		* 设置： 年龄
		*/
		public void setAge(Integer age) {
			this.age = age;
		}

		/**
		* 获取： 客户邮箱
		*/
		public String getKehuEmail() {
			return kehuEmail;
		}
		/**
		* 设置： 客户邮箱
		*/
		public void setKehuEmail(String kehuEmail) {
			this.kehuEmail = kehuEmail;
		}

		/**
		* 获取： 客户备注
		*/
		public String getKehuContent() {
			return kehuContent;
		}
		/**
		* 设置： 客户备注
		*/
		public void setKehuContent(String kehuContent) {
			this.kehuContent = kehuContent;
		}
	//级联表的get和set 商品

		/**
		* 获取： 商品编号
		*/
		public String getShangpinUuidNumber() {
			return shangpinUuidNumber;
		}
		/**
		* 设置： 商品编号
		*/
		public void setShangpinUuidNumber(String shangpinUuidNumber) {
			this.shangpinUuidNumber = shangpinUuidNumber;
		}

		/**
		* 获取： 商品名称
		*/
		public String getShangpinName() {
			return shangpinName;
		}
		/**
		* 设置： 商品名称
		*/
		public void setShangpinName(String shangpinName) {
			this.shangpinName = shangpinName;
		}

		/**
		* 获取： 商品照片
		*/
		public String getShangpinPhoto() {
			return shangpinPhoto;
		}
		/**
		* 设置： 商品照片
		*/
		public void setShangpinPhoto(String shangpinPhoto) {
			this.shangpinPhoto = shangpinPhoto;
		}

		/**
		* 获取： 单位
		*/
		public String getShangpinDanwei() {
			return shangpinDanwei;
		}
		/**
		* 设置： 单位
		*/
		public void setShangpinDanwei(String shangpinDanwei) {
			this.shangpinDanwei = shangpinDanwei;
		}
		/**
		* 获取： 商品类型
		*/
		public Integer getShangpinTypes() {
			return shangpinTypes;
		}
		/**
		* 设置： 商品类型
		*/
		public void setShangpinTypes(Integer shangpinTypes) {
			this.shangpinTypes = shangpinTypes;
		}


			/**
			* 获取： 商品类型的值
			*/
			public String getShangpinValue() {
				return shangpinValue;
			}
			/**
			* 设置： 商品类型的值
			*/
			public void setShangpinValue(String shangpinValue) {
				this.shangpinValue = shangpinValue;
			}

		/**
		* 获取： 商品库存
		*/
		public Integer getShangpinKucunNumber() {
			return shangpinKucunNumber;
		}
		/**
		* 设置： 商品库存
		*/
		public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
			this.shangpinKucunNumber = shangpinKucunNumber;
		}

		/**
		* 获取： 进价
		*/
		public Double getShangpinNewMoney() {
			return shangpinNewMoney;
		}
		/**
		* 设置： 进价
		*/
		public void setShangpinNewMoney(Double shangpinNewMoney) {
			this.shangpinNewMoney = shangpinNewMoney;
		}

		/**
		* 获取： 售价
		*/
		public Double getShangpinOldMoney() {
			return shangpinOldMoney;
		}
		/**
		* 设置： 售价
		*/
		public void setShangpinOldMoney(Double shangpinOldMoney) {
			this.shangpinOldMoney = shangpinOldMoney;
		}
		/**
		* 获取： 仓库
		*/
		public Integer getCangkuTypes() {
			return cangkuTypes;
		}
		/**
		* 设置： 仓库
		*/
		public void setCangkuTypes(Integer cangkuTypes) {
			this.cangkuTypes = cangkuTypes;
		}


			/**
			* 获取： 仓库的值
			*/
			public String getCangkuValue() {
				return cangkuValue;
			}
			/**
			* 设置： 仓库的值
			*/
			public void setCangkuValue(String cangkuValue) {
				this.cangkuValue = cangkuValue;
			}

		/**
		* 获取： 到期时间
		*/
		public Date getDaoqiTime() {
			return daoqiTime;
		}
		/**
		* 设置： 到期时间
		*/
		public void setDaoqiTime(Date daoqiTime) {
			this.daoqiTime = daoqiTime;
		}

		/**
		* 获取： 商品介绍
		*/
		public String getShangpinContent() {
			return shangpinContent;
		}
		/**
		* 设置： 商品介绍
		*/
		public void setShangpinContent(String shangpinContent) {
			this.shangpinContent = shangpinContent;
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
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ShangpinxiaoshouView{" +
			", jieqingValue=" + jieqingValue +
			", shangpinUuidNumber=" + shangpinUuidNumber +
			", shangpinName=" + shangpinName +
			", shangpinPhoto=" + shangpinPhoto +
			", shangpinDanwei=" + shangpinDanwei +
			", shangpinKucunNumber=" + shangpinKucunNumber +
			", shangpinNewMoney=" + shangpinNewMoney +
			", shangpinOldMoney=" + shangpinOldMoney +
			", daoqiTime=" + DateUtil.convertString(daoqiTime,"yyyy-MM-dd") +
			", shangpinContent=" + shangpinContent +
			", kehuUuidNumber=" + kehuUuidNumber +
			", kehuName=" + kehuName +
			", kehuPhone=" + kehuPhone +
			", kehuIdNumber=" + kehuIdNumber +
			", kehuPhoto=" + kehuPhoto +
			", kehuZhuzhi=" + kehuZhuzhi +
			", age=" + age +
			", kehuEmail=" + kehuEmail +
			", kehuContent=" + kehuContent +
			", xiaoshourenyuanName=" + xiaoshourenyuanName +
			", xiaoshourenyuanPhone=" + xiaoshourenyuanPhone +
			", xiaoshourenyuanIdNumber=" + xiaoshourenyuanIdNumber +
			", xiaoshourenyuanPhoto=" + xiaoshourenyuanPhoto +
			", xiaoshourenyuanZhuzhi=" + xiaoshourenyuanZhuzhi +
			", xiaoshourenyuanEmail=" + xiaoshourenyuanEmail +
			"} " + super.toString();
	}
}
