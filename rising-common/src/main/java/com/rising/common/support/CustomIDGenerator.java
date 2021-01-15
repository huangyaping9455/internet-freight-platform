package com.rising.common.support;

import com.rising.common.core.IdGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.id.SelectGenerator;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

public class CustomIDGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        IdGenerator idGenerator = new IdGenerator();
        return idGenerator.nextId();
    }
}