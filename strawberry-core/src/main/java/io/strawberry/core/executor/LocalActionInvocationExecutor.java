package io.strawberry.core.executor;

import io.strawberry.core.ActionInvocation;
import io.strawberry.core.ActionInvocationExecutor;
import io.strawberry.core.ActionResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jamin on 2017/2/13.
 */
public class LocalActionInvocationExecutor implements ActionInvocationExecutor {

    @Override
    public ActionResponse execute(ActionInvocation invocation) {
        Object action = invocation.getAction();
        try {
            Method method = action.getClass().getMethod(invocation.getMethod(), invocation.getRequestClass());
            return (ActionResponse) method.invoke(action, invocation.getRequest());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
