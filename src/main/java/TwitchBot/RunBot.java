package TwitchBot;


import com.github.twitch4j.chat.events.CommandEvent;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.eventsub.events.ChannelPredictionBeginEvent;
import com.github.twitch4j.eventsub.events.ChannelUnbanEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunBot implements BotInitiation {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

        //BotInitiation.InitializeBot();
        //CM.registerIdentityProvider(new TwitchIdentityProvider(ClientID,ClientSecret,RedirectURL));
        TC.getChat().sendMessage(DefaultChannel,String.format("Hello %s, %s has added your channel",DefaultChannel.toLowerCase(),OwnerNickname));
        TC.getEventManager().onEvent(ChannelMessageEvent.class, event -> {
            String CurrentChannel = event.getChannel().getName();
            ArrayList<String> SpammableWords = new ArrayList<>();
            SpammableWords.add("Followers, primes and viewers on");
            SpammableWords.add("SIMP");
            Pattern TraceSpammableWord = Pattern.compile(SpammableWords.get(0),Pattern.CASE_INSENSITIVE);
            Pattern TraceBannableWord = Pattern.compile/*("/\\SI[^abcdefghjklmnopqrtuvwxyz]"*/("[^abcdefghjklmnopqrtuvwxyzABCDEFGHJKLMNOPQRTUVWXYZ]\\SI[^abcdefghjklmnopqrtuvwxyzABCDEFGHJKLMNOPQRTUVWXYZ]", Pattern.CASE_INSENSITIVE);
            String Sender = event.getUser().getName();
            String Message = event.getMessage();
            Matcher CatchBannableWord = TraceBannableWord.matcher(Message);
            Matcher CatchSpammableWord = TraceSpammableWord.matcher(Message);
            boolean BannableWordExists = CatchBannableWord.find();
            if(Scan.FindSI(Message)/*&& CurrentChannel.equalsIgnoreCase("reoina") && !*/)
                TC.getChat().sendMessage(CurrentChannel,"/ban "+Sender+ " Said SI");
            if(CatchSpammableWord.find())
            TC.getChat().sendMessage(CurrentChannel,"/ban "+ Sender+" Spamming bot");
            System.out.printf("\n[%s] %s: %s", CurrentChannel,Sender,Message);
        });
        TC.getEventManager().onEvent(CommandEvent.class, commandEvent -> {
            String Sender = commandEvent.getUser().getName();
            String[] Command = commandEvent.getCommand().split(" ");
            String CommandSource = commandEvent.getSource().name();
            System.out.printf("\n%s used %s command in %s", Sender, Command[0], CommandSource);
            if (Command[0].equalsIgnoreCase("vanish"))
                commandEvent.respondToUser("/timeout " + Sender + " 1 Vanished");
            /*if(Command[0].equalsIgnoreCase("CreatPrediction")) {//

            }*/
            if (Command[0].equalsIgnoreCase("Add"))
                try {
            BotInitiation.JoinChannel(Command[1]);}
            catch(ArrayIndexOutOfBoundsException A){
                System.err.print("\nCannot add an empty channel");
                TC.getChat().sendMessage(DefaultChannel,"Cannot join an empty channel");
}            if (Command[0].equalsIgnoreCase("Leave")) {
                try{
                BotInitiation.LeaveChannel(Command[1]);
            }   catch(ArrayIndexOutOfBoundsException A){
                System.err.print("\nCannot leave an empty channel");
                TC.getChat().sendMessage(DefaultChannel,"Cannot leave an empty channel");
            }
            }

        });
    TC.getEventManager().onEvent(ChannelPredictionBeginEvent.class, prediction ->{
        System.out.printf("\n[%s] prediction:%s Started at:%s ", prediction.getBroadcasterUserName(),prediction.getTitle(),prediction.getStartedAt());
            TC.getChat().sendMessage(prediction.getBroadcasterUserName(), String.format("We have started %s prediction on %s, bet wisely chat DinkDonk", prediction.getTitle(), prediction.getStartedAt()));
    });
        TC.getEventManager().onEvent(ChannelUnbanEvent.class, UnBanned ->{
        System.out.printf("\n[%s] %s unbanned %s",UnBanned.getBroadcasterUserName(),UnBanned.getModeratorUserName(),UnBanned.getUserName());

    });

    }

}