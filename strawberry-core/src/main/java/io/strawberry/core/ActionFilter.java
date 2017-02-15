package io.strawberry.core;

import com.alibaba.fastjson.JSON;
import io.strawberry.core.executor.LocalActionInvocationExecutor;
import io.strawberry.core.registry.LocalActionInvocationRegistry;
import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jamin on 2017/2/13.
 */
public class ActionFilter implements Filter {

    private ActionInvocationRegistry registry;
    private ActionInvocationExecutor executor;

    public ActionFilter(){
        this.registry = new LocalActionInvocationRegistry();
        this.executor = new LocalActionInvocationExecutor();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String actionName = httpRequest.getHeaders("action_name").nextElement();
        ActionInvocation invocation = registry.getInvocation(actionName);

        String content = IOUtils.toString(httpRequest.getReader());
        ActionRequest actionRequest = JSON.parseObject(content, invocation.getRequestClass());
        invocation.setRequest(actionRequest);
        ActionResponse actionResponse = executor.execute(invocation);
        invocation.setResponse(actionResponse);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
