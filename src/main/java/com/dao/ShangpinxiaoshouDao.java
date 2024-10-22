package com.dao;

import com.entity.ShangpinxiaoshouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinxiaoshouView;

/**
 * 商品销售 Dao 接口
 *
 * @author 
 */
public interface ShangpinxiaoshouDao extends BaseMapper<ShangpinxiaoshouEntity> {

   List<ShangpinxiaoshouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
