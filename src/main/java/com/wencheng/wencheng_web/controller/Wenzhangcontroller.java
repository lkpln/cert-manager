package com.wencheng.wencheng_web.controller;

import com.wencheng.wencheng_web.pojo.Enum;
import com.wencheng.wencheng_web.pojo.Result;
import com.wencheng.wencheng_web.pojo.Wenzhang;
import com.wencheng.wencheng_web.service.QrcodeService;
import com.wencheng.wencheng_web.service.WenzhangService;
import isc.authclt.IscJcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xtqm.code.server.vo.SystemConstrantEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@RestController

public class Wenzhangcontroller {
    @Autowired
    private WenzhangService wenzhangService;

    /**
     * 配置对象.
     */
    private static Properties pop;

    /**
     * appId.
     */
    private static String appId;

    /**
     * 端口.
     */
    private static String port;


    /**
     * 签名服务器密码容器名称.
     */
    private static String strContainer;

    /**
     * http 访问超时时间.
     */
    private static String timeout;

    /**
     * 签名服务器ip.
     */
    private static String hostip1;


    /**
     * 传配置文件路径.
     *
     *
     */
    public Result setConfig(String path) {
        pop = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(path));
            pop.load(fileInputStream);
            appId = pop.getProperty("appId");
            strContainer = pop.getProperty("strContainer");
            hostip1 = pop.getProperty("hostip1");
            port = pop.getProperty("port");

            if (pop.getProperty("timeout") == null || "".equals(pop.getProperty("timeout"))) {
                timeout = "1000";
            } else {
                timeout = pop.getProperty("timeout");
            }
            return new Result(SystemConstrantEnum.OK.getCode(), SystemConstrantEnum.OK.getMessage());
        } catch (IOException ioException) {
            return new Result(SystemConstrantEnum.PROPERTIES_INFO_NOT_FIND.getCode(), SystemConstrantEnum.PARAM_NOT_FIND.getMessage(), "配置文件加载失败");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException exception) {
                }
            }
        }


    }
