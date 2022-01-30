package VoiceRecognition;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.FileInputStream;
import java.io.InputStream;

public class Resources {
    public static void main(String[] args) throws Exception{
        Configuration Configure = new Configuration();
        Configure.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        Configure.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        Configure.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        LiveSpeechRecognizer SpeechRecognizer = new LiveSpeechRecognizer(Configure);
        SpeechRecognizer.startRecognition(true);
        SpeechRecognizer.stopRecognition();
        SpeechResult Result = SpeechRecognizer.getResult();
        while (Result != null){
            System.out.format("Hypothesis: %s \n",Result.getHypothesis());
        }

    }
}
