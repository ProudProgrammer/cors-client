package hu.gaborbalazs.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hu.gaborbalazs.model.Greeting;

@RestController
public class WebController {

	private static final String URL = "http://localhost:8080/greeting";
	private static final String CORS_ORIGINAL_ALL_URL = "http://localhost:8080/greetingCorsOriginAll";
	private static final String CORS_ORIGINAL_9000_URL = "http://localhost:8080/greetingCorsOrigin9000";
	private static final String CORS_ORIGINAL_9001_URL = "http://localhost:8080/greetingCorsOrigin9001";

	@Autowired
	private RestTemplate restTemplate;

	private HttpEntity<String> entity;

	@PostConstruct
	public void init() {
		// By default some headers are prohibited like 'origin'
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		HttpHeaders headers = new HttpHeaders();
		// If server uses CORS filters on end points like
		// @CrossOrigin(origins = "http://localhost:9001")
		// and it does not match with client 'origin' header then calls are not allowed
		// and send HTTP 403
		// Note: If client does not send 'origin' header but server uses CORS filters
		// then calls are allowed, so CORS is not about security
		headers.add("origin", "http://localhost:9000");
		entity = new HttpEntity<String>("parameters", headers);
	}

	@GetMapping("/greeting")
	public Greeting greeting() {
		ResponseEntity<Greeting> greeting = restTemplate.exchange(URL, HttpMethod.GET, entity, Greeting.class);
		return greeting.getBody();
	}

	@GetMapping("/greetingCorsOriginAll")
	public Greeting greetingCorsOriginAll() {
		ResponseEntity<Greeting> greeting = restTemplate.exchange(CORS_ORIGINAL_ALL_URL, HttpMethod.GET, entity,
				Greeting.class);
		return greeting.getBody();
	}

	@GetMapping("/greetingCorsOrigin9000")
	public Greeting greetingCorsOrigin9000() {
		ResponseEntity<Greeting> greeting = restTemplate.exchange(CORS_ORIGINAL_9000_URL, HttpMethod.GET, entity,
				Greeting.class);
		return greeting.getBody();
	}

	@GetMapping("/greetingCorsOrigin9001")
	public Greeting greetingCorsOrigin9001() {
		ResponseEntity<Greeting> greeting = restTemplate.exchange(CORS_ORIGINAL_9001_URL, HttpMethod.GET, entity,
				Greeting.class);
		return greeting.getBody();
	}
}