//
//
//
//
//
//        @GetMapping(value = "/file")
//        public String file() {
//            return "file";
//        }
//
//        @PostMapping(value = "/fileUpload")
//        public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, @RequestParam(value = "id", required = false) String id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "school_overview", required = false) String school_overview, @RequestParam(value = "project_introduction", required = false) String project_introduction, @RequestParam(value = "enrollment_major", required = false) String enrollment_major, @RequestParam(value = "enrollment_target", required = false) String enrollment_target, @RequestParam(value = "registration_materials", required = false) String registration_materials, String banner_url, HttpServletRequest request ) {
//
//            if (file.isEmpty()) {
//                System.out.println("文件为空空");
//            }
//            String fileName = file.getOriginalFilename();  // 文件名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//          //  String filePath = "/tupian/"; // 上传后的路径
//            String filePath = request.getSession().getServletContext().getRealPath("/tupian/");
//            fileName = UUID.randomUUID() + suffixName; // 新文件名
//            File dest = new File(filePath + fileName);
//            System.out.println (fileName);
//            System.out.println (dest);
//
//            if (!dest.getParentFile().exists()) {
//                dest.getParentFile().mkdirs();
//            }
//            try {
//                file.transferTo(dest);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//
//
//            Wenzhang w =new Wenzhang();
//            w.setEnrollment_major ( enrollment_major );
//            w.setEnrollment_target ( enrollment_target );
//            w.setId ( id );
//            w.setName ( name );
//            w.setBanner_url ( fileName );
//            w.setProject_introduction (  project_introduction);
//            w.setSchool_overview (school_overview  );
//            w.setRegistration_materials ( registration_materials );
//
//            int i = wenzhangService.wenzhang (w);
//            if (i > 0) {
//                System.out.println ( "添加文章成功" );
//            } else {
//                System.out.println ( "添加文章失败" );
//            }
//
//
//            return "file";
//
//
//
//
//
//    }
//
//    @RequestMapping(value = "/selectwenzhang", method = RequestMethod.POST)
//    public List<Wenzhang> selectwenzhang() {
//        List<Wenzhang> selectwenzhang =wenzhangService.selectwenzhang ();
//
//        if (selectwenzhang != null) {
//            return selectwenzhang;
//
//
//        } else {
//
//            return null;
//
//
//        }
//
//
//    }
//
//    @RequestMapping(value = "/delwenzhang", method = RequestMethod.POST)
//    public int delwenzhang(@RequestParam("id") String id) {
//        int i = wenzhangService.delwenzhang ( id );
//        if (i > 0) {
//            if (i > 0) {
//                System.out.println ( "删除成功" );
//
//            } else {
//                System.out.println ( "删除失败" );
//
//            }
//        }
//        List<Wenzhang> selectwenzhang =wenzhangService.selectwenzhang ();
//        return i;
//    }
//    @RequestMapping(value = "/updatewenzhang", method = RequestMethod.POST)
//    public int  updatewenzhang(@RequestParam(value = "id", required = false) String id, @RequestParam(value="name", required = false) String name,@RequestParam(value = "school_overview",required = false) String school_overview, @RequestParam(value = "project_introduction", required = false) String project_introduction,@RequestParam(value = "enrollment_major", required = false) String enrollment_major,@RequestParam(value = "enrollment_target", required = false) String enrollment_target,@RequestParam(value = "registration_materials", required = false) String registration_materials)
//    {
//
//        int ad =wenzhangService.updatewenzhang ( id, name, school_overview, project_introduction, enrollment_major, enrollment_target, registration_materials );
//
//        List<Wenzhang> selectwenzhang =wenzhangService.selectwenzhang ();
//
//        return  ad;
//    }
//    @RequestMapping(value = "/selectwenzhangByname", method = RequestMethod.POST)
//  public List<Wenzhang>  selectwenzhangByname(@RequestParam("name") String name) {
//        List<Wenzhang> selectwenzhangByname =wenzhangService.selectwenzhangByname ( name );
//
//        if (selectwenzhangByname != null) {
//            return selectwenzhangByname;
//
//
//        } else {
//
//            return null;
//
//
//        }
//
//
//    }
//
//    @RequestMapping(value = "/selectwenzhangByid", method = RequestMethod.POST)
//    public List<Wenzhang>  selectwenzhangByid(@RequestParam("id") String id) {
//        List<Wenzhang> selectwenzhangByid =wenzhangService.selectwenzhangByid ( id );
//
//        if (selectwenzhangByid != null) {
//            return selectwenzhangByid;
//
//
//        } else {
//
//            return null;
//
//
//        }
//
//
//    }
    @RequestMapping(value = "/article",method = RequestMethod.POST)
    public Result article(@RequestBody (required = false)Wenzhang wenzhang ){
        int i=wenzhangService.AddWenZhang(wenzhang);
        if (i>0){
            System.out.println("推送文章成功");
            return  new Result(Enum.OK.getCode(),Enum.OK.getMessage(),"推送文章成功");
        }
       else {
            System.out.println("推送文章失败");
            return  new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"推送文章失败");
        }
    }
    @RequestMapping(value = "/getStatus",method = RequestMethod.POST)
    public Result article(@RequestBody (required = false)String  username ){
       String i=wenzhangService.getStatus(username);
        System.out.println(i);
        if (i!=null){
            System.out.println("允许文章发表");
            return  new Result(Enum.OK.getCode(),Enum.OK.getMessage(),"1");
        }
        else {
            System.out.println("不允许文章发表");
            return  new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"0");
        }
    }
    @RequestMapping(value = "/deletearticle",method = RequestMethod.POST)
    public Result deletearticle(@RequestBody (required = false)Wenzhang wenzhang ){
        System.out.println(wenzhang);
        int i=wenzhangService.updateWenzhangs(wenzhang);
        if (i>0){
            System.out.println("文章重置成功");
            return  new Result(Enum.OK.getCode(),Enum.OK.getMessage(),"文章重置成功");
        }
        else {
            System.out.println("文章重置失败");
            return  new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"文章重置失败");
        }
    }
    @RequestMapping(value = "/getArticle",method = RequestMethod.POST)
    public Result articlestatus(){


        List<Wenzhang>  wenzhang1=wenzhangService.selectwenzhang();
        if (wenzhang1!=null){
            System.out.println("查询成功");
            return  new Result(Enum.OK.getCode(),Enum.OK.getMessage(),wenzhang1);
        }
        else {
            System.out.println("查询失败");
            return  new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),wenzhang1);
        }

    }
    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result updateArticle(@RequestBody (required = false)Wenzhang wenzhang ){
        System.out.println(wenzhang);
      int  wenzhang1=wenzhangService.updateWenzhang(wenzhang);
        if (wenzhang1>0){
            System.out.println("更新文章成功");
            return  new Result(Enum.OK.getCode(),Enum.OK.getMessage(),wenzhang1);
        }
        else {
            System.out.println("更新文章失败");
            return  new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"更新文章失败");
        }
    }

    @RequestMapping(value = "/getApp",method = RequestMethod.POST)
    public void getApp(String url , HttpServletResponse response) throws IOException {
        QrcodeService qrcodeService = new QrcodeService();
        Result result = qrcodeService.getApp(url);

        if (result.getCode() == 0) {
            String data = com.alibaba.fastjson.JSONObject.toJSONString(result.getData());
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(data);
            String base64Img = jsonObject.getString("base64Img");
            try {
                response.getOutputStream().write(base64Img.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.getOutputStream().flush();
        } else {
            System.out.println("生成签名二维码失败!" + result.getMessage());
        }

    }
    @RequestMapping(value = "/verifySign",method =RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result verifySign(@RequestBody(required = false)Wenzhang wenzhang) {
        System.out.println(wenzhang);
//        XTQMJarService xtqmJarService =new XTQMJarService();
//        xtqmJarService.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
//        setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
          setConfig("/root/xtqmtest/xtqm-jar.properties");
        if (wenzhang.getSourceData() == null) {
            System.out.println("调用总参签名服务器P7验签失败：签名源数据为空.");
        }
        if (wenzhang.getSignData()== null) {
            System.out.println("调用总参签名服务器P7验签失败：签名值为空.");
        }
        try {
            Properties properties = new Properties();
            wenzhang.setHostip1(hostip1);
//            info.setHostip1("192.168.114.221");
            wenzhang.setPort(port);
            wenzhang.setStrContainer(strContainer);
            String[] hostips = wenzhang.getHostip1().split(",");
            for (int i = 0; i < hostips.length; i++) {
                properties.setProperty("hostip" + (i+1), hostips[i]);
            }
            properties.setProperty("port", String.valueOf(wenzhang.getPort()));
            properties.setProperty("strContainer", wenzhang.getStrContainer());
            IscJcrypt isc = new IscJcrypt();
            isc.setConfInfo(properties);
            isc.openDevice(wenzhang.getStrContainer());
            StringBuilder sbr = new StringBuilder();
            if (wenzhang.getSourceData() == null || "".equals(wenzhang.getSourceData())) {
                sbr.append("签名源数据为空,");
            }

            if (wenzhang.getSignData() == null || "".equals(wenzhang.getSignData())) {
                sbr.append("签名值为空");
            }
            if (sbr.length() != 0) {
                System.out.println("签名参数为空");
                return new Result(SystemConstrantEnum.FAIL.getCode(),SystemConstrantEnum.FAIL.getMessage(),"签名参数为空");
            }
            isc.verifySign(wenzhang.getSignData(), wenzhang.getSourceData(), wenzhang.getSourceData().length(), null,0);

            if (isc.errCode == SystemConstrantEnum.OK.getCode()) {
                System.out.println("调用总参签名服务器P7验签成功.");
            } else {
                System.out.println("调用总参签名服务器P7验签失败");
                return new Result(SystemConstrantEnum.FAIL.getCode(),SystemConstrantEnum.FAIL.getMessage(),"p7验签失败"+isc.errCode);
            }
            isc.closeDevice();

        } catch (Exception e) {
            System.out.println("调用总参签名服务器P7验签出现异常");
        }
        return new Result(SystemConstrantEnum.OK.getCode(),SystemConstrantEnum.OK.getMessage(),"p7验签成功");
    }

}
