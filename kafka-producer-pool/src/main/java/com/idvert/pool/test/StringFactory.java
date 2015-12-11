package com.idvert.pool.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StringFactory extends BasePooledObjectFactory<String>{

	@Override
	public String create() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(new Date());
		return new String(str);
	}

	@Override
	public PooledObject<String> wrap(String obj) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<String>(obj);
	}

	

}
