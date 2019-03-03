package com.app.mytodo.mytodo.controllers;


import com.app.mytodo.mytodo.config.security.SecurityUtils;
import com.app.mytodo.mytodo.models.User;
import com.app.mytodo.mytodo.utils.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.app.mytodo.mytodo.utils.Constants.TOKEN;


@RestController
@RequestMapping("/api/todo/user/auth")
public class UserAuthController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login() {
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException {
        SecurityUtils.deleteCookie(httpResponse);

        Optional<String> token = Optional.ofNullable(httpRequest.getHeader(TOKEN));
        tokenService.clear(token.get());

        httpRequest.logout();
    }

    @RequestMapping(value = "logged", method = RequestMethod.GET)
    public Boolean isAuthenticated() {
        return SecurityUtils.isAuthenticated();
    }

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public User getUser() {
        return SecurityUtils.getAuthenticatedUser();
    }
}
