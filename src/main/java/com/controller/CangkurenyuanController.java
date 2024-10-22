
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
 * 仓库人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cangkurenyuan")
public class CangkurenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(CangkurenyuanController.class);

    private static final String TABLE_NAME = "cangkurenyuan";

    @Autowired
    private CangkurenyuanService cangkurenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
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
        PageUtils page = cangkurenyuanService.queryPage(params);

        //字典表数据转换
        List<CangkurenyuanView> list =(List<CangkurenyuanView>)page.getList();
        for(CangkurenyuanView c:list){
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
        CangkurenyuanEntity cangkurenyuan = cangkurenyuanService.selectById(id);
        if(cangkurenyuan !=null){
            //entity转view
            CangkurenyuanView view = new CangkurenyuanView();
            BeanUtils.copyProperties( cangkurenyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody CangkurenyuanEntity cangkurenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cangkurenyuan:{}",this.getClass().getName(),cangkurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CangkurenyuanEntity> queryWrapper = new EntityWrapper<CangkurenyuanEntity>()
            .eq("username", cangkurenyuan.getUsername())
            .or()
            .eq("cangkurenyuan_phone", cangkurenyuan.getCangkurenyuanPhone())
            .or()
            .eq("cangkurenyuan_id_number", cangkurenyuan.getCangkurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CangkurenyuanEntity cangkurenyuanEntity = cangkurenyuanService.selectOne(queryWrapper);
        if(cangkurenyuanEntity==null){
            cangkurenyuan.setCreateTime(new Date());
            cangkurenyuan.setPassword("123456");
            cangkurenyuanService.insert(cangkurenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者仓库人员手机号或者仓库人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CangkurenyuanEntity cangkurenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,cangkurenyuan:{}",this.getClass().getName(),cangkurenyuan.toString());
        CangkurenyuanEntity oldCangkurenyuanEntity = cangkurenyuanService.selectById(cangkurenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<CangkurenyuanEntity> queryWrapper = new EntityWrapper<CangkurenyuanEntity>()
            .notIn("id",cangkurenyuan.getId())
            .andNew()
            .eq("username", cangkurenyuan.getUsername())
            .or()
            .eq("cangkurenyuan_phone", cangkurenyuan.getCangkurenyuanPhone())
            .or()
            .eq("cangkurenyuan_id_number", cangkurenyuan.getCangkurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CangkurenyuanEntity cangkurenyuanEntity = cangkurenyuanService.selectOne(queryWrapper);
        if("".equals(cangkurenyuan.getCangkurenyuanPhoto()) || "null".equals(cangkurenyuan.getCangkurenyuanPhoto())){
                cangkurenyuan.setCangkurenyuanPhoto(null);
        }
        if(cangkurenyuanEntity==null){
            cangkurenyuanService.updateById(cangkurenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者仓库人员手机号或者仓库人员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CangkurenyuanEntity> oldCangkurenyuanList =cangkurenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        cangkurenyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<CangkurenyuanEntity> cangkurenyuanList = new ArrayList<>();//上传的东西
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
                            CangkurenyuanEntity cangkurenyuanEntity = new CangkurenyuanEntity();
//                            cangkurenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //cangkurenyuanEntity.setPassword("123456");//密码
//                            cangkurenyuanEntity.setCangkurenyuanName(data.get(0));                    //仓库人员姓名 要改的
//                            cangkurenyuanEntity.setCangkurenyuanPhone(data.get(0));                    //仓库人员手机号 要改的
//                            cangkurenyuanEntity.setCangkurenyuanIdNumber(data.get(0));                    //仓库人员身份证号 要改的
//                            cangkurenyuanEntity.setCangkurenyuanPhoto("");//详情和图片
//                            cangkurenyuanEntity.setXiaoshourenyuanZhuzhi(data.get(0));                    //现住址 要改的
//                            cangkurenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            cangkurenyuanEntity.setCangkurenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            cangkurenyuanEntity.setCreateTime(date);//时间
                            cangkurenyuanList.add(cangkurenyuanEntity);


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
                                //仓库人员手机号
                                if(seachFields.containsKey("cangkurenyuanPhone")){
                                    List<String> cangkurenyuanPhone = seachFields.get("cangkurenyuanPhone");
                                    cangkurenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> cangkurenyuanPhone = new ArrayList<>();
                                    cangkurenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("cangkurenyuanPhone",cangkurenyuanPhone);
                                }
                                //仓库人员身份证号
                                if(seachFields.containsKey("cangkurenyuanIdNumber")){
                                    List<String> cangkurenyuanIdNumber = seachFields.get("cangkurenyuanIdNumber");
                                    cangkurenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cangkurenyuanIdNumber = new ArrayList<>();
                                    cangkurenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("cangkurenyuanIdNumber",cangkurenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<CangkurenyuanEntity> cangkurenyuanEntities_username = cangkurenyuanService.selectList(new EntityWrapper<CangkurenyuanEntity>().in("username", seachFields.get("username")));
                        if(cangkurenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CangkurenyuanEntity s:cangkurenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //仓库人员手机号
                        List<CangkurenyuanEntity> cangkurenyuanEntities_cangkurenyuanPhone = cangkurenyuanService.selectList(new EntityWrapper<CangkurenyuanEntity>().in("cangkurenyuan_phone", seachFields.get("cangkurenyuanPhone")));
                        if(cangkurenyuanEntities_cangkurenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CangkurenyuanEntity s:cangkurenyuanEntities_cangkurenyuanPhone){
                                repeatFields.add(s.getCangkurenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [仓库人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //仓库人员身份证号
                        List<CangkurenyuanEntity> cangkurenyuanEntities_cangkurenyuanIdNumber = cangkurenyuanService.selectList(new EntityWrapper<CangkurenyuanEntity>().in("cangkurenyuan_id_number", seachFields.get("cangkurenyuanIdNumber")));
                        if(cangkurenyuanEntities_cangkurenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CangkurenyuanEntity s:cangkurenyuanEntities_cangkurenyuanIdNumber){
                                repeatFields.add(s.getCangkurenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [仓库人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cangkurenyuanService.insertBatch(cangkurenyuanList);
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
        CangkurenyuanEntity cangkurenyuan = cangkurenyuanService.selectOne(new EntityWrapper<CangkurenyuanEntity>().eq("username", username));
        if(cangkurenyuan==null || !cangkurenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(cangkurenyuan.getId(),username, "cangkurenyuan", "仓库人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","仓库人员");
        r.put("username",cangkurenyuan.getCangkurenyuanName());
        r.put("tableName","cangkurenyuan");
        r.put("userId",cangkurenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody CangkurenyuanEntity cangkurenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<CangkurenyuanEntity> queryWrapper = new EntityWrapper<CangkurenyuanEntity>()
            .eq("username", cangkurenyuan.getUsername())
            .or()
            .eq("cangkurenyuan_phone", cangkurenyuan.getCangkurenyuanPhone())
            .or()
            .eq("cangkurenyuan_id_number", cangkurenyuan.getCangkurenyuanIdNumber())
            ;
        CangkurenyuanEntity cangkurenyuanEntity = cangkurenyuanService.selectOne(queryWrapper);
        if(cangkurenyuanEntity != null)
            return R.error("账户或者仓库人员手机号或者仓库人员身份证号已经被使用");
        cangkurenyuan.setCreateTime(new Date());
        cangkurenyuanService.insert(cangkurenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        CangkurenyuanEntity cangkurenyuan = cangkurenyuanService.selectById(id);
        cangkurenyuan.setPassword("123456");
        cangkurenyuanService.updateById(cangkurenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        CangkurenyuanEntity cangkurenyuan = cangkurenyuanService.selectOne(new EntityWrapper<CangkurenyuanEntity>().eq("username", username));
        if(cangkurenyuan!=null){
            cangkurenyuan.setPassword("123456");
            boolean b = cangkurenyuanService.updateById(cangkurenyuan);
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
    public R getCurrCangkurenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        CangkurenyuanEntity cangkurenyuan = cangkurenyuanService.selectById(id);
        if(cangkurenyuan !=null){
            //entity转view
            CangkurenyuanView view = new CangkurenyuanView();
            BeanUtils.copyProperties( cangkurenyuan , view );//把实体数据重构到view中

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
