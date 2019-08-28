package io.github.uitests.util;

import org.springframework.stereotype.Component;

@Component
public class HardCodedVeteranProvider implements VeteranProvider {
    @Override
    public String provideVeteranFileNumber() {
        return "792647811";
    }
}
