package com.example;

import com.example.dto.CashCardDto;
import com.example.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@ImportRuntimeHints(SpringBootGraalvmNativeApplication.Hints.class)
@RegisterReflectionForBinding({CashCardDto.class, UserDto.class})
public class SpringBootGraalvmNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraalvmNativeApplication.class, args);
    }

    static class Hints implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerPattern("cashcard-banner.txt");
        }
    }

    @GetMapping(value = {"/", "/server-info"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getRequestInfo(@RequestHeader LinkedHashMap<String, String> httpHeaders, HttpServletRequest httpServletRequest) {
        httpHeaders.put("remoteHost", httpServletRequest.getRemoteHost());
        httpHeaders.put("localAddress", httpServletRequest.getLocalAddr());
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            httpHeaders.put("hostName", localHost.getHostName());
            httpHeaders.put("hostAddress", localHost.getHostAddress());
            httpHeaders.put("canonicalHostName", localHost.getCanonicalHostName());
            httpHeaders.put("serverLocalDateTime", LocalDateTime.now().toString());
            httpHeaders.put("serverZonedDateTime", ZonedDateTime.now().toString());
            httpHeaders.put("serverOffsetDateTime", OffsetDateTime.now().toString());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return httpHeaders;
    }

}

