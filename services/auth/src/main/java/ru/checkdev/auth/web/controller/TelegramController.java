package ru.checkdev.auth.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.checkdev.auth.dto.UserInfoDto;
import ru.checkdev.auth.service.PersonService;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
public class TelegramController {

    private final PersonService personService;

    @GetMapping("/user-info")
    public ResponseEntity<UserInfoDto> getUserInfoChatId(@RequestParam String chatId) {
        return personService.findUserByChatId(chatId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity::notFound().build());
    }
}
