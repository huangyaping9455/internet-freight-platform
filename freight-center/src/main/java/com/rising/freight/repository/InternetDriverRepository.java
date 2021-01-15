package com.rising.freight.repository;

import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.InternetDriver;
import org.springframework.stereotype.Repository;

/**
 * 描述：网络司机信息存储库
 *  司机
 * @see BaseRepository
 * 作者：李启云
 * 日期：2021-01-05
 */
@Repository
public interface InternetDriverRepository extends BaseRepository<InternetDriver,String> {


}
