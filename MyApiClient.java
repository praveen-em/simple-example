import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MyApiClient {

    private final WebClient webClient;

    // Constructor injection of WebClient
    public MyApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
    }

    // Method to make an API call
    public Mono<String> makeApiCall() {
        // Define API endpoint path
        String apiPath = "/data";

        // Make GET request and retrieve response
        return webClient.get()
                .uri(apiPath)
                .retrieve()
                .bodyToMono(String.class);
    }
}
