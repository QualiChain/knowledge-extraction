/*
 * Copyright (C) 2014 EIS Uni-Bonn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers;

import controllers.de.fuhsen.wrappers.security.TokenManager;
import play.mvc.*;
import play.Play;
import views.html.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.OutputStream;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

import javax.xml.crypto.dsig.SignatureMethod;


public class Application extends Controller {

    private String keyword; //

    public Result index() {
        return ok(index.render());
    }

    public Result TokenLifeLength(String wrapperId) {
        String life_length = "{ \"life_length\" : \""+TokenManager.getTokenLifeLength(wrapperId)+"\" }";
        return ok(life_length);
    }

    public Result getKeyword(){
        String json_res = "{ \"keyword\" : \""+this.keyword+"\" }";
        return ok(json_res);
    }

    public String postRequest(String keyword, String country, String page) {
        try
        {
            URL url = new URL("https://"+country+Play.application().configuration().getString("jooble.search.url")+Play.application().configuration().getString("jooble.search.api_key."+country));
            //System.out.println(url.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", "17");

            String input = "{keywords:'"+keyword+"',page:'"+ page +"'}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                //return ok("NOT OK "+conn.getResponseCode()+" "+conn.getResponseMessage());
                return "NOT OK "+conn.getResponseCode()+" "+conn.getResponseMessage();
            }
            else {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

                String finalOutput = "";
                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    finalOutput += output;
                }

                conn.disconnect();
                //return ok("OK "+finalOutput);
                return finalOutput;
            }
        //}catch(Exception e) { return ok("NOT OK Exception "+e.getMessage()); }
        }catch(Exception e) { return "NOT OK Exception "+e.getMessage(); }

    }


}