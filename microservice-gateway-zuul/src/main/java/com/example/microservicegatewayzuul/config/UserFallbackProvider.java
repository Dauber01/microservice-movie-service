package com.example.microservicegatewayzuul.config;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author Lucifer
 * @do 实现自定义回退的配置
 * @date 2018/04/08 9:41
 */
@Component
public class UserFallbackProvider implements ZuulFallbackProvider{

    @Override
    public String getRoute() {
        //表明是为哪个微服务提供回退
        return "microservice-simple-provider-user";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                //fallback时使用的状态码
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //数字类型的状态码,本例返回的为200；
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                //状态文本,本例返回的其实就是OK,详见HttpStatus
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                //相应体
                return new ByteArrayInputStream("用户微服务不可用,请稍后在试~".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                //header设定
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                httpHeaders.setContentType(mt);
                return httpHeaders;
            }
        };
    }
}
