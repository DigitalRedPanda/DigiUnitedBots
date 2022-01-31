package VoiceRecognition;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

public class Resources{
    static Configuration Configure = new Configuration();
    public static void main(String[] args){
        Configure.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        Configure.setDictionaryPath("src\\main\\resources\\Voicecommands.dic" );
        Configure.setLanguageModelPath("src\\main\\resources\\Voicecommands.lm");
        try {
            LiveSpeechRecognizer SpeechRecognizer = new LiveSpeechRecognizer(Configure);
            SpeechRecognizer.startRecognition(true);
            SpeechResult speechResult;
            while((speechResult = SpeechRecognizer.getResult()) != null){
                String VoiceCommand = speechResult.getHypothesis();
                System.out.printf("Voice command: %s",VoiceCommand);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}