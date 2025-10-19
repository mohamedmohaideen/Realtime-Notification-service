package com.deena.Realtime_Notification_service.Controller;

import com.deena.Realtime_Notification_service.Model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat"; // This will render src/main/resources/templates/chat.html
    }

    @PostMapping("/send-notification")
    @ResponseBody
    public void sendNotification(@RequestBody String message) {
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }

    @GetMapping("/send-dummy-notifications")
    @ResponseBody
    public void sendDummyNotifications() {
        List<String> dummyNotifications = Arrays.asList(
                "Notification 1: Welcome!",
                "Notification 2: You have a new message.",
                "Notification 3: Your account has been updated.",
                "Notification 4: New comment on your post.",
                "Notification 5: Friend request received."
        );

        dummyNotifications.forEach(msg ->
                messagingTemplate.convertAndSend("/topic/notifications", msg)
        );
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/notifications")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }
}
