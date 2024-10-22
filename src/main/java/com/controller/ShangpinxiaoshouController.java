
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
 * 商品销售
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shangpinxiaoshou")
public class ShangpinxiaoshouController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpinxiaoshouController.class);

    private static final String TABLE_NAME = "shangpinxiaoshou";

    @Autowired
    private ShangpinxiaoshouService shangpinxiaoshouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private ShangpinService shangpinService;
    @Autowired
    private KehuService kehuService;
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
        PageUtils page = shangpinxiaoshouService.queryPage(params);

        //字典表数据转换
        List<ShangpinxiaoshouView> list =(List<ShangpinxiaoshouView>)page.getList();
        for(ShangpinxiaoshouView c:list){
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
        ShangpinxiaoshouEntity shangpinxiaoshou = shangpinxiaoshouService.selectById(id);
        if(shangpinxiaoshou !=null){
            //entity转view
            ShangpinxiaoshouView view = new ShangpinxiaoshouView();
            BeanUtils.copyProperties( shangpinxiaoshou , view );//把实体数据重构到view中
            //级联表 商品
            //级联表
            ShangpinEntity shangpin = shangpinService.selectById(shangpinxiaoshou.getShangpinId());
            if(shangpin != null){
            BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xiaoshourenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangpinId(shangpin.getId());
            }
            //级联表 客户
            //级联表
            KehuEntity kehu = kehuService.selectById(shangpinxiaoshou.getKehuId());
            if(kehu != null){
            BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xiaoshourenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKehuId(kehu.getId());
            }
            //级联表 销售人员
            //级联表
            XiaoshourenyuanEntity xiaoshourenyuan = xiaoshourenyuanService.selectById(shangpinxiaoshou.getXiaoshourenyuanId());
            if(xiaoshourenyuan != null){
            BeanUtils.copyProperties( xiaoshourenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xiaoshourenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiaoshourenyuanId(xiaoshourenyuan.getId());
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
    public R save(@RequestBody ShangpinxiaoshouEntity shangpinxiaoshou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpinxiaoshou:{}",this.getClass().getName(),shangpinxiaoshou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("销售人员".equals(role))
            shangpinxiaoshou.setXiaoshourenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShangpinxiaoshouEntity> queryWrapper = new EntityWrapper<ShangpinxiaoshouEntity>()
            .eq("shangpin_id", shangpinxiaoshou.getShangpinId())
            .eq("kehu_id", shangpinxiaoshou.getKehuId())
            .eq("xiaoshourenyuan_id", shangpinxiaoshou.getXiaoshourenyuanId())
            .eq("shangpinxiaoshou_name", shangpinxiaoshou.getShangpinxiaoshouName())
            .eq("caozuo_number", shangpinxiaoshou.getCaozuoNumber())
            .eq("jieqing_types", shangpinxiaoshou.getJieqingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinxiaoshouEntity shangpinxiaoshouEntity = shangpinxiaoshouService.selectOne(queryWrapper);
        if(shangpinxiaoshouEntity==null){

            shangpinxiaoshou.setInsertTime(new Date());
            shangpinxiaoshou.setCreateTime(new Date());

            ShangpinEntity shangpin = shangpinService.selectById(shangpinxiaoshou.getShangpinId());
            if(shangpin== null)
                return R.error("查不到商品");

            int balance = shangpin.getShangpinKucunNumber() - shangpinxiaoshou.getCaozuoNumber();
            if(balance<0)
                return R.error("销售数量不能大于库存数量");
            shangpin.setShangpinKucunNumber(balance);
            shangpinService.updateById(shangpin);

            shangpinxiaoshou.setHuafeiMoney(shangpinxiaoshou.getCaozuoNumber()*shangpin.getShangpinOldMoney());
            shangpinxiaoshouService.insert(shangpinxiaoshou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinxiaoshouEntity shangpinxiaoshou, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shangpinxiaoshou:{}",this.getClass().getName(),shangpinxiaoshou.toString());
        ShangpinxiaoshouEntity oldShangpinxiaoshouEntity = shangpinxiaoshouService.selectById(shangpinxiaoshou.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("销售人员".equals(role))
//            shangpinxiaoshou.setXiaoshourenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShangpinxiaoshouEntity> queryWrapper = new EntityWrapper<ShangpinxiaoshouEntity>()
            .notIn("id",shangpinxiaoshou.getId())
            .andNew()
            .eq("shangpin_id", shangpinxiaoshou.getShangpinId())
            .eq("kehu_id", shangpinxiaoshou.getKehuId())
            .eq("xiaoshourenyuan_id", shangpinxiaoshou.getXiaoshourenyuanId())
            .eq("shangpinxiaoshou_name", shangpinxiaoshou.getShangpinxiaoshouName())
            .eq("caozuo_number", shangpinxiaoshou.getCaozuoNumber())
            .eq("jieqing_types", shangpinxiaoshou.getJieqingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinxiaoshouEntity shangpinxiaoshouEntity = shangpinxiaoshouService.selectOne(queryWrapper);
        if(shangpinxiaoshouEntity==null){
            shangpinxiaoshouService.updateById(shangpinxiaoshou);//根据id更新
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
        List<ShangpinxiaoshouEntity> oldShangpinxiaoshouList =shangpinxiaoshouService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shangpinxiaoshouService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShangpinxiaoshouEntity> shangpinxiaoshouList = new ArrayList<>();//上传的东西
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
                            ShangpinxiaoshouEntity shangpinxiaoshouEntity = new ShangpinxiaoshouEntity();
//                            shangpinxiaoshouEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            shangpinxiaoshouEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            shangpinxiaoshouEntity.setXiaoshourenyuanId(Integer.valueOf(data.get(0)));   //销售人员 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouUuidNumber(data.get(0));                    //销售编号 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouName(data.get(0));                    //销售标题 要改的
//                            shangpinxiaoshouEntity.setCaozuoNumber(Integer.valueOf(data.get(0)));   //销售数量 要改的
//                            shangpinxiaoshouEntity.setJieqingTypes(Integer.valueOf(data.get(0)));   //钱款结清 要改的
//                            shangpinxiaoshouEntity.setHuafeiMoney(data.get(0));                    //销售金额 要改的
//                            shangpinxiaoshouEntity.setXiaoshouTime(sdf.parse(data.get(0)));          //销售时间 要改的
//                            shangpinxiaoshouEntity.setShangpinxiaoshouContent("");//详情和图片
//                            shangpinxiaoshouEntity.setInsertTime(date);//时间
//                            shangpinxiaoshouEntity.setCreateTime(date);//时间
                            shangpinxiaoshouList.add(shangpinxiaoshouEntity);


                            //把要查询是否重复的字段放入map中
                                //销售编号
                                if(seachFields.containsKey("shangpinxiaoshouUuidNumber")){
                                    List<String> shangpinxiaoshouUuidNumber = seachFields.get("shangpinxiaoshouUuidNumber");
                                    shangpinxiaoshouUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shangpinxiaoshouUuidNumber = new ArrayList<>();
                                    shangpinxiaoshouUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shangpinxiaoshouUuidNumber",shangpinxiaoshouUuidNumber);
                                }
                        }

                        //查询是否重复
                         //销售编号
                        List<ShangpinxiaoshouEntity> shangpinxiaoshouEntities_shangpinxiaoshouUuidNumber = shangpinxiaoshouService.selectList(new EntityWrapper<ShangpinxiaoshouEntity>().in("shangpinxiaoshou_uuid_number", seachFields.get("shangpinxiaoshouUuidNumber")));
                        if(shangpinxiaoshouEntities_shangpinxiaoshouUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShangpinxiaoshouEntity s:shangpinxiaoshouEntities_shangpinxiaoshouUuidNumber){
                                repeatFields.add(s.getShangpinxiaoshouUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [销售编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shangpinxiaoshouService.insertBatch(shangpinxiaoshouList);
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
