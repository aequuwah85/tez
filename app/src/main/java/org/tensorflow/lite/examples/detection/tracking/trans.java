package org.tensorflow.lite.examples.detection.tracking;

import android.content.Context;
import android.os.StrictMode;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import org.tensorflow.lite.examples.detection.R;

import java.io.IOException;
import java.io.InputStream;

public class trans {
    private Context context;
    Translate translate;
    public  trans(Context current) {
        this.context=current;
    }
    public void getTranslateService() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try (InputStream is = context.getResources().openRawResource(R.raw.credentials)) {

            //Get credentials:
            final GoogleCredentials myCredentials = GoogleCredentials.fromStream(is);

            //Set credentials and get translate service:
            TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(myCredentials).build();
            translate = translateOptions.getService();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }
    public String translate(String data) {
        String originalText,result;
        //Get input text to be translated:
        originalText = data;
        Translation translation = translate.translate(originalText, Translate.TranslateOption.targetLanguage("tr"), Translate.TranslateOption.model("base"));
        result = translation.getTranslatedText();

        //Translated text and original text are set to TextViews:
        return result;

    }

}
