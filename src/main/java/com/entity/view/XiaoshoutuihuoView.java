package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XiaoshoutuihuoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品退货
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xiaoshoutuihuo")
public class XiaoshoutuihuoView extends XiaoshoutuihuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 商品销售
															 
		/**
		* 商品销售 的 销售人员
		*/
		@ColumnInfo(comment="销售人员",type="int(11)")
		private Integer shangpinxiaoshouXiaoshourenyuanId;
		/**
		* 销售编号
		*/

		@ColumnInfo(comment="销售编号",type="varchar(200)")
		private String shangpinxiaoshouUuidNumber;
		/**
		* 销售标题
		*/

		@ColumnInfo(comment="销售标题",type="varchar(200)")
		private String shangpinxiaoshouName;
		/**
		* 销售数量
		*/

		@ColumnInfo(comment="销售数量",type="int(11)")
		private Integer caozuoNumber;
		/**
		* 钱款结清
		*/
		@ColumnInfo(comment="钱款结清",type="int(11)")
		private Integer jieqingTypes;
			/**
			* 钱款结清的值
			*/
			@ColumnInfo(comment="钱款结清的字典表值",type="varchar(200)")
			private String jieqingValue;
		/**
		* 销售金额
		*/
		@ColumnInfo(comment="销售金额",type="decimal(10,2)")
		private Double huafeiMoney;
		/**
		* 销售时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="销售时间",type="timestamp")
		private Date xiaoshouTime;
		/**
		* 备注
		*/

		@ColumnInfo(comment="备注",type="text")
		private String shangpinxiaoshouContent;



	public XiaoshoutuihuoView() {

	}

	public XiaoshoutuihuoView(XiaoshoutuihuoEntity xiaoshoutuihuoEntity) {
		try {
			BeanUtils.copyProperties(this, xiaoshoutuihuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 商品销售
		/**
		* 获取：商品销售 的 销售人员
		*/
		public Integer getShangpinxiaoshouXiaoshourenyuanId() {
			return shangpinxiaoshouXiaoshourenyuanId;
		}
		/**
		* 设置：商品销售 的 销售人员
		*/
		public void setShangpinxiaoshouXiaoshourenyuanId(Integer shangpinxiaoshouXiaoshourenyuanId) {
			this.shangpinxiaoshouXiaoshourenyuanId = shangpinxiaoshouXiaoshourenyuanId;
		}

		/**
		* 获取： 销售编号
		*/
		public String getShangpinxiaoshouUuidNumber() {
			return shangpinxiaoshouUuidNumber;
		}
		/**
		* 设置： 销售编号
		*/
		public void setShangpinxiaoshouUuidNumber(String shangpinxiaoshouUuidNumber) {
			this.shangpinxiaoshouUuidNumber = shangpinxiaoshouUuidNumber;
		}

		/**
		* 获取： 销售标题
		*/
		public String getShangpinxiaoshouName() {
			return shangpinxiaoshouName;
		}
		/**
		* 设置： 销售标题
		*/
		public void setShangpinxiaoshouName(String shangpinxiaoshouName) {
			this.shangpinxiaoshouName = shangpinxiaoshouName;
		}

		/**
		* 获取： 销售数量
		*/
		public Integer getCaozuoNumber() {
			return caozuoNumber;
		}
		/**
		* 设置： 销售数量
		*/
		public void setCaozuoNumber(Integer caozuoNumber) {
			this.caozuoNumber = caozuoNumber;
		}
		/**
		* 获取： 钱款结清
		*/
		public Integer getJieqingTypes() {
			return jieqingTypes;
		}
		/**
		* 设置： 钱款结清
		*/
		public void setJieqingTypes(Integer jieqingTypes) {
			this.jieqingTypes = jieqingTypes;
		}


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

		/**
		* 获取： 销售金额
		*/
		public Double getHuafeiMoney() {
			return huafeiMoney;
		}
		/**
		* 设置： 销售金额
		*/
		public void setHuafeiMoney(Double huafeiMoney) {
			this.huafeiMoney = huafeiMoney;
		}

		/**
		* 获取： 销售时间
		*/
		public Date getXiaoshouTime() {
			return xiaoshouTime;
		}
		/**
		* 设置： 销售时间
		*/
		public void setXiaoshouTime(Date xiaoshouTime) {
			this.xiaoshouTime = xiaoshouTime;
		}

		/**
		* 获取： 备注
		*/
		public String getShangpinxiaoshouContent() {
			return shangpinxiaoshouContent;
		}
		/**
		* 设置： 备注
		*/
		public void setShangpinxiaoshouContent(String shangpinxiaoshouContent) {
			this.shangpinxiaoshouContent = shangpinxiaoshouContent;
		}


	@Override
	public String toString() {
		return "XiaoshoutuihuoView{" +
			", shangpinxiaoshouUuidNumber=" + shangpinxiaoshouUuidNumber +
			", shangpinxiaoshouName=" + shangpinxiaoshouName +
			", caozuoNumber=" + caozuoNumber +
			", huafeiMoney=" + huafeiMoney +
			", xiaoshouTime=" + DateUtil.convertString(xiaoshouTime,"yyyy-MM-dd") +
			", shangpinxiaoshouContent=" + shangpinxiaoshouContent +
			"} " + super.toString();
	}
}
