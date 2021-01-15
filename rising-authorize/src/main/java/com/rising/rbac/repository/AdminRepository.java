/**
 *
 */
package com.rising.rbac.repository;

import com.rising.rbac.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author liqiyun
 */
@Repository
public interface AdminRepository extends RisingRepository<Admin> {

    /**
     * <p> 方法描述：根据用户名查找. </p>
     * <p> 创建时间：2020-04-30 13:51:35 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param username the username
     * @return the admin
     */
    Admin findByUsername(String username);

    List<Admin> findByOrganizationId(Long organizationId);
}
