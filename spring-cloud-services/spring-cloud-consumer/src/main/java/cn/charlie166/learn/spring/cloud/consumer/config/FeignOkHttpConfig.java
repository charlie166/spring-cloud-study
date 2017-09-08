package cn.charlie166.learn.spring.cloud.consumer.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Bean
    public OkHttpClient okHttpClient(){
    	logger.debug("FeignOkHttpConfig 初始化...................");
    	return new OkHttpClient.Builder()
    		.readTimeout(60, TimeUnit.SECONDS) 
            .connectTimeout(60, TimeUnit.SECONDS) 
            .writeTimeout(120, TimeUnit.SECONDS) 
            .connectionPool(new ConnectionPool())
            .addInterceptor(new Interceptor() {
				@Override
				public Response intercept(Chain chain) throws IOException {
					Request req = chain.request();
					logger.debug("请求地址:" + req.url());
					return chain.proceed(req);
				}
			})
            .build();
    	
    }
}