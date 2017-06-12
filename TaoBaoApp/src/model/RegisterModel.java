package model;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import dao.CustomerDaoImpl;
import entity.Customer;

public class RegisterModel {
	//Register部分测试通过
	public String handle(Map<String, String> registerMap){
        String res = "请完成注册信息的填写";
        String username = registerMap.get("cname");
        String userpass = registerMap.get("cpass");
        String again_userpass = registerMap.get("again_userpass");
        String phone = registerMap.get("cphone");
        //这里的逻辑处理必须大大加强，增强逻辑功能鲁棒性等，比如用户名已存在，不然就是出错。
        String regex = "[\\d]{11}";
        if ((userpass!=null && again_userpass!=null) && !(again_userpass.equals(userpass))) {
        	res = "两次密码不一致,注册失败";
        }else if (phone!=null && phone.length()>0 && !phone.matches(regex)) {
        	res = "请正确填写11位手机号";
        }else {
             if (userpass.length()>5) {     
            	 //注册成功，向数据库插入信息
                   new CustomerDaoImpl().insertCustomer(registerMap);
                   res = "注册成功";
             }else {
                   res = "密码不合法";
             }
        }
        return res;
	}
}
