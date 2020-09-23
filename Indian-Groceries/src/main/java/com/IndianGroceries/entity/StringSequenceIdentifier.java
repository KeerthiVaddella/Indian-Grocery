package com.IndianGroceries.entity;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StringSequenceIdentifier implements IdentifierGenerator {
	
	public static final String SEQUENCE_PREFIX = "IG";
	public static long suffix=0;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		suffix+=1;
		return SEQUENCE_PREFIX + String.format("%3d%s",0,suffix);
	}
	
    
}
