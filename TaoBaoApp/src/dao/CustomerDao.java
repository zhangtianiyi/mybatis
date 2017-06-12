package dao;

import java.util.List;
import java.util.Map;

import entity.Customer;

public interface CustomerDao {
	/**根据用户名查询信息**/
    public List<Customer> queryCustomerByNamepass(Map<String, Object> map);

    /**注册新用户**/
    public void insertCustomer(Map<String, String> registerMap);

    /**验证用户是否存在**/
    public List<Customer> queryCustomerByName(String name);
}
