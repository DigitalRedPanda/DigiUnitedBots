package TwitchBot;


import com.github.twitch4j.chat.events.CommandEvent;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunBot implements BotInitiation {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

        TC.getChat().sendMessage(DefaultChannel,String.format("Hello %s, %s has added your channel",DefaultChannel.toLowerCase(),OwnerNickname));
        TC.getEventManager().onEvent(ChannelMessageEvent.class, event -> {
            String CurrentChannel = event.getChannel().getName();
            ArrayList<String> SpammableWords = new ArrayList<>();
            SpammableWords.add("Followers, primes and viewers on");
            SpammableWords.add("SIMP");
            Pattern TraceSpammableWord = Pattern.compile(SpammableWords.get(0),Pattern.CASE_INSENSITIVE);
            //Pattern TraceBannableWord = Pattern.compile/*("/\\SI[^abcdefghjklmnopqrtuvwxyz]"*/("[^abcdefghjklmnopqrtuvwxyzABCDEFGHJKLMNOPQRTUVWXYZ]\\SI[^abcdefghjklmnopqrtuvwxyzABCDEFGHJKLMNOPQRTUVWXYZ]", Pattern.CASE_INSENSITIVE);
            String Sender = event.getUser().getName();
            String Message = event.getMessage();
            //Matcher CatchBannableWord = TraceBannableWord.matcher(Message);
            Matcher CatchSpammableWord = TraceSpammableWord.matcher(Message);
            //boolean BannableWordExists = CatchBannableWord.find();
            if(Scan.FindSI(Message) && CurrentChannel.equalsIgnoreCase("reoina"))
                TC.getChat().sendMessage(CurrentChannel,"/ban "+Sender+ " Said SI");
            if(CatchSpammableWord.find())
            TC.getChat().sendMessage(CurrentChannel,"/ban "+ Sender+" Spamming bot");
            System.out.printf("[%s] %s: %s\n", CurrentChannel,Sender,Message);
        });
        TC.getEventManager().onEvent(CommandEvent.class, commandEvent -> {
            String Sender = commandEvent.getUser().getName();
            String[] Command = commandEvent.getCommand().split(" ");
            String CommandSource = commandEvent.getSource().name();
            System.out.printf("%s used %s command in %s\n", Sender, Command[0], CommandSource);
            if (Command[0].equalsIgnoreCase("vanish"))
                commandEvent.respondToUser("/timeout " + Sender + "6 1 Vanis8hed");

            if (Command[0].equalsIgnoreCase("Add"))
                try {
            BotInitiation.JoinChannel(Command[1]);}
            catch(ArrayIndexOutOfBoundsException A){
                System.err.print("Cannot add an empty channel\n");
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

    }


}