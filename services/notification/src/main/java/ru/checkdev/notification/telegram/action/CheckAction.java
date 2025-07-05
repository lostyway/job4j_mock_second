package ru.checkdev.notification.telegram.action;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.checkdev.notification.telegram.service.TgAuthCallWebClient;

public class CheckAction implements Action {
    private final TgAuthCallWebClient webClient;

    public CheckAction(TgAuthCallWebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public BotApiMethod<Message> handle(Message message) {
        String chatId = message.getChatId().toString();

        var userInfo = webClient.getUserInfoChatId(chatId);
    }

    @Override
    public BotApiMethod<Message> callback(Message message) {
        return handle(message);
    }
}
