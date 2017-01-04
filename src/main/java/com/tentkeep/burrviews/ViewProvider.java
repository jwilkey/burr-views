package com.tentkeep.burrviews;

import org.thymeleaf.context.AbstractContext;

import java.util.Map;

public interface ViewProvider {

    String get(String viewIdentifier, AbstractContext context, Map<String, Object> args);
    String get(String viewIdentifier);

}