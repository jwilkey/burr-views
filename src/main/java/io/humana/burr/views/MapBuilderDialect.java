package io.humana.burr.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.HashMap;
import java.util.Map;

public class MapBuilderDialect extends AbstractDialect implements IExpressionEnhancingDialect {

    @Autowired
    MapBuilder mapBuilder;

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        Map<String, Object> objects = new HashMap<>();
        objects.put("mapBuilder", mapBuilder);
        return objects;
    }

    @Override
    public String getPrefix() {
        return "mapBuilder";
    }

}