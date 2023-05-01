package P2M.moviecatatalogservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieCatatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatatalogServiceApplication.class, args);
	}
	//1ere methiode avec RestTemplate
	@LoadBalanced
	@Bean//this methode will be executed just one time , Note that we can create this function in everywhere in our code
	public RestTemplate getRestTemplate(){
		//set a timeout to make fault tolerance and resilience
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);//3000ms = 3s
		return new RestTemplate(clientHttpRequestFactory);

	}
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

}
