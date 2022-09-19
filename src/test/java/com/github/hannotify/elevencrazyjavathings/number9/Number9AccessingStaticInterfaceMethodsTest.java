package com.github.hannotify.elevencrazyjavathings.number9;

import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("#9 - Accessing static interface methods: a lot harder than you might think")
class Number9AccessingStaticInterfaceMethodsTest {
    @Test
    @DisplayName("Talk length description should be the right value")
    void testAccessingStaticInterfaceMethod() {
        Talk carrotsAreAwesome = new Talk("Bugs Bunny", "Carrots Are Awesome!", LocalTime.of(11, 0));

        assertThat(carrotsAreAwesome.LENGTH_IN_MINUTES).isEqualTo(50);

        //Following not possible because Static method may be invoked on containing interface class only
        //assertThat(carrotsAreAwesome.lengthDescription()).isEqualTo("This slot lasts 50 minutes.");

        //thus, need to call directly via Interface name
        assertThat(Slot.lengthDescription()).isEqualTo("This slot lasts 50 minutes.");
    }
}