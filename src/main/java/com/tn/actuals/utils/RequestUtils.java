package com.tn.actuals.utils;

import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.util.*;

@Component
public class RequestUtils {

    public String decode(String input){
        if(input == null || input.equals("none")){
            return null;
        }
        try{
            input = URLDecoder.decode(input, "UTF-8");
        }catch(Exception exp){

        }
        return input;
    }

    public String decodeSpace(String input){

        try {
            if (input != null) {
                input = input.replace("+", " ");
            }

            input = java.net.URLDecoder.decode(input, "UTF-8");
        }catch(Exception exp){

        }
        return input;
    }

    public Map<String, String> getJsonParameterMap(String request){
        Map<String, String> params = new HashMap();

        StringTokenizer st1 = new StringTokenizer(request, "=");
        params.put(st1.nextToken(), st1.nextToken());
        return params;
    }

    public Map<String, String> getParameterMap(String request){
        Map<String, String> params = new HashMap();
        StringTokenizer st = new StringTokenizer(request, "&");

        while(st.hasMoreTokens()){
            StringTokenizer st1 = new StringTokenizer(st.nextToken(), "=");
            params.put(st1.nextToken(), st1.nextToken());
        }
        return params;
    }

    public Map<String, Object> getObjectParameterMap(String request){

        System.out.println(request);
        Map<String, Object> params = new HashMap();
        StringTokenizer st = new StringTokenizer(request, "&");
        while(st.hasMoreTokens()) {
            StringTokenizer st1 = new StringTokenizer(st.nextToken(), "=");
            String key = st1.nextToken();
            String value = st1.nextToken();

            if (key.contains("[]")){
                List<String> l = new ArrayList();
                if(params.get(key)!=null){
                    l = (List<String>) params.get(key);
                }
                l.add(value);
                params.put(key, l);
            }else{
                params.put(key, value);
            }
        }
        return params;
    }

    public Map<String, List<String>> getParameterObjectListMap(String request){
        Map<String, List<String>> params = new HashMap();
        StringTokenizer st = new StringTokenizer(request, "&");
        while(st.hasMoreTokens()) {
            StringTokenizer st1 = new StringTokenizer(st.nextToken(), "=");
            String key = st1.nextToken();
            String value = st1.nextToken();

            List<String> l = new ArrayList();
            if(key.contains("[]")){
                key = key.replace("[]", "").trim();
            }
            if(params.get(key)!=null){
                l = params.get(key);
            }
            l.add(value);
            params.put(key, l);

        }
        return params;
    }
}