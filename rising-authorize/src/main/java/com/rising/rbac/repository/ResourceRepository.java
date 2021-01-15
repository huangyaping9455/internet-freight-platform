/**
 *
 */
package com.rising.rbac.repository;

import com.rising.rbac.domain.Resource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author liqiyun
 */
@Repository
public interface ResourceRepository extends RisingRepository<Resource> {

    /**
     * <p> 方法描述：根据资源名称查询. </p>
     * <p> 创建时间：2020-04-30 13:53:36 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     */
    Resource findByName(String name);

}
