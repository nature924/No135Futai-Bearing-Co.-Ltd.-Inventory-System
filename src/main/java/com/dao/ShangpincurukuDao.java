package com.dao;

import com.entity.ShangpincurukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpincurukuView;

/**
 * 商品出入库 Dao 接口
 *
 * @author 
 */
public interface ShangpincurukuDao extends BaseMapper<ShangpincurukuEntity> {

   List<ShangpincurukuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
