package com.mzuiit.states;

import application.context.ApplicationContext;
import application.context.annotation.Component;
import application.context.annotation.Message;
import application.context.annotation.State;
import java.util.HashMap;
import java.util.Map;
import org.fluentd.logger.FluentLogger;
import org.telegram.telegrambots.meta.api.objects.Update;

@State
@Component
public class InitialState {
    private static FluentLogger logger = FluentLogger.getLogger("app", "127.0,0.1", 8080);

    @Message(message = "*")
    public void getInfo(Update update){
        int userId = ApplicationContext.getCurrentUserId();
        String username = update.getMessage().getFrom().getUserName();
        Map<String, Object> data = putUserDataInMap(userId, username);
        System.out.println(userId + " " + username);
        logger.log("UserData", data);

    }

    private Map<String, Object> putUserDataInMap(int userId, String username) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("UserId", userId);
        data.put("userName", username);
        return data;
    }

}
