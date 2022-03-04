package com.wencheng.wencheng_web.controller;

import cn.hutool.core.util.HexUtil;
import com.alibaba.fastjson.JSONObject;
import com.wencheng.wencheng_web.pojo.Enum;
import com.wencheng.wencheng_web.pojo.Result;
import com.wencheng.wencheng_web.pojo.User;
import com.wencheng.wencheng_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xtqm.code.server.service.XTQMJarService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.regex.Pattern;

//import org.springframework.data.redis.core.RedisTemplate;
//import javax.validation.Valid;


@RestController
public class Usercontroller {
    private static String key;
    private String data = "";
    private String certsnResult;  //业务操作后返回的数据
    @Autowired
    private UserService userService;
    //    @Autowired
//    private TokenService tokenService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //    @UserLoginToken
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Result finduser(@RequestBody(required = false) User user) {
//         JSONObject jsonObject=new JSONObject();
//        ValueOperations<String, Object> redisString = redisTemplate.opsForValue();
//        // SET key value: 设置指定 key 的值
//      redisString.get(user.getUsername());
//        RedisUtil redisUtil = new RedisUtil(redisTemplate);
//        Object o = redisUtil.get(user.getUsername());
//        if (o != null) {
//            System.out.println("从redis查询成功" + o);
//            return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), o);
//        } else {
//            User data = userService.finduser(user);
//            System.out.println(data);
//            if (data != null) {
//                System.out.println("欢迎登陆");
//
//            } else {
//                System.out.println("重新登录");
//            }
//            return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), data);
//        }
        Result result1 = userService.loginUser(user);
        if (result1.getCode()==0) {
            System.out.println("欢迎登陆");
            return new Result(Enum.OK.getCode(), Enum.OK.getMessage(),  result1);

        } else {
            System.out.println("重新登录");
            return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), result1);
        }



    }

//    @PassToken
//    @RequestMapping(value = "/getToken", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
//    public Object getToken(@RequestBody(required = false) User user) {
//        JSONObject jsonObject = new JSONObject();
//        String token = tokenService.getToken(user);
//        jsonObject.put("token", token);
//        return jsonObject;
//
//    }

    //    @UserLoginToken
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Result userRegister(@Valid @RequestBody(required = false) User user) {

           Result result1=new Result();
        int flag = Integer.parseInt(user.getFlag());//flag: 0  普通用户   1 协签用户
        if (flag == 0) {
            Result result = userService.userRegisters(user);
            if (result.getCode() == 0) {
                return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), "普通用户注册成功！");
            } else {
                return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "普通用户注册失败！");
            }
        } else if (flag == 1) {
            Result result = userService.xtqmuserRegister(user);
            if (result.getCode() == 0) {
                return new Result(Enum.OK.getCode(), Enum.OK.getMessage(), "用户注册成功并同步为协签用户！");
            } else {
                System.out.println(result);
                return new Result(Enum.FAIL.getCode(), Enum.FAIL.getMessage(), "用户注册失败！"+result.getData());

            }
        }
        return result1;
    }
    @RequestMapping(value = "/fingUser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Result fingUser(@Valid @RequestBody(required = false) User user) {
         User i=  userService.finduser(user);
        System.out.println(i);
         if (i!=null){
             return  new Result( Enum.OK.getCode(),Enum.OK.getMessage(),i);
         }
         else {
             return  new Result( Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"查询用户信息失败！");
         }

    }
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Result updateUser(@Valid @RequestBody(required = false) User user) {
        System.out.println(user);
       Result p=  userService.updateUser(user);
        if (p.getCode()==0){
            return  new Result( Enum.OK.getCode(),Enum.OK.getMessage(),"更新用户信息成功");
        }
        else {
            return  new Result( Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"更新用户信息失败！");
        }

    }
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Result deleteUser(@Valid @RequestBody(required = false) User user) {
        Result p=  userService.deleteUser(user);
        if (p.getCode()==0){
            return  new Result( Enum.OK.getCode(),Enum.OK.getMessage(),"注销用户信息成功");
        }
        else {
            return  new Result( Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"注销用户信息失败！");
        }

    }

