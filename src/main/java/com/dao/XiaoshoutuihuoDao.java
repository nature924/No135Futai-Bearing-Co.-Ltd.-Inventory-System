package com.dao;

import com.entity.XiaoshoutuihuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshoutuihuoView;

/**
 * 商品退货 Dao 接口
 *
 * @author 
 */
public interface XiaoshoutuihuoDao extends BaseMapper<XiaoshoutuihuoEntity> {

   List<XiaoshoutuihuoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
