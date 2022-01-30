package TwitchBot;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.CredentialManagerBuilder;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.core.EventManager;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

public interface BotInitiation extends TwitchBotResources {
//        String MessageSender;
        CredentialManager CM = CredentialManagerBuilder.builder().build();
        OAuth2Credential credential = new OAuth2Credential("twitch", Token);
        EventManager eventManager = new EventManager();
        TwitchClient TC = TwitchClientBuilder.builder()
                .withCredentialManager(CM)
                .withEnableGraphQL(true)
                .withEnableChat(true)
                .withClientSecret(ClientSecret)
                .withChatAccount(credential)
                .withDefaultAuthToken(credential)
                .withClientId(ClientID)
                .withCommandTrigger(prefix)
                .withDefaultEventHandler(SimpleEventHandler.class)
                //.withEnablePubSub(true)
                //.getEventManager(eventManager.getEventHandler(""))
                //.withEventManager(eventManager)
                .build();

        /*TwitchGraphQL client = TwitchGraphQLBuilder.builder()
                .withEventManager(EventManager.class)
                .build();*/


      //  String InitializationCompletion = String.format("Hello, Digi told me there are good communities mentioning %s's community along them, hi cuties peepoHappy /",DefaultChannel);
    /*static String getUserName(){

        TC.getEventManager().onEvent(ChannelMessageEvent.class, Message ->{
             MessageSender = Message.getUser().getName();
            return MessageSender;
        });

    }*/

    static void InitializeBot() {
       JoinChannel(DefaultChannel);
    }
    static void JoinChannel(String ChannelToJoin){
if(!TC.getChat().isChannelJoined(ChannelToJoin)){
    TC.getChat().joinChannel(ChannelToJoin);
    TC.getChat().sendMessage(ChannelToJoin,String.format("Hello %s, %s has added your channel",ChannelToJoin.toLowerCase(),OwnerNickname));
}else{
    TC.getChat().sendMessage(DefaultChannel, String.format("%s is already joined", ChannelToJoin));

}
    }
static void LeaveChannel(String ChannelToLeave){

        if(TC.getChat().isChannelJoined(ChannelToLeave)) {
               TC.getChat().sendMessage(ChannelToLeave, String.format("Hello %s, %s has removed your channel", ChannelToLeave.toLowerCase(), OwnerNickname));
               TC.getChat().leaveChannel(ChannelToLeave);
            }
        else{
                TC.getChat().sendMessage(DefaultChannel,String.format("%s isn't joined", ChannelToLeave));
            }



}}
