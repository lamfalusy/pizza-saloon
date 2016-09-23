package hu.lamsoft.pizza.saloon.core.common.modelmapper.service;

import java.util.List;

public interface ModelMapperService {

	public <S, T> T convert(S source, Class<T> targetType);
	
	public <S, T> List<T> convert(List<S> sourceList, Class<T> targetType);
	
}
