package jp.co.vermore.mapper;

import jp.co.vermore.entity.AdminUser;
import jp.co.vermore.entity.AdminUserExample;

import java.util.List;

public interface AdminUserMapper {

    AdminUser selectByPrimaryKey(Integer id);

    AdminUser login(String loginName, String password);

    AdminUser selectByMail(String mail);

    AdminUser selectByRole(Long role);

    List<Long> getAdminUserIdListByIdList(List<String> idList);

    List<Long> getAdminUserIdList();


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user
     *
     * @mbggenerated
     */
    List<AdminUser> selectByExample(AdminUserExample example);



    int updateAdminUser(AdminUser user);
}