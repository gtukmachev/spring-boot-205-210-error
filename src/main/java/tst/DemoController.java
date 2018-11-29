package tst;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for processing sign in requests
 *
 * @author Anton Eroshenko
 */
@RestController
public class DemoController {

    @GetMapping("no-param")
    public Mono<Map<String, String>> noParam() {
        return monoMapOf("message", "hi");
    }

    @GetMapping("param")
    public Mono<Map<String, String>> param(@RequestParam("name") String name) {
        return monoMapOf("hi", name);
    }

    @PostMapping("body")
    public Mono<Map<String, String>> body(@RequestBody SomeBody b) {
        return monoMapOf("login", b.getLogin());
    }

    //utility function to inline a map (inside a Mono) creation with a single strings pair inside
    private Mono<Map<String, String>> monoMapOf(String key, String value) {
        Map<String, String> m = new HashMap<>();
        m.put(key, value);
        return Mono.just( m );
    }
}
