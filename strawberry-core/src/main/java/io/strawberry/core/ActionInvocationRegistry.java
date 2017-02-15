package io.strawberry.core;

/**
 * Created by jamin on 2017/2/13.
 */
public interface ActionInvocationRegistry {

    ActionInvocation getInvocation(String name);

    void register(String name, ActionInvocation invocation);
}
