
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
 * 销售人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoshourenyuan")
public class XiaoshourenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoshourenyuanController.class);

    private static final String TABLE_NAME = "xiaoshourenyuan";

    @Autowired
    private XiaoshourenyuanService xiaoshourenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private CangkurenyuanService cangkurenyuanService;


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
        PageUtils page = xiaoshourenyuanService.queryPage(params);

        //字典表数据转换
        List<XiaoshourenyuanView> list =(List<XiaoshourenyuanView>)page.getList();
        for(XiaoshourenyuanView c:list){
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
        XiaoshourenyuanEntity xiaoshourenyuan = xiaoshourenyuanService.selectById(id);
        if(xiaoshourenyuan !=null){
            //entity转view
            XiaoshourenyuanView view = new XiaoshourenyuanView();
            BeanUtils.copyProperties( xiaoshourenyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody XiaoshourenyuanEntity xiaoshourenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoshourenyuan:{}",this.getClass().getName(),xiaoshourenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiaoshourenyuanEntity> queryWrapper = new EntityWrapper<XiaoshourenyuanEntity>()
            .eq("username", xiaoshourenyuan.getUsername())
            .or()
            .eq("xiaoshourenyuan_phone", xiaoshourenyuan.getXiaoshourenyuanPhone())
            .or()
            .eq("xiaoshourenyuan_id_number", xiaoshourenyuan.getXiaoshourenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshourenyuanEntity xiaoshourenyuanEntity = xiaoshourenyuanService.selectOne(queryWrapper);
        if(xiaoshourenyuanEntity==null){
            xiaoshourenyuan.setCreateTime(new Date());
            xiaoshourenyuan.setPassword("123456");
            xiaoshourenyuanService.insert(xiaoshourenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者销售人员手机号或者销售人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoshourenyuanEntity xiaoshourenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xiaoshourenyuan:{}",this.getClass().getName(),xiaoshourenyuan.toString());
        XiaoshourenyuanEntity oldXiaoshourenyuanEntity = xiaoshourenyuanService.selectById(xiaoshourenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XiaoshourenyuanEntity> queryWrapper = new EntityWrapper<XiaoshourenyuanEntity>()
            .notIn("id",xiaoshourenyuan.getId())
            .andNew()
            .eq("username", xiaoshourenyuan.getUsername())
            .or()
            .eq("xiaoshourenyuan_phone", xiaoshourenyuan.getXiaoshourenyuanPhone())
            .or()
            .eq("xiaoshourenyuan_id_number", xiaoshourenyuan.getXiaoshourenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshourenyuanEntity xiaoshourenyuanEntity = xiaoshourenyuanService.selectOne(queryWrapper);
        if("".equals(xiaoshourenyuan.getXiaoshourenyuanPhoto()) || "null".equals(xiaoshourenyuan.getXiaoshourenyuanPhoto())){
                xiaoshourenyuan.setXiaoshourenyuanPhoto(null);
        }
        if(xiaoshourenyuanEntity==null){
            xiaoshourenyuanService.updateById(xiaoshourenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者销售人员手机号或者销售人员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XiaoshourenyuanEntity> oldXiaoshourenyuanList =xiaoshourenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xiaoshourenyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<XiaoshourenyuanEntity> xiaoshourenyuanList = new ArrayList<>();//上传的东西
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
                            XiaoshourenyuanEntity xiaoshourenyuanEntity = new XiaoshourenyuanEntity();
//                            xiaoshourenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xiaoshourenyuanEntity.setPassword("123456");//密码
//                            xiaoshourenyuanEntity.setXiaoshourenyuanName(data.get(0));                    //销售人员姓名 要改的
//                            xiaoshourenyuanEntity.setXiaoshourenyuanPhone(data.get(0));                    //销售人员手机号 要改的
//                            xiaoshourenyuanEntity.setXiaoshourenyuanIdNumber(data.get(0));                    //销售人员身份证号 要改的
//                            xiaoshourenyuanEntity.setXiaoshourenyuanPhoto("");//详情和图片
//                            xiaoshourenyuanEntity.setXiaoshourenyuanZhuzhi(data.get(0));                    //现住址 要改的
//                            xiaoshourenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xiaoshourenyuanEntity.setXiaoshourenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            xiaoshourenyuanEntity.setCreateTime(date);//时间
                            xiaoshourenyuanList.add(xiaoshourenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //销售人员手机号
                                if(seachFields.containsKey("xiaoshourenyuanPhone")){
                                    List<String> xiaoshourenyuanPhone = seachFields.get("xiaoshourenyuanPhone");
                                    xiaoshourenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshourenyuanPhone = new ArrayList<>();
                                    xiaoshourenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("xiaoshourenyuanPhone",xiaoshourenyuanPhone);
                                }
                                //销售人员身份证号
                                if(seachFields.containsKey("xiaoshourenyuanIdNumber")){
                                    List<String> xiaoshourenyuanIdNumber = seachFields.get("xiaoshourenyuanIdNumber");
                                    xiaoshourenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshourenyuanIdNumber = new ArrayList<>();
                                    xiaoshourenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoshourenyuanIdNumber",xiaoshourenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XiaoshourenyuanEntity> xiaoshourenyuanEntities_username = xiaoshourenyuanService.selectList(new EntityWrapper<XiaoshourenyuanEntity>().in("username", seachFields.get("username")));
                        if(xiaoshourenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshourenyuanEntity s:xiaoshourenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //销售人员手机号
                        List<XiaoshourenyuanEntity> xiaoshourenyuanEntities_xiaoshourenyuanPhone = xiaoshourenyuanService.selectList(new EntityWrapper<XiaoshourenyuanEntity>().in("xiaoshourenyuan_phone", seachFields.get("xiaoshourenyuanPhone")));
                        if(xiaoshourenyuanEntities_xiaoshourenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshourenyuanEntity s:xiaoshourenyuanEntities_xiaoshourenyuanPhone){
                                repeatFields.add(s.getXiaoshourenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [销售人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //销售人员身份证号
                        List<XiaoshourenyuanEntity> xiaoshourenyuanEntities_xiaoshourenyuanIdNumber = xiaoshourenyuanService.selectList(new EntityWrapper<XiaoshourenyuanEntity>().in("xiaoshourenyuan_id_number", seachFields.get("xiaoshourenyuanIdNumber")));
                        if(xiaoshourenyuanEntities_xiaoshourenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshourenyuanEntity s:xiaoshourenyuanEntities_xiaoshourenyuanIdNumber){
                                repeatFields.add(s.getXiaoshourenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [销售人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiaoshourenyuanService.insertBatch(xiaoshourenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XiaoshourenyuanEntity xiaoshourenyuan = xiaoshourenyuanService.selectOne(new EntityWrapper<XiaoshourenyuanEntity>().eq("username", username));
        if(xiaoshourenyuan==null || !xiaoshourenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(xiaoshourenyuan.getId(),username, "xiaoshourenyuan", "销售人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","销售人员");
        r.put("username",xiaoshourenyuan.getXiaoshourenyuanName());
        r.put("tableName","xiaoshourenyuan");
        r.put("userId",xiaoshourenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XiaoshourenyuanEntity xiaoshourenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XiaoshourenyuanEntity> queryWrapper = new EntityWrapper<XiaoshourenyuanEntity>()
            .eq("username", xiaoshourenyuan.getUsername())
            .or()
            .eq("xiaoshourenyuan_phone", xiaoshourenyuan.getXiaoshourenyuanPhone())
            .or()
            .eq("xiaoshourenyuan_id_number", xiaoshourenyuan.getXiaoshourenyuanIdNumber())
            ;
        XiaoshourenyuanEntity xiaoshourenyuanEntity = xiaoshourenyuanService.selectOne(queryWrapper);
        if(xiaoshourenyuanEntity != null)
            return R.error("账户或者销售人员手机号或者销售人员身份证号已经被使用");
        xiaoshourenyuan.setCreateTime(new Date());
        xiaoshourenyuanService.insert(xiaoshourenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XiaoshourenyuanEntity xiaoshourenyuan = xiaoshourenyuanService.selectById(id);
        xiaoshourenyuan.setPassword("123456");
        xiaoshourenyuanService.updateById(xiaoshourenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XiaoshourenyuanEntity xiaoshourenyuan = xiaoshourenyuanService.selectOne(new EntityWrapper<XiaoshourenyuanEntity>().eq("username", username));
        if(xiaoshourenyuan!=null){
            xiaoshourenyuan.setPassword("123456");
            boolean b = xiaoshourenyuanService.updateById(xiaoshourenyuan);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXiaoshourenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XiaoshourenyuanEntity xiaoshourenyuan = xiaoshourenyuanService.selectById(id);
        if(xiaoshourenyuan !=null){
            //entity转view
            XiaoshourenyuanView view = new XiaoshourenyuanView();
            BeanUtils.copyProperties( xiaoshourenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}
