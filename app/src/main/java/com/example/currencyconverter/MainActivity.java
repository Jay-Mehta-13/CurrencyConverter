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
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Document;

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
    }

/*    private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new URL(url).openStream());
    }

    public void main(String[] args) throws Exception {
        Document  doc = loadTestDocument("http://www.floatrates.com/daily/usd.xml");
        System.out.println(doc);
        System.out.println("Received the doc.....................................................");
    }*/
String rates_array = "{\"rates\":" +
        "{\"CAD\":1.5384," +
        "\"HKD\":9.4171," +
        "\"ISK\":155.8," +
        "\"PHP\":58.343," +
        "\"DKK\":7.438," +
        "\"HUF\":357.18," +
        "\"CZK\":25.772," +
        "\"AUD\":1.5638," +
        "\"RON\":4.8745," +
        "\"SEK\":10.0868," +
        "\"IDR\":16963.1," +
        "\"INR\":88.404," +
        "\"BRL\":6.4936," +
        "\"RUB\":89.3792," +
        "\"HRK\":7.5688," +
        "\"JPY\":127.12," +
        "\"THB\":36.271," +
        "\"CHF\":1.0802," +
        "\"SGD\":1.608," +
        "\"PLN\":4.4975," +
        "\"BGN\":1.9558," +
        "\"TRY\":8.5254," +
        "\"CNY\":7.8448," +
        "\"NOK\":10.2595," +
        "\"NZD\":1.6772," +
        "\"ZAR\":17.7533," +
        "\"USD\":1.2147," +
        "\"MXN\":24.2037," +
        "\"ILS\":3.9531," +
        "\"GBP\":0.87755," +
        "\"KRW\":1339.97," +
        "\"MYR\":4.9104}," +
        "\"base\":\"EUR\"," +
        "\"date\":\"2021-02-11\"}";
    JSONArray ratesJson;
    {
        try {
            ratesJson = new JSONArray(rates_array);
            System.out.println(ratesJson + "......................................................");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

