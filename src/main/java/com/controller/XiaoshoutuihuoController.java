
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品退货
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoshoutuihuo")
public class XiaoshoutuihuoController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoshoutuihuoController.class);

    private static final String TABLE_NAME = "xiaoshoutuihuo";

    @Autowired
    private XiaoshoutuihuoService xiaoshoutuihuoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private ShangpinService shangpinService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private ShangpinxiaoshouService shangpinxiaoshouService;
    //注册表service
    @Autowired
    private CangkurenyuanService cangkurenyuanService;
    @Autowired
    private XiaoshourenyuanService xiaoshourenyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("仓库人员".equals(role))
            params.put("cangkurenyuanId",request.getSession().getAttribute("userId"));
        else if("销售人员".equals(role))
            params.put("xiaoshourenyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xiaoshoutuihuoService.queryPage(params);

        //字典表数据转换
        List<XiaoshoutuihuoView> list =(List<XiaoshoutuihuoView>)page.getList();
        for(XiaoshoutuihuoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoshoutuihuoEntity xiaoshoutuihuo = xiaoshoutuihuoService.selectById(id);
        if(xiaoshoutuihuo !=null){
            //entity转view
            XiaoshoutuihuoView view = new XiaoshoutuihuoView();
            BeanUtils.copyProperties( xiaoshoutuihuo , view );//把实体数据重构到view中
            //级联表 商品销售
            //级联表
            ShangpinxiaoshouEntity shangpinxiaoshou = shangpinxiaoshouService.selectById(xiaoshoutuihuo.getShangpinxiaoshouId());
            if(shangpinxiaoshou != null){
            BeanUtils.copyProperties( shangpinxiaoshou , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangpinxiaoshouId(shangpinxiaoshou.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoshoutuihuoEntity xiaoshoutuihuo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoshoutuihuo:{}",this.getClass().getName(),xiaoshoutuihuo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiaoshoutuihuoEntity> queryWrapper = new EntityWrapper<XiaoshoutuihuoEntity>()
            .eq("shangpinxiaoshou_id", xiaoshoutuihuo.getShangpinxiaoshouId())
            .eq("caozuo_number", xiaoshoutuihuo.getCaozuoNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshoutuihuoEntity xiaoshoutuihuoEntity = xiaoshoutuihuoService.selectOne(queryWrapper);
        if(xiaoshoutuihuoEntity==null){
            xiaoshoutuihuo.setInsertTime(new Date());
            xiaoshoutuihuo.setCreateTime(new Date());


            ShangpinxiaoshouEntity shangpinxiaoshouEntity = shangpinxiaoshouService.selectById(xiaoshoutuihuo.getShangpinxiaoshouId());
            if(shangpinxiaoshouEntity==null)
                return R.error("查不到销售记录");
            ShangpinEntity shangpinEntity = shangpinService.selectById(shangpinxiaoshouEntity.getShangpinId());
            if(shangpinEntity==null)
                return R.error("查不到所销售的商品");


            int shengyuxiaoshou = shangpinxiaoshouEntity.getCaozuoNumber() - xiaoshoutuihuo.getCaozuoNumber();
            if(shengyuxiaoshou<0){
                return R.error("退货数量不能大于销售数量");
            }
            shangpinxiaoshouEntity.setCaozuoNumber(shengyuxiaoshou);//更改销售数量
            shangpinxiaoshouEntity.setHuafeiMoney(shangpinxiaoshouEntity.getHuafeiMoney()-xiaoshoutuihuo.getTuihuanJine());//更改销售总额
            shangpinEntity.setShangpinKucunNumber(shangpinEntity.getShangpinKucunNumber()+xiaoshoutuihuo.getCaozuoNumber());//增加库存数量

            shangpinService.updateById(shangpinEntity);
            shangpinxiaoshouService.updateById(shangpinxiaoshouEntity);


            xiaoshoutuihuoService.insert(xiaoshoutuihuo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoshoutuihuoEntity xiaoshoutuihuo, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xiaoshoutuihuo:{}",this.getClass().getName(),xiaoshoutuihuo.toString());
        XiaoshoutuihuoEntity oldXiaoshoutuihuoEntity = xiaoshoutuihuoService.selectById(xiaoshoutuihuo.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XiaoshoutuihuoEntity> queryWrapper = new EntityWrapper<XiaoshoutuihuoEntity>()
            .notIn("id",xiaoshoutuihuo.getId())
            .andNew()
            .eq("shangpinxiaoshou_id", xiaoshoutuihuo.getShangpinxiaoshouId())
            .eq("caozuo_number", xiaoshoutuihuo.getCaozuoNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshoutuihuoEntity xiaoshoutuihuoEntity = xiaoshoutuihuoService.selectOne(queryWrapper);
        if(xiaoshoutuihuoEntity==null){
            xiaoshoutuihuoService.updateById(xiaoshoutuihuo);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XiaoshoutuihuoEntity> oldXiaoshoutuihuoList =xiaoshoutuihuoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xiaoshoutuihuoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer cangkurenyuanId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XiaoshoutuihuoEntity> xiaoshoutuihuoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiaoshoutuihuoEntity xiaoshoutuihuoEntity = new XiaoshoutuihuoEntity();
//                            xiaoshoutuihuoEntity.setShangpinxiaoshouId(Integer.valueOf(data.get(0)));   //商品销售 要改的
//                            xiaoshoutuihuoEntity.setXiaoshoutuihuoUuidNumber(data.get(0));                    //退货编号 要改的
//                            xiaoshoutuihuoEntity.setCaozuoNumber(Integer.valueOf(data.get(0)));   //退货数量 要改的
//                            xiaoshoutuihuoEntity.setXiaoshoutuihuoYuanyouContent("");//详情和图片
//                            xiaoshoutuihuoEntity.setTuihuanJine(data.get(0));                    //退还金额 要改的
//                            xiaoshoutuihuoEntity.setTuihuoTime(sdf.parse(data.get(0)));          //退货时间 要改的
//                            xiaoshoutuihuoEntity.setXiaoshoutuihuoContent("");//详情和图片
//                            xiaoshoutuihuoEntity.setInsertTime(date);//时间
//                            xiaoshoutuihuoEntity.setCreateTime(date);//时间
                            xiaoshoutuihuoList.add(xiaoshoutuihuoEntity);


                            //把要查询是否重复的字段放入map中
                                //退货编号
                                if(seachFields.containsKey("xiaoshoutuihuoUuidNumber")){
                                    List<String> xiaoshoutuihuoUuidNumber = seachFields.get("xiaoshoutuihuoUuidNumber");
                                    xiaoshoutuihuoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshoutuihuoUuidNumber = new ArrayList<>();
                                    xiaoshoutuihuoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoshoutuihuoUuidNumber",xiaoshoutuihuoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //退货编号
                        List<XiaoshoutuihuoEntity> xiaoshoutuihuoEntities_xiaoshoutuihuoUuidNumber = xiaoshoutuihuoService.selectList(new EntityWrapper<XiaoshoutuihuoEntity>().in("xiaoshoutuihuo_uuid_number", seachFields.get("xiaoshoutuihuoUuidNumber")));
                        if(xiaoshoutuihuoEntities_xiaoshoutuihuoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshoutuihuoEntity s:xiaoshoutuihuoEntities_xiaoshoutuihuoUuidNumber){
                                repeatFields.add(s.getXiaoshoutuihuoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [退货编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiaoshoutuihuoService.insertBatch(xiaoshoutuihuoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
