/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;

/**
 *
 * @author christian
 */
public class UserInterceptor extends AbstractInterceptor{

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation inv) throws Exception {
        Map<String, Object> session = inv.getInvocationContext().getSession();
         // Object user = session.get("user");
         if (session.get("userId")==null){
             return "welcome";
         } else
        return inv.invoke();
    }

  
}
