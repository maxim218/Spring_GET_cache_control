package application.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class MyClass {

    @GetMapping(path="/getsum/", produces="application/json")
    public ResponseEntity getsum(@RequestParam(value="a") String a, @RequestParam(value="b") String b) {
        // count result
        String answer = a + "" + b;

        // init headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");

        // send answer to client
        return new ResponseEntity <String> (answer, headers, HttpStatus.OK);
    }


    @GetMapping(path="/sumcache/", produces="application/json")
    public ResponseEntity sumcache(@RequestParam(value="a") String a, @RequestParam(value="b") String b) {
        // count result
        String answer = a + "" + b;

        // init headers and cache result for 120 seconds
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "max-age=120");

        // send answer to client
        return new ResponseEntity <String> (answer, headers, HttpStatus.OK);
    }


    @GetMapping(path="/myname/", produces="application/json")
    public ResponseEntity myname() {
        return ResponseEntity.ok("Maxim");
    }

}

