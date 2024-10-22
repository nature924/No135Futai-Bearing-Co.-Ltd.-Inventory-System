package com.dao;

import com.entity.CangkurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CangkurenyuanView;

/**
 * 仓库人员 Dao 接口
 *
 * @author 
 */
public interface CangkurenyuanDao extends BaseMapper<CangkurenyuanEntity> {

   List<CangkurenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
