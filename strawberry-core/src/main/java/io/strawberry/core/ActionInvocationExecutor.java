package io.strawberry.core;

/**
 * Created by jamin on 2017/2/13.
 */
public interface ActionInvocationExecutor {

    ActionResponse execute(ActionInvocation invocation);
}
