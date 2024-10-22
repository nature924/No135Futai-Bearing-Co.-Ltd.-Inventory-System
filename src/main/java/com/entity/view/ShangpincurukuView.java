package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpincurukuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品出入库
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpincuruku")
public class ShangpincurukuView extends ShangpincurukuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String shangpincurukuValue;
	/**
	* 钱款结清的值
	*/
	@ColumnInfo(comment="钱款结清的字典表值",type="varchar(200)")
	private String jieqingValue;

	//级联表 仓库人员
		/**
		* 仓库人员姓名
		*/

		@ColumnInfo(comment="仓库人员姓名",type="varchar(200)")
		private String cangkurenyuanName;
		/**
		* 仓库人员手机号
		*/

		@ColumnInfo(comment="仓库人员手机号",type="varchar(200)")
		private String cangkurenyuanPhone;
		/**
		* 仓库人员身份证号
		*/

		@ColumnInfo(comment="仓库人员身份证号",type="varchar(200)")
		private String cangkurenyuanIdNumber;
		/**
		* 仓库人员照片
		*/

		@ColumnInfo(comment="仓库人员照片",type="varchar(200)")
		private String cangkurenyuanPhoto;
		/**
		* 现住址
		*/

		@ColumnInfo(comment="现住址",type="varchar(200)")
		private String xiaoshourenyuanZhuzhi;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String cangkurenyuanEmail;
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



	public ShangpincurukuView() {

	}

	public ShangpincurukuView(ShangpincurukuEntity shangpincurukuEntity) {
		try {
			BeanUtils.copyProperties(this, shangpincurukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getShangpincurukuValue() {
		return shangpincurukuValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setShangpincurukuValue(String shangpincurukuValue) {
		this.shangpincurukuValue = shangpincurukuValue;
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


	//级联表的get和set 仓库人员

		/**
		* 获取： 仓库人员姓名
		*/
		public String getCangkurenyuanName() {
			return cangkurenyuanName;
		}
		/**
		* 设置： 仓库人员姓名
		*/
		public void setCangkurenyuanName(String cangkurenyuanName) {
			this.cangkurenyuanName = cangkurenyuanName;
		}

		/**
		* 获取： 仓库人员手机号
		*/
		public String getCangkurenyuanPhone() {
			return cangkurenyuanPhone;
		}
		/**
		* 设置： 仓库人员手机号
		*/
		public void setCangkurenyuanPhone(String cangkurenyuanPhone) {
			this.cangkurenyuanPhone = cangkurenyuanPhone;
		}

		/**
		* 获取： 仓库人员身份证号
		*/
		public String getCangkurenyuanIdNumber() {
			return cangkurenyuanIdNumber;
		}
		/**
		* 设置： 仓库人员身份证号
		*/
		public void setCangkurenyuanIdNumber(String cangkurenyuanIdNumber) {
			this.cangkurenyuanIdNumber = cangkurenyuanIdNumber;
		}

		/**
		* 获取： 仓库人员照片
		*/
		public String getCangkurenyuanPhoto() {
			return cangkurenyuanPhoto;
		}
		/**
		* 设置： 仓库人员照片
		*/
		public void setCangkurenyuanPhoto(String cangkurenyuanPhoto) {
			this.cangkurenyuanPhoto = cangkurenyuanPhoto;
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
		public String getCangkurenyuanEmail() {
			return cangkurenyuanEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setCangkurenyuanEmail(String cangkurenyuanEmail) {
			this.cangkurenyuanEmail = cangkurenyuanEmail;
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


	@Override
	public String toString() {
		return "ShangpincurukuView{" +
			", shangpincurukuValue=" + shangpincurukuValue +
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
			", cangkurenyuanName=" + cangkurenyuanName +
			", cangkurenyuanPhone=" + cangkurenyuanPhone +
			", cangkurenyuanIdNumber=" + cangkurenyuanIdNumber +
			", cangkurenyuanPhoto=" + cangkurenyuanPhoto +
			", xiaoshourenyuanZhuzhi=" + xiaoshourenyuanZhuzhi +
			", cangkurenyuanEmail=" + cangkurenyuanEmail +
			"} " + super.toString();
	}
}
