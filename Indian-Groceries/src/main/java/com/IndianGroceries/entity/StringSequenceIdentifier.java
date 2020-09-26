package com.IndianGroceries.entity;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.data.mapping.MappingException;


public class StringSequenceIdentifier extends SequenceStyleGenerator {
 
    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    public static final String VALUE_PREFIX_DEFAULT = "";
    private String valuePrefix;
 
    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%d";
    private String numberFormat;
 
    @Override
    public Serializable generate(SharedSessionContractImplementor session,
            Object object) throws HibernateException {
        return valuePrefix + String.format(numberFormat, super.generate(session, object));
    }
 
    @Override
    public void configure(Type type, Properties params,
            ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,
                params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                params, NUMBER_FORMAT_DEFAULT);
    }
 
}

/* implements IdentifierGenerator {
	
	public static final String SEQUENCE_PREFIX = "IG";
	public static long suffix=0;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		suffix+=1;
		System.out.println(SEQUENCE_PREFIX + String.format("%3d%s",0,suffix));
		return SEQUENCE_PREFIX + String.format("%3d%s",0,suffix);
	}
	
    
}*/
