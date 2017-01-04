package com.tentkeep.burrviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.AbstractContext;

import java.util.Map;

@Component
public class ThymeleafViewProvider implements ViewProvider {

    @Autowired
    FragmentRegistry fragmentRegistry;

    @Override
    public String get(String viewIdentifier, AbstractContext context, Map<String, Object> args) {
        String fragmentSelector = fragmentRegistry.get(viewIdentifier);

        String argsList = "";
        for (Map.Entry<String, Object> arg : args.entrySet()) {
            context.setVariable(arg.getKey(), arg.getValue());
            if (argsList.length() > 0) {
                argsList += ",";
            }
            argsList += arg.getKey() + "=${" + arg.getKey() + "}";
        }

        return fragmentSelector + " (" + argsList + ")";
    }

    @Override
    public String get(String viewIdentifier) {
        return fragmentRegistry.get(viewIdentifier);
    }

}
