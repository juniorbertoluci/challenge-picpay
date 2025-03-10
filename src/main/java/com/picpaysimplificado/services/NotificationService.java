package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sedNotification(User user, String message) throws Exception{
        String email = user.getEmail();
        NotificationDTO nofificationRequest = new NotificationDTO(email, message);

        /*ResponseEntity<String> notificationResponse =
                restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", nofificationRequest, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            throw new Exception("Falha na notificação!");
        }*/

    }

}
