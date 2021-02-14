package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Document;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Spinner BaseCurrency;
    private Spinner DesiredCurrency;
    public static TextView data;
    public static EditText Result;
    String selection1;
    String selection2;

    Double rate1;
    Double rate2;
    //Setting up Button Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Currency List from Currencyconverter.com
        OkHttpClient currencyClient = new OkHttpClient();
        String currencyURL = "https://free.currconv.com/api/v7/currencies?apiKey=92139c44c58c2a36a2d3";
        Request currencyRequest = new Request.Builder()
                .url(currencyURL)
                .build();
        currencyClient.newCall(currencyRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                //System.out.println("Not Working////////////////////////////////////////////////////////////////////////////////////");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String currencyResponse = response.body().string();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Got The Currency List");

                        }
                    });
                }
            }
        });


        //Populate the spinners from above list.

        //Form URL and get the latest rate for that combo.

        //Calculate and display


//            private class GetUrlContentTask extends AsyncTask<String, Integer, String> {
//                protected String doInBackground(String... urls) {
//                    URL url = new URL(urls[0]);
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setDoOutput(true);
//                    connection.setConnectTimeout(5000);
//                    connection.setReadTimeout(5000);
//                    connection.connect();
//                    BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    String content = "", line;
//                    while ((line = rd.readLine()) != null) {
//                        content += line + "\n";
//                    }
//                    return content;
//                }
//
//                protected void onProgressUpdate(Integer... progress) {
//                }
//
//                protected void onPostExecute(String result) {
//                    // this is executed on the main thread after the process is over
//                    // update your UI here
//                    displayMessage(result);
//                }
//            }


        //Setting up spinner lists.
        BaseCurrency = findViewById(R.id.BaseCurrency);
        DesiredCurrency = findViewById(R.id.DesiredCurrency);

        String[] currencies = getResources().getStringArray(R.array.currencies);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BaseCurrency.setAdapter(adapter);
        DesiredCurrency.setAdapter(adapter);

        BaseCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection1 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "Selected: " + selection1, Toast.LENGTH_SHORT).show();
                // Fetching rates here
                if(selection1.equals("INR"))
                {rate1 = 88.404;}
                else if(selection1.equals("CAD"))
                {rate1 = 1.5384;}
                else if(selection1.equals("USD"))
                {rate1 = 1.2147;}
                else if(selection1.equals("JPY"))
                {rate1 = 127.12;}
                else
                {rate1 = 1.0;}
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });

        DesiredCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "Selected: " + selection2, Toast.LENGTH_SHORT).show();
                // Fetching rates here
                if(selection2.equals("INR"))
                {rate2 = 88.404;}
                else if(selection2.equals("CAD"))
                {rate2 = 1.5384;}
                else if(selection2.equals("USD"))
                {rate2 = 1.2147;}
                else if(selection2.equals("JPY"))
                {rate2 = 127.12;}
                else
                {rate2 = 1.0;}
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });

        //Declaring the button.
        Button btnConvert = findViewById(R.id.btnConvert);
        // What the button does.
        btnConvert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btnConvert(findViewById(R.id.btnConvert));
                System.out.println("Button is working.");
                //FetchData process = new FetchData();
                //process.execute();
            }
            public void btnConvert(View view)
            {
                //System.out.println(selection1);
                //System.out.println(selection2);
                //Rates

                //Calculation
                //System.out.println(rate1 + "--------" + rate2 +"RATESSSSSSSSSSSSSS");
                EditText BaseAmount = (EditText) findViewById(R.id.BaseAmount);
                String Amount = BaseAmount.getText().toString();
                Double doubleAmount = Double.parseDouble(Amount);
                //Double baseCurrencyValue = doubleAmount * rate1;
                Double doubleConverted = doubleAmount * rate2 / rate1;
                //String toastText = "= " + doubleConverted.toString();
                // Printing the result.
                EditText Result = (EditText) findViewById(R.id.Result);
                Result.setText(String.valueOf(doubleConverted));
                //Toast.makeText(this,toastText, Toast.LENGTH_SHORT).show();
            }
        });
    }}

/*    private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new URL(url).openStream());
    }

    public void main(String[] args) throws Exception {
        Document  doc = loadTestDocument("http://www.floatrates.com/daily/usd.xml");
        System.out.println(doc);
        System.out.println("Received the doc......................................................");
    }*/