//               if (result >0) {
//                   System.out.println ( "注册成功" );
////                   RedisUtil redisUtil =new RedisUtil(redisTemplate);
//////                   ValueOperations<String, Object> redisString = redisTemplate.opsForValue();
//////                   // SET key value: 设置指定 key 的值
//////                 redisString.set(user.getUsername(), user);
////                 Boolean d=  redisUtil.set(user.getUsername(),user);
////                 if (d==true){
////                     System.out.println("缓存成功");
////                     return new Result(Enum.OK.getCode(),Enum.OK.getMessage(),"用户注册成功");
////                 }
////                 else {
////                     System.out.println("缓存失败");
////                     return new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"用户注册成功,但缓存失败");
////                 }
//
//
//               } else {
//                   System.out.println ( "重新注册" );
//                   return new Result(Enum.FAIL.getCode(),Enum.FAIL.getMessage(),"用户注册并缓存成功");
//               }
//           }
//

//
    @RequestMapping (value ="/server",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public void getQRcode(int  signType,String strSrcData , HttpServletResponse response) throws Exception{

        System.out.println("进来");
        System.out.println(strSrcData);
         User user=new User();
         user.setSignType(signType);
        XTQMJarService service = new XTQMJarService();
//        Properties properties = new Properties();
//        properties.load(new ClassPathResource("C:\\Users\\dell\\Desktop\\xtqm-jar\\xtqm-jar.properties").getInputStream());
////		service.setConfig("E:\\03-Byzk_Project\\MobileDemo\\xtqm-jar.properties");
//        service.setConfig(properties);
//        service.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
        service.setConfig("/root/xtqmtest/xtqm-jar.properties");

         signType = user.getSignType();
        if (signType == 0) {
            xtqm.code.server.vo.Result result = service.scanQRCodeAuths("");
            if (result.getCode() == 0) {
                String data = com.alibaba.fastjson.JSONObject.toJSONString(result.getData());
                com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(data);
                String base64Img = jsonObject.getString("base64Img");
                key = jsonObject.getString("key");
//                response.getOutputStream().write(Base64.decode(base64Img.split(",")[1]));
                response.getOutputStream().write(base64Img.getBytes());
                // 添加二维码logo图标
			/*BitMatrix bitMatrix;
			bitMatrix = QRCodeUtil.encode(base64Img);
			MatrixToImageWriter.writeToStream(bitMatrix, "png", response.getOutputStream());*/
                response.getOutputStream().flush();
            } else {
                System.out.println("生成身份认证二维码失败!" + result.getMessage());
            }
        } else if (signType == 1) {
            xtqm.code.server.vo.Result result = service.scanQRCodeSigns(HexUtil.encodeHexStr(strSrcData),"18366116367");
            if (result.getCode() == 0) {
                String data = com.alibaba.fastjson.JSONObject.toJSONString(result.getData());
                com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(data);
                String base64Img = jsonObject.getString("base64Img");
                key = jsonObject.getString("key");
                System.out.println(key);
                response.getOutputStream().write(base64Img.getBytes());
                response.getOutputStream().flush();
            } else {
                System.out.println("生成签名二维码失败!" + result.getMessage());
            }
        } else {
            System.out.println("生成二维码失败！业务类型错误！");
        }

    }

    @RequestMapping(value = "/authenticationResult",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String authenticationResult(int signType) throws IOException {
   User user=new User();
   user.setSignType(signType);
        JSONObject jsonObject = new JSONObject();

        XTQMJarService service = new XTQMJarService();
//        Properties properties = new Properties();
//        properties.load(new ClassPathResource("xtqm-jar.properties").getInputStream());
////		service.setConfig("E:\\03-Byzk_Project\\MobileDemo\\xtqm-jar.properties");
//        service.setConfig(properties);
//        service.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
        service.setConfig("/root/xtqmtest/xtqm-jar.properties");
        System.out.println(key);
        xtqm.code.server.vo.Result result = service.getQRCodeResult(key);

        if (result.getCode() == 0) {
            JSONObject jsonObject1 = (JSONObject) result.getData();
            xtqm.code.server.vo.Result results = service.getCertInfo((String) jsonObject1.get("cert"),27);
            System.out.println(results);
            if (results.getCode()==20001){
                jsonObject.put("number","");
            }
            else {
                jsonObject.put("number",results.getData());
            }
            xtqm.code.server.vo.Result resultss = service.getCertInfo((String) jsonObject1.get("cert"),81);
            System.out.println(resultss);
            if (resultss.getCode()==20001){
                jsonObject.put("identifyCard","");
            }
            else {
                jsonObject.put("identifyCard",resultss.getData());
            }
            xtqm.code.server.vo.Result resultsss = service.getCertInfo((String) jsonObject1.get("cert"),101);
            System.out.println(resultsss);
            if (resultsss.getCode()==20001){
                jsonObject.put("mobilePhoneNumber","");
            }
            else {
                jsonObject.put("mobilePhoneNumber",resultsss.getData());
            }
            jsonObject.put("msg","success");

             signType = user.getSignType();
            if (signType == 1) {
                String data = com.alibaba.fastjson.JSONObject.toJSONString(result.getData());
                com.alibaba.fastjson.JSONObject jsonData = com.alibaba.fastjson.JSONObject.parseObject(data);
                String signature = jsonData.getString("signature");
                jsonObject.put("certsnResult", signature);
            }
        } else {
//            System.out.println("获取扫码结果失败!" + result.getMessage());
            System.out.println("获取扫码结果失败!");
            jsonObject.put("msg", "error");
        }

        return jsonObject.toString();
    }



//    /**
//     * 获取税号和证书序列号
//     * @return
//     */
//    @RequestMapping("getNum")
//    @ResponseBody
//    public String getNums(HttpServletRequest request){
//        JSONObject jsonObject = new JSONObject();
//        String userId = (String) request.getSession().getAttribute("userid");
//        String certSn = (String) request.getSession().getAttribute("certSn");
//        jsonObject.put("userId", userId);
//        jsonObject.put("certSn", certSn);
//        return jsonObject.toString();
//    }

//    @RequestMapping(value = "/coVerify.do",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
//    public  void coVerify(@RequestBody User user, HttpServletRequest request,HttpServletResponse response){
//
//        try{
//            XTQMJarService jarService=new XTQMJarService();
//            jarService.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
////            String key=request.getParameter("key");
//            String strSrcData= null;
//
//                strSrcData = Hex.toHexString(user.getStrSrcData().getBytes("UTF-8"));
//            xtqm.code.server.vo.Result  result=jarService.verifySign(user.getKey(),strSrcData);
//
//            System.out.println(result);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
////        return  new Result(result.getCode(),result.getMessage(),result,false) ;
//
//        }
      @RequestMapping("/serverHello")
    public Object serverHello(String clientHelloInfo) throws IOException {
          XTQMJarService service = new XTQMJarService();
//          service.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
          service.setConfig("/root/xtqmtest/xtqm-jar.properties");
         xtqm.code.server.vo.Result result= service.serverHello(clientHelloInfo);
         return  result.getData();
      }
    @RequestMapping("/serverAuth")
    public Result serverAuth(String strClientAuth, String strServerRandom) throws IOException {
        XTQMJarService service = new XTQMJarService();
//        service.setConfig("D:\\byzk\\xtqm-jar\\xtqm-jar.properties");
        service.setConfig("/root/xtqmtest/xtqm-jar.properties");
        xtqm.code.server.vo.Result result= service.serverAuth( strClientAuth,strServerRandom);
        String cert= (String) result.getData();
        xtqm.code.server.vo.Result result1=  service.getCertInfo( cert,27);
        return  new Result(result.getCode(),result.getMessage(),result1.getData());
    }
//    @RequestMapping(value="/GetQrCode",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
//    public void GetQrCode(@RequestBody (required = false) User user,HttpServletResponse response) throws IOException {
//       String appId= user.getAppId();
//       String tagCode=user.getTaxCode();
//       String strData=HexUtil.encodeHexStr(user.getStrData());
//       user.setStrData(strData);
//        if ("".equals(appId) || appId == null) {
//
//            System.out.println("缺少appId参数-请检查配置文件");
//        }
//        if ("".equals(strData) || strData == null) {
//
//            System.out.println( "缺少待签名数据strData参数");
//
//        }
//        if (!isHexStr(strData)) {
//            System.out.println(  "验签原数据需要UTF8字符集 16进制字符串");
//        }
//        if ("".equals(tagCode) || tagCode == null) {
//
//            System.out.println(  "缺少唯一身份标识tagCode参数");
//        }
//      String results= HttpUtil.post("https://127.0.0.1:28006/xq/GetQrCode","user");
//        JSONObject jsonObject =JSONObject.parseObject(results);
//        String code=jsonObject.getString("Code");
//        if (code=="0"){
//            String base64Img = jsonObject.getString("base64Img");
//            key = jsonObject.getString("key");
//            System.out.println(key);
//            response.getOutputStream().write(base64Img.getBytes());
//            response.getOutputStream().flush();
//        }
//        else {
//            System.out.println("生成二维码失败");
//        }
//
//    }
    /**
     * 判断是否是16进制字符串.
     *
     * @param str 字符串
     * @return true or false
     */
    private boolean isHexStr(String str) {
        String pattern = "^[0-9A-Fa-f]+$";
        return Pattern.compile(pattern).matcher(str).matches();
    }

}



