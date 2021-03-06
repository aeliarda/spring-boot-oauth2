package com.safetech;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    
    @GetMapping("/")
    public String home(Principal principal)
    {

        @SuppressWarnings("unchecked") 
        Map<String, Object> authDetails= ((Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails());

        String userName = (String) authDetails.get("name");

        return "Hey " + userName + ", Welcome to SAFE Tech solutions!";

    }
}
