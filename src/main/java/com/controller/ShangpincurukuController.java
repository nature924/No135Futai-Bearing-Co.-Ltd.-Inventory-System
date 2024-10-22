
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
 * 商品出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shangpincuruku")
public class ShangpincurukuController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpincurukuController.class);

    private static final String TABLE_NAME = "shangpincuruku";

    @Autowired
    private ShangpincurukuService shangpincurukuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private ShangpinService shangpinService;
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
        PageUtils page = shangpincurukuService.queryPage(params);

        //字典表数据转换
        List<ShangpincurukuView> list =(List<ShangpincurukuView>)page.getList();
        for(ShangpincurukuView c:list){
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
        ShangpincurukuEntity shangpincuruku = shangpincurukuService.selectById(id);
        if(shangpincuruku !=null){
            //entity转view
            ShangpincurukuView view = new ShangpincurukuView();
            BeanUtils.copyProperties( shangpincuruku , view );//把实体数据重构到view中
            //级联表 商品
            //级联表
            ShangpinEntity shangpin = shangpinService.selectById(shangpincuruku.getShangpinId());
            if(shangpin != null){
            BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "cangkurenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangpinId(shangpin.getId());
            }
            //级联表 仓库人员
            //级联表
            CangkurenyuanEntity cangkurenyuan = cangkurenyuanService.selectById(shangpincuruku.getCangkurenyuanId());
            if(cangkurenyuan != null){
            BeanUtils.copyProperties( cangkurenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "cangkurenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setCangkurenyuanId(cangkurenyuan.getId());
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
    public R save(@RequestBody ShangpincurukuEntity shangpincuruku, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpincuruku:{}",this.getClass().getName(),shangpincuruku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("仓库人员".equals(role))
            shangpincuruku.setCangkurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShangpincurukuEntity> queryWrapper = new EntityWrapper<ShangpincurukuEntity>()
            .eq("shangpin_id", shangpincuruku.getShangpinId())
            .eq("cangkurenyuan_id", shangpincuruku.getCangkurenyuanId())
            .eq("shangpincuruku_name", shangpincuruku.getShangpincurukuName())
            .eq("shangpincuruku_types", shangpincuruku.getShangpincurukuTypes())
            .eq("caozuo_number", shangpincuruku.getCaozuoNumber())
            .eq("jieqing_types", shangpincuruku.getJieqingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpincurukuEntity shangpincurukuEntity = shangpincurukuService.selectOne(queryWrapper);
        if(shangpincurukuEntity==null){

            ShangpinEntity shangpinEntity = shangpinService.selectById(shangpincuruku.getShangpinId());
            if(shangpinEntity == null)
                return R.error("查不到商品");
            if(shangpincuruku.getShangpincurukuTypes()==1){//入库
                shangpinEntity.setShangpinKucunNumber(shangpinEntity.getShangpinKucunNumber()+shangpincuruku.getCaozuoNumber());
            }else if(shangpincuruku.getShangpincurukuTypes()==2){//出库
                int balance = shangpinEntity.getShangpinKucunNumber() - shangpincuruku.getCaozuoNumber();
                if(balance<0)
                    return R.error("出库数量大于库存数量");
                shangpinEntity.setShangpinKucunNumber(balance);
            }else{
                return R.error("出入库类型不正确,请核实");
            }
            shangpinService.updateById(shangpinEntity);

            shangpincuruku.setInsertTime(new Date());
            shangpincuruku.setCreateTime(new Date());
            shangpincurukuService.insert(shangpincuruku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpincurukuEntity shangpincuruku, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shangpincuruku:{}",this.getClass().getName(),shangpincuruku.toString());
        ShangpincurukuEntity oldShangpincurukuEntity = shangpincurukuService.selectById(shangpincuruku.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("仓库人员".equals(role))
//            shangpincuruku.setCangkurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShangpincurukuEntity> queryWrapper = new EntityWrapper<ShangpincurukuEntity>()
            .notIn("id",shangpincuruku.getId())
            .andNew()
            .eq("shangpin_id", shangpincuruku.getShangpinId())
            .eq("cangkurenyuan_id", shangpincuruku.getCangkurenyuanId())
            .eq("shangpincuruku_name", shangpincuruku.getShangpincurukuName())
            .eq("shangpincuruku_types", shangpincuruku.getShangpincurukuTypes())
            .eq("caozuo_number", shangpincuruku.getCaozuoNumber())
            .eq("jieqing_types", shangpincuruku.getJieqingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpincurukuEntity shangpincurukuEntity = shangpincurukuService.selectOne(queryWrapper);
        if(shangpincurukuEntity==null){
            shangpincurukuService.updateById(shangpincuruku);//根据id更新
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
        List<ShangpincurukuEntity> oldShangpincurukuList =shangpincurukuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shangpincurukuService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShangpincurukuEntity> shangpincurukuList = new ArrayList<>();//上传的东西
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
                            ShangpincurukuEntity shangpincurukuEntity = new ShangpincurukuEntity();
//                            shangpincurukuEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            shangpincurukuEntity.setCangkurenyuanId(Integer.valueOf(data.get(0)));   //仓库人员 要改的
//                            shangpincurukuEntity.setShangpincurukuUuidNumber(data.get(0));                    //出入库编号 要改的
//                            shangpincurukuEntity.setShangpincurukuName(data.get(0));                    //出入库标题 要改的
//                            shangpincurukuEntity.setShangpincurukuTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            shangpincurukuEntity.setCaozuoNumber(Integer.valueOf(data.get(0)));   //操作数量 要改的
//                            shangpincurukuEntity.setJieqingTypes(Integer.valueOf(data.get(0)));   //钱款结清 要改的
//                            shangpincurukuEntity.setShangpincurukuContent("");//详情和图片
//                            shangpincurukuEntity.setInsertTime(date);//时间
//                            shangpincurukuEntity.setCreateTime(date);//时间
                            shangpincurukuList.add(shangpincurukuEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库编号
                                if(seachFields.containsKey("shangpincurukuUuidNumber")){
                                    List<String> shangpincurukuUuidNumber = seachFields.get("shangpincurukuUuidNumber");
                                    shangpincurukuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shangpincurukuUuidNumber = new ArrayList<>();
                                    shangpincurukuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shangpincurukuUuidNumber",shangpincurukuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库编号
                        List<ShangpincurukuEntity> shangpincurukuEntities_shangpincurukuUuidNumber = shangpincurukuService.selectList(new EntityWrapper<ShangpincurukuEntity>().in("shangpincuruku_uuid_number", seachFields.get("shangpincurukuUuidNumber")));
                        if(shangpincurukuEntities_shangpincurukuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShangpincurukuEntity s:shangpincurukuEntities_shangpincurukuUuidNumber){
                                repeatFields.add(s.getShangpincurukuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shangpincurukuService.insertBatch(shangpincurukuList);
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
