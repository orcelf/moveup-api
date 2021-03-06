package jp.co.vermore.mapper;

import jp.co.vermore.entity.AdminUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int countByExample(AdminUserRole adminUserRole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int deleteByExample(AdminUserRole adminUserRole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int insert(AdminUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int insertSelective(AdminUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    List<AdminUserRole> selectByExample(AdminUserRole adminUserRole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    AdminUserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") AdminUserRole record, @Param("example") AdminUserRole adminUserRole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int updateByExample(@Param("record") AdminUserRole record, @Param("example") AdminUserRole adminUserRole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int updateByPrimaryKeySelective(AdminUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated Mon Mar 26 13:14:11 CST 2018
     */
    int updateByPrimaryKey(AdminUserRole record);
}