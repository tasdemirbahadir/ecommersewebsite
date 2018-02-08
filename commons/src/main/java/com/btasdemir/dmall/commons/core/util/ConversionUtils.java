package com.btasdemir.dmall.commons.core.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ConversionUtils {
	
	public <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
	    return from.stream().sequential().map(func).collect(Collectors.toList());
	}

}
