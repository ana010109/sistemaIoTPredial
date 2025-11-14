package config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "exchange_principal"; 

   
    public static final String QUEUE_LUZ = "fila.luz";
    public static final String QUEUE_PORTAO = "fila.portao";
    public static final String QUEUE_AR = "fila.ar";
    public static final String QUEUE_ESPACO = "fila.area";
    
    // As Routing Keys (coincidem com as chaves usadas pelos Produtores)
    public static final String KEY_LUZ = "key.luz"; 
    public static final String KEY_PORTAO = "key.portao";
    public static final String KEY_AR = "key.ar"; 
    public static final String KEY_ESPACO = "key.espaco"; 

    // Define o Exchange (apenas 1 é necessário)
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    // 1. Definições das Filas
    @Bean public Queue filaLuz() { return new Queue(QUEUE_LUZ, true); }
    @Bean public Queue filaPortao() { return new Queue(QUEUE_PORTAO, true); }
    @Bean public Queue filaAr() { return new Queue(QUEUE_AR, true); }
    @Bean public Queue filaEspaco() { return new Queue(QUEUE_ESPACO, true); }

    // 2. Definições dos Bindings (Associações)
    @Bean
    public Binding bindingLuz(TopicExchange exchange) {
        return BindingBuilder.bind(filaLuz()).to(exchange).with(KEY_LUZ);
    }
    @Bean
    public Binding bindingPortao(TopicExchange exchange) {
        return BindingBuilder.bind(filaPortao()).to(exchange).with(KEY_PORTAO);
    }
    @Bean
    public Binding bindingAr(TopicExchange exchange) {
        return BindingBuilder.bind(filaAr()).to(exchange).with(KEY_AR);
    }
    @Bean
    public Binding bindingEspaco(TopicExchange exchange) {
        return BindingBuilder.bind(filaEspaco()).to(exchange).with(KEY_ESPACO);
    }
    
    // 3. Conversor de Mensagens (para ler o JSON do DTO)
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}