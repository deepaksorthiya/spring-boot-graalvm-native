package com.example;

import com.example.config.AotNativeRuntimeHints;
import com.example.dto.CashCardDto;
import com.example.dto.MySerializable;
import com.example.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.predicate.RuntimeHintsPredicates;

import static org.assertj.core.api.Assertions.assertThat;

public class AotNativeRuntimeHintTests {


    @Test
    void shouldRegisterHints() {
        RuntimeHints hints = new RuntimeHints();
        new AotNativeRuntimeHints().registerHints(hints, getClass().getClassLoader());

        assertThat(RuntimeHintsPredicates.reflection()
                .onType(UserDto.class)
                .withMemberCategories(MemberCategory.values()))
                .accepts(hints);

        assertThat(RuntimeHintsPredicates.reflection()
                .onType(CashCardDto.class)
                .withMemberCategories(MemberCategory.values()))
                .accepts(hints);

        assertThat(RuntimeHintsPredicates.serialization()
                .onType(MySerializable.class))
                .accepts(hints);

        assertThat(RuntimeHintsPredicates.resource()
                .forResource("cashcard-banner.txt"))
                .accepts(hints);
    }

}