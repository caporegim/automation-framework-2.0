package io.github.uitests.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("randomVeteranProvider")
public class RandomVeteranProvider implements VeteranProvider {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String provideVeteranFileNumber() {
        return jdbcTemplate.queryForObject("SELECT FILE_NUMBER FROM (SELECT FILE_NUMBER FROM VBMSUI.EXT_PERSON WHERE FILE_NUMBER IS NOT NULL AND VETERAN_INDICATOR='Y' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM=1", String.class);
    }
}
