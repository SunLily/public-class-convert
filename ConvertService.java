package com.chinaredstar.p_tx_promotion_backend.service.convert;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class ConverService {
	/**
	 * 通用转换方法,源对象,目标对象
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 */	
	public <T,V> List<V> pubCopy(List<T> sourceObj, Class<V> targetObj) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		List<V> l = new ArrayList<>();
		
		for (T t : sourceObj) {
			V v = newTclass(targetObj);
			BeanUtils.copyProperties(v, t);
			l.add(v);
		}
		
		return l;
	}
	
	public <V> V newTclass(Class<V> clazz) throws InstantiationException, IllegalAccessException{
		V v = clazz.newInstance();
		return v;
	}
	
	
	
}
