package com.devotel.profileservice.soap;

import com.devotel.profileservice.dto.UserDto;
import com.devotel.user.soap.GetUserRequest;
import com.devotel.user.soap.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class UserSoapClient {


    private final WebServiceTemplate webServiceTemplate;

    public UserSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public UserDto getUserById(Long id) {
        GetUserRequest request = new GetUserRequest();
        request.setId(id);

        GetUserResponse response = (GetUserResponse)
                webServiceTemplate.marshalSendAndReceive("http://localhost:8081/ws", request);

        if (response.getUser() == null) return null;

        return new UserDto(response.getUser().getId(), response.getUser().getName(), response.getUser().getEmail());
    }
}
