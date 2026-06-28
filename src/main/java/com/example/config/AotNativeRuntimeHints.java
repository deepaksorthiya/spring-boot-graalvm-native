package com.example.config;

import com.example.dto.CashCardDto;
import com.example.dto.MySerializable;
import com.example.dto.UserDto;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class AotNativeRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {

        // hints for reflection classes
        Class<?>[] reflectionHintsClasses = {CashCardDto.class, UserDto.class};

        for (Class<?> clazz : reflectionHintsClasses) {
            hints.reflection().registerType(clazz, MemberCategory.values());
        }

        // hints for serialization classes
        Class<?>[] serializationHintsClasses = {MySerializable.class};
        for (Class clazz : serializationHintsClasses) {
            hints.serialization().registerType(clazz);
        }

        // hints for proxy classes
        Class<?>[] proxyHintsClasses = {};
        for (Class<?> clazz : proxyHintsClasses) {
            hints.proxies()
                    .registerJdkProxy(clazz);
        }

        // hints for resources
        hints.resources().registerPattern("cashcard-banner.txt");
    }
}