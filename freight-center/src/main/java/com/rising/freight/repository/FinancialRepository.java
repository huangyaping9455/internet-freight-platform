package com.rising.freight.repository;

import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.InternetFinancial;
import org.springframework.stereotype.Repository;

/**
 * 描述：汽车信息驱动程序库
 *
 * @see BaseRepository
 * 作者：李启云
 * 日期：2021-01-04
 */
@Repository
public interface FinancialRepository extends BaseRepository<InternetFinancial,String> {


}
