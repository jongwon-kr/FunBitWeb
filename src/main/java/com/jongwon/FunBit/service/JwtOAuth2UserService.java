package com.jongwon.FunBit.service;

import com.jongwon.FunBit.Entity.EmailUser;
import com.jongwon.FunBit.dto.GoogleResponse;
import com.jongwon.FunBit.dto.JWTOAuth2User;
import com.jongwon.FunBit.dto.NaverResponse;
import com.jongwon.FunBit.dto.OAuth2Response;
import com.jongwon.FunBit.repository.EmailUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class JwtOAuth2UserService extends DefaultOAuth2UserService {

    private final EmailUserRepository emailUserRepository;

    @Autowired
    public JwtOAuth2UserService(EmailUserRepository emailUserRepository) {
        this.emailUserRepository = emailUserRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {

            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
        EmailUser existData = emailUserRepository.findByUsername(username);

        //추후 작성
        String role = "ROLE_USER";
        if (existData == null) {
            EmailUser emailUser = new EmailUser();
            emailUser.setUsername(username);
            emailUser.setEmail(oAuth2Response.getEmail());
            emailUser.setRole(role);

            emailUserRepository.save(emailUser);
        } else {
            existData.setUsername(username);
            existData.setEmail(oAuth2Response.getEmail());

            role = existData.getRole();

            emailUserRepository.save(existData);
        }
        return new JWTOAuth2User(oAuth2Response, role);
    }
}
