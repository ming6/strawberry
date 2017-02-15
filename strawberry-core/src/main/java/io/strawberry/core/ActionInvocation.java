package io.strawberry.core;

/**
 * Created by jamin on 2017/2/13.
 */
public class ActionInvocation {

    private String name;
    private String method;
    private Object action;
    private ActionRequest request;
    private ActionResponse response;

    private Class<? extends ActionRequest> requestClass;
    private Class<? extends ActionResponse> responseClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getAction() {
        return action;
    }

    public void setAction(Object action) {
        this.action = action;
    }

    public ActionRequest getRequest() {
        return request;
    }

    public void setRequest(ActionRequest request) {
        this.request = request;
    }

    public ActionResponse getResponse() {
        return response;
    }

    public void setResponse(ActionResponse response) {
        this.response = response;
    }

    public Class<? extends ActionRequest> getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(Class<? extends ActionRequest> requestClass) {
        this.requestClass = requestClass;
    }

    public Class<? extends ActionResponse> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<? extends ActionResponse> responseClass) {
        this.responseClass = responseClass;
    }
}
