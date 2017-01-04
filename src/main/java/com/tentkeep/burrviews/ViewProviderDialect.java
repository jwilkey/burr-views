package com.tentkeep.burrviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.HashMap;
import java.util.Map;

@Component
public class ViewProviderDialect extends AbstractDialect implements IExpressionEnhancingDialect {

    @Autowired
    ViewProvider viewProvider;

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        Map<String, Object> objects = new HashMap<>();
        objects.put("viewProvider", viewProvider);
        return objects;
    }

    @Override
    public String getPrefix() {
        return "viewProvider";
    }

}
