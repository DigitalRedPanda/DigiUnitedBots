package TwitchBot;
import com.github.twitch4j.eventsub.domain.PredictionOutcome;
import com.github.twitch4j.helix.domain.Prediction;
import java.util.Collection;


public class Predictions {
     String Channel;
     String Title;
     int Duration;
     Collection<?extends PredictionOutcome> WantedOutComes;
public Predictions(String PredictionChannel,String PredictionTitle,int PredictionDuration,Collection<?extends PredictionOutcome> PredictionOutComes){
PredictionChannel = Channel;
PredictionTitle=Title;
PredictionDuration=Duration;
PredictionOutComes = WantedOutComes;
CreatePrediction(Channel,Title,Duration,WantedOutComes);
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
