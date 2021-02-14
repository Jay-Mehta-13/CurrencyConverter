package com.example.currencyconverter;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    @Override
    protected Void doInBackground(Void... voids) {

        URL url = null;
        try {
            //System.out.println("Before /////////////////////// ");
            url = new URL("https://openexchangerates.org/api/latest.json");
            //System.out.println("after //////////////////////// ");
            //System.out.println("Before /////////////////////// ");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //System.out.println("after //////////////////////// ");
            System.out.println("before //////////////////////// ");
            InputStream inputStream = httpURLConnection.getInputStream();
            System.out.println("after //////////////////////// ");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null)
                line = bufferedReader.readLine();
            data = data + line;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.data);
    }
}
//Generating Array for rates
        /*String rates_array = "{\"rates\":" +
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

        // Fetch JSON Array
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(rates_array);
            JSONArray jsonArray = jsonObject.getJSONArray("rates");
          //Recognized the JSON array.
            for (int i=0; i<jsonArray.length(); i++)
            {
                JSONObject object = jsonArray.getJSONObject(i);
                System.out.println(object + "//////////////////////////////////////////////////////");
                String rates = object.getString("INR");
                arrayList.add(rates);
                System.out.println(arrayList);
                System.out.println("???????????????????????????????????????????????????????????????");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Not Working !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }*/