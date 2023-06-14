package com.springtour.example.chapter03;

import com.springtour.example.chapter03.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean01Application {
    public static void main(String[] args)
    {
        ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBean01Application.class, args);

        PriceUnit defaultPriceUnit = ctxt.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = ctxt.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));
    }

    @Bean(name="priceUnit")
    public PriceUnit dollorPriceUnit(){
        return new PriceUnit(Locale.US);
    }

    //@Bean(name="wonPriceUnit")
    @Bean
    public PriceUnit wonPriceUnit(){
        return new PriceUnit(null);
    }
}
