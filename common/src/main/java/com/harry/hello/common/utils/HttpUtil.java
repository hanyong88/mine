package com.harry.hello.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    /**
     *
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public static String get(String url, Map<String,Object> headers, Map<String,Object> params){
        //构建请求uri
        StringBuilder builder = new StringBuilder(url + "?");
        Set<Map.Entry<String,Object>> entries;
        if (params != null){
            entries = params.entrySet();
            for(Map.Entry<String,Object> entry :entries){
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        HttpGet get = new HttpGet(builder.toString());
        //设置请求头
        if(headers != null){
            entries = headers.entrySet();
            for(Map.Entry<String,Object> entry : entries){
                get.setHeader(entry.getKey(),entry.getValue().toString());
            }
        }
        return request(get);
    }

    public static String post(String url, Map<String,Object> headers, Map<String,Object> params){
        HttpPost post = new HttpPost(url);
        try {
            if(params != null){
                // 构建消息实体
                ObjectMapper mapper = new ObjectMapper();
                String paramStr = mapper.writeValueAsString(params);
                StringEntity entity = new StringEntity(paramStr, Charset.forName("UTF-8"));
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                post.setEntity(entity);
            }
            if(headers != null){
                //设置请求头
                Set<Map.Entry<String,Object>> entries = headers.entrySet();
                for(Map.Entry<String,Object> entry : entries){
                    post.setHeader(entry.getKey(),entry.getValue().toString());
                }
            }
            return request(post);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("请求失败:" + e.getMessage(),e);
        }

    }


    private static String request(HttpUriRequest request){
        HttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(request);
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() != 200){
                throw new RuntimeException("请求失败,Code : " + statusLine.getStatusCode() + ",ReasonPhrase:" + statusLine.getReasonPhrase());
            }
            return EntityUtils.toString(response.getEntity(),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("请求失败:" + e.getMessage(),e);
        }
    }


}
