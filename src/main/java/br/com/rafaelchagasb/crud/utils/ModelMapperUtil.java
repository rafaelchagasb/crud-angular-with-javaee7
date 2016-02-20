package br.com.rafaelchagasb.crud.utils;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil{

	public Object convert(Object origem, Class destino){
		
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(origem, destino);
	}
	
	public Collection convert(List origem, Type targetListType ){
		
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(origem, targetListType);
	}
	
}
