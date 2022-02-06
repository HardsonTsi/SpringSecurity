package com.openclassrooms.springsecurity.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class LoginController {

    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    public LoginController(OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }

    @RequestMapping("/**")
    @RolesAllowed("USER")
    public String getUsers(){
        return "Welcome User";
    }

    @RequestMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getAdmin(){
        return "Welcome Admin";
    }

    @RequestMapping("/*")
    public String getGithub(Principal user){
        return user.toString();
    }
}
