package assistant.sk.org.myassistant;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements TextToSpeech.OnInitListener {

    TextView tvClick;
    ArrayList<String> list = new ArrayList<String>();
    private WifiManager wifiManager;

    public void knowMe(View view){
        tvClick.setText("");
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.click_animation));
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(300);

        String me = "Hello, this is Scarlet, i am your assistant, Click on speak button to talk";
        mTts.speak(me,
                TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                null);

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // Note that a language may not be available, and the result will indicate this.
            int result = mTts.setLanguage(Locale.US);
            // Try this someday for some interesting results.
            // int result mTts.setLanguage(Locale.FRANCE);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Lanuage data is missing or the language is not supported.
                //Log.e(TAG, "Language is not available.");
            } else {
                // Check the documentation for other possible result codes.
                // For example, the language may be available for the locale,
                // but not for the specified country and variant.

                // The TTS engine has been successfully initialized.
                // Allow the user to press the button for the app to speak again.
               // mAgainButton.setEnabled(true);
                // Greet the user.
                //sayHello();
            }
        } else {
            // Initialization failed.

        }

    }

    private TextToSpeech mTts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        mTts = new TextToSpeech(this,
                this  // TextToSpeech.OnInitListener
        );
    }

    public void speechToText(View view){
        tvClick.setText("");
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.click_animation));
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(300);

            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

            // Specify the calling package to identify your application
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());

            // Display an hint to the user about what he should say.
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech recognition demo");

            // Given an hint to the recognizer about what the user is going to say
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

            // Specify how many results you want to receive. The results will be sorted
            // where the first result is the one with higher confidence.
            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);

            // Specify the recognition language. This parameter has to be specified only if the
            // recognition has to be done in a specific language and not the default one (i.e., the
            // system locale). Most of the applications do not have to set this parameter.


            startActivityForResult(intent, 1);





    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Fill the list view with the strings the recognizer thought it could have heard
            ArrayList<String> matches = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            StringBuilder builder = new StringBuilder();
            for (String str : matches) {
                builder.append(str);
                // Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG).show();
            }
            if (builder.toString().contains("name")) {
                String speak1 = "my name is  scarlett";
                mTts.speak(speak1,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);


            }

            else if (builder.toString().contains("how are you")) {

                String speak2 = "i am fine";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            } else if (builder.toString().contains("you are beautiful")||builder.toString().contains("you are smart")||builder.toString().contains("you are sexy")||builder.toString().contains("you are sweet")||builder.toString().contains("you are gorgeous")||builder.toString().contains("you are cute")) {

                String speak2 = "thank you";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }else if (builder.toString().contains("hello")||builder.toString().contains("hii")) {

                String speak2 = "hello";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }
            else if (builder.toString().contains("good morning")) {

                String speak2 = "good morning";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }
            else if (builder.toString().contains("good night")) {

                String speak2 = "good night";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }
            else if (builder.toString().contains("good afternoon")) {

                String speak2 = "good afternoon";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }
            else if (builder.toString().contains("good evening")) {

                String speak2 = "good evening";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }


            else if (builder.toString().contains("camera")) {

                String speak2 = "okay";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camIntent);

            }

            else if (builder.toString().contains("dialer")) {

                String speak2 = "okay";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(dialIntent);

            }

            else if (builder.toString().contains("contacts")) {

                String speak2 = "okay";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                Intent conIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivity(conIntent);
            }

            else if (builder.toString().contains("browser")) {

                String speak2 = "okay";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                Intent browseIntent = new Intent();
                browseIntent.setAction(Intent.ACTION_VIEW);
                browseIntent.setData(android.net.Uri.parse("http://www.google.com"));
                startActivity(browseIntent);
            }

            else if (builder.toString().contains("sms")) {

                String speak2 = "okay";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");

                startActivity(smsIntent);
            }else if(builder.toString().contains("alarm")) {

                String speak2 = "okay";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);

                Intent openClockIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                openClockIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(openClockIntent);

            }




            else {

                String speak2 = "sorry,i am not getting you";
                mTts.speak(speak2,
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
            }

            builder.replace(0,builder.length()," ");
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    protected void onStart() {
        //ImageView myImageView = (ImageView) findViewById(R.id.imgAssistant);
        tvClick = (TextView) findViewById(R.id.tvClick);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
        tvClick.startAnimation(myFadeInAnimation);
        String[] projection = new String[] {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        // getting the instance of the ContentResolver
        ContentResolver cr = getContentResolver();
        // getting the instance of the Cursor
        Cursor managedCursor = cr.query(uri, projection, null, null, null);

        // accessing data by using Cursor object
        managedCursor.moveToFirst();


        do {
            int nameFieldColumnIndex = managedCursor
                    .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String name = managedCursor.getString(nameFieldColumnIndex);

            int numberFieldColumnIndex = managedCursor
                    .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = managedCursor.getString(numberFieldColumnIndex);

           // Toast.makeText(getBaseContext(),name+" "+number,Toast.LENGTH_LONG).show();

            list.add(name+" "+number);


        } while (managedCursor.moveToNext());




        super.onStart();
    }



    public void onDestroy() {
        // Don't forget to shutdown!
        if (mTts != null) {
            mTts.stop();
            mTts.shutdown();
        }

        super.onDestroy();
    }

}
