/**
 *
 */
package com.rising.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author liqiyun
 */
@NoRepositoryBean
public interface RisingRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
