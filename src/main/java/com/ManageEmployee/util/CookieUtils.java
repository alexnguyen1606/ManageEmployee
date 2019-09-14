package com.ManageEmployee.util;

import com.ManageEmployee.dto.RoleDTO;
import com.ManageEmployee.dto.UserDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CookieUtils {
    public static final int age=24*60*60;
    public void createCookieByUser(UserDTO user, HttpServletResponse response){
        Cookie cookie1 = new Cookie("USERNAME",user.getUsername());
        cookie1.setMaxAge(age);
        response.addCookie(cookie1);
        List<RoleDTO> roleDTO= new ArrayList<>(user.getListRole());
        StringBuilder roles = new StringBuilder();
        for (RoleDTO role: roleDTO) {
                roles.append(role.getCode());
        }
        Cookie cookie2 = new Cookie("ROLES",roles.toString());
        cookie2.setMaxAge(age);
        response.addCookie(cookie2);
    }
    public void removeCookieByUser(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

    }
    public String getValueUsernameCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String byWho="";
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("USERNAME")){
                byWho = cookie.getValue();
            }
        }
        return byWho;
    }
}
