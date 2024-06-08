package org.example.project.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService; // Assume you have a userService to get user details
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                             HttpSession session) throws Exception {


        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        String email = userDetails.getUsername();
        User user = this.userService.findByUserName(email);

        request.setAttribute("user", user); // Add user object to the request
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Not needed for adding user data
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Not needed for adding user data
    }
}
