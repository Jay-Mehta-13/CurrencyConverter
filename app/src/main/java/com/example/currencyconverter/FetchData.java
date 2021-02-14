/*package com.example.currencyconverter;

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
            url = new URL("https://free.currconv.com/api/v7/convert?q=USD_INR&compact=ultra&apiKey=92139c44c58c2a36a2d3");
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
