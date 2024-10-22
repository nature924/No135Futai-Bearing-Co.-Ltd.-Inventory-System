package com.dao;

import com.entity.XiaoshourenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshourenyuanView;

/**
 * 销售人员 Dao 接口
 *
 * @author 
 */
public interface XiaoshourenyuanDao extends BaseMapper<XiaoshourenyuanEntity> {

   List<XiaoshourenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
