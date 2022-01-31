package TwitchBot;
import com.github.twitch4j.eventsub.domain.PredictionOutcome;
import com.github.twitch4j.helix.domain.Prediction;
import java.util.Collection;


public class Predictions {
     String Channel=null;
     String Title=null;
     int Duration=0;
     Collection<?extends PredictionOutcome> WantedOutComes;
public Predictions(){
    String PredictionChannel = Channel;
    String PredictionTitle = Title;
    int PredictionDuration = Duration;
    Collection<? extends PredictionOutcome> PredictionOutComes = WantedOutComes;
CreatePrediction(PredictionChannel,PredictionTitle,PredictionDuration,PredictionOutComes);
}

    static void CreatePrediction(String ChannelOfPrediction,String PredictionTitle, int PredictionDuration, Collection<?extends PredictionOutcome> PredictionOutcomes){
    Prediction.PredictionBuilder builder = Prediction.builder();
    builder.broadcasterName(ChannelOfPrediction);
    builder.title(PredictionTitle);
    builder.predictionWindowSeconds(PredictionDuration);
    builder.outcomes(PredictionOutcomes);
    builder.build();

}
}
