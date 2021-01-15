/**
 *
 */
package com.rising.rbac.repository.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

/**
 *数据库表和字段命名策略
 * @author liqiyun
 */
public class RisingImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

	/**
	 *
	 */
	private static final long serialVersionUID = 769122522217805485L;

	@Override
	protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
		return super.toIdentifier(stringForm.toLowerCase(), buildingContext);
	}

}
