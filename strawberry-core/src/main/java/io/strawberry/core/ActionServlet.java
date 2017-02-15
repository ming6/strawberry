package io.strawberry.core;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jamin on 2017/2/13.
 */
public class ActionServlet extends HttpServlet {

    private ActionInvocationRegistry registry;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getHeaders("action_name").nextElement();
        ActionInvocation invocation = registry.getInvocation(actionName);

        String content = IOUtils.toString(req.getReader());
        ActionRequest actionRequest = JSON.parseObject(content, invocation.getRequestClass());

        invocation.setRequest(actionRequest);
//        ActionResponse actionResponse = executor.execute(invocation);
//        invocation.setResponse(actionResponse);

    }
}
