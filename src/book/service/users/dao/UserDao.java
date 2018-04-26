package book.service.users.dao;

import book.service.users.pojo.User;

public interface UserDao {

    /**
     * 登录
     */
    public User login(String user_phone, String user_pwd);

    /**
     * 注册
     */
    public int register(String user_name, String user_pwd, String user_email, String user_phone);

    /**
     * 个人信息修改
     */
    public int editYourself(String user_id, String user_name, String user_pwd, String user_email, String user_address);

    /**
     * 检验手机号码是否存在
     */
    public User isExist(String user_phone);

    /**
     * 查找所有用户
     */
    public String queryUsers(int page);

    /**
     * 搜索
     */
    public String search(String search_data);

    /**
     * 查封,解封账号
     */
    public int dele(String user_id, String status);

    /**
     * 管理模块修改用户信息
     */
    public int edit(int user_id, String user_name, String user_address);


}
