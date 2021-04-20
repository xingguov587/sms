package com.sms.consumer.confg;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> urls = new ArrayList<String>();

    /**
     * 进入控制器之前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            return true;
        } else {
            response.sendRedirect("/login");
            return false;
        }
    }

    /**
     * 设置能通过的url
     * @return
     */
    public List<String> getUrls() {
        urls.add("/login");
        urls.add("user/login");
        return urls;
    }

}
