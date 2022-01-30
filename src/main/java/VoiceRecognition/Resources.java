package VoiceRecognition;

import edu.cmu.sphinx.api.Configuration;

public class Resources {
    public static void main(String[] args){
        Configuration Configure = new Configuration();
        Configure.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        Configure.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        Configure.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

    }
}
