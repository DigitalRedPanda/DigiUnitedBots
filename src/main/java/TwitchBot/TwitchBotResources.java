package TwitchBot;


import io.github.cdimascio.dotenv.Dotenv;

public interface TwitchBotResources {
    Dotenv dotenv = Dotenv.configure()
            .directory(".\\assets")
            .filename(".env")
            .load();
    String ClientSecret = dotenv.get("CLIENT_SECRET");
    String Token = dotenv.get("TOKEN");
    String ClientID = dotenv.get("CLIENT_ID");
    String RedirectURL = dotenv.get("REDIRECT_URL");
    String DefaultChannel = dotenv.get("DEFAULT_CHANNEL");
    String OwnerNickname = DefaultChannel.substring(0,4);
    String prefix = dotenv.get("PREFIX");

}
