package com.devotel.userservice.soap.user;

import com.devotel.userservice.domain.User;
import com.devotel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserSoapEndpoint {

    private static final String NAMESPACE_URI = "http://soap.user.devotel.com";

    @Autowired
    private UserRepository userRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserSoap userSoap = new UserSoap();
        userSoap.setId(user.getId());
        userSoap.setName(user.getName());
        userSoap.setEmail(user.getEmail());

        GetUserResponse response = new GetUserResponse();
        response.setUser(userSoap);

        return response;
    }
}
