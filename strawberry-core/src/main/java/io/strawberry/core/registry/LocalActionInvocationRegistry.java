package io.strawberry.core.registry;

import io.strawberry.core.ActionInvocation;
import io.strawberry.core.ActionInvocationRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamin on 2017/2/13.
 */
public class LocalActionInvocationRegistry implements ActionInvocationRegistry {

    private static final Map<String, ActionInvocation> invocationMap = new HashMap<>();

    @Override
    public ActionInvocation getInvocation(String name) {
        return invocationMap.get(name);
    }

    @Override
    public void register(String name, ActionInvocation invocation) {
        invocationMap.put(name, invocation);
    }
}
