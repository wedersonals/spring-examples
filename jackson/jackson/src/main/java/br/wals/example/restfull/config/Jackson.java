package br.wals.example.restfull.config;

import br.wals.example.restfull.enums.Raca;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Jackson {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //propriedades não mapeadas não quebram
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //não falhar se existir propriedade vazia
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //compatibilidade de arrays, quando tem um item apenas
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(racaModuleMapper());
        return objectMapper;
    }

    public SimpleModule racaModuleMapper() {
      SimpleModule module = new SimpleModule("JSONRacaModule", PackageVersion.VERSION);
      module.addSerializer(Raca.class, new RacaSerialize());
      module.addDeserializer(Raca.class, new RacaDeserialize());
      return module;
    }

    class RacaSerialize extends StdSerializer<Raca> {

        public RacaSerialize() {
            super(Raca.class);
        }

        @Override
        public void serialize(Raca raca, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(raca.getValue());
        }
    }

    class RacaDeserialize extends StdDeserializer<Raca> {

        RacaDeserialize() {
            super(Raca.class);
        }

        @Override
        public Raca deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return Raca.of(p.getText());
        }
    }
}
