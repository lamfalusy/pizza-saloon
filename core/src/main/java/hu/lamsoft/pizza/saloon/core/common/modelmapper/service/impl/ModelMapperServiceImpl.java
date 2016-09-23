package hu.lamsoft.pizza.saloon.core.common.modelmapper.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import hu.lamsoft.pizza.saloon.core.common.modelmapper.service.ModelMapperService;

public class ModelMapperServiceImpl implements ModelMapperService{

	private ModelMapper modelMapper;
	
	public ModelMapperServiceImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@Override
	public <S, T> T convert(S source, Class<T> targetType) {
	    Assert.notNull(targetType);
	    if(source != null) {
	    	return modelMapper.map(source, targetType);
	    } else {
	    	return null;
	    }
	}

	@Override
	public <S, T> List<T> convert(List<S> sourceList, Class<T> targetType) {
		Assert.notNull(targetType);
		if(sourceList != null) {
			List<T> targetList = new ArrayList<>(sourceList.size());
			for (S s : sourceList) {
				targetList.add(modelMapper.map(s, targetType));
			}
			return targetList;
		} else {
			return null;
		}
	}

}
