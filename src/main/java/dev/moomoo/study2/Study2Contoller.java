package dev.moomoo.study2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.moomoo.ReqBody;

@RestController
@RequestMapping("/study2")
public class Study2Contoller {

    @GetMapping("/example1")
    public String example1(@RequestParam("a") String a, @RequestParam("b") String b) {
        String response = "";

        System.out.println("a : " + a + ", b : " + b);

        return response;
    }

    @PostMapping("/example2")
    public Map<String, Object> example2(@RequestBody ReqBody reqBody) {
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("a", reqBody.getA());
        responseMap.put("b", reqBody.getB());

        return responseMap;
    }

    @PostMapping("/example3/{a}")
    public String example3(@PathVariable("a") String a, @ModelAttribute ReqBody reqBody) {
        String response = new StringBuffer().append("a: ").append(reqBody.getA())
                .append(", b: ").append(reqBody.getB())
                .append(", c: ").append(reqBody.getC()).toString();

        return response;
    }

    @PostMapping("/example4")
    public String example4(@RequestHeader("Header-A") String a, @RequestHeader("Header-B") String b) {
        String response = new StringBuffer().append("a: ").append(a)
                .append(", b: ").append(b).toString();

        return response;

    }
}
