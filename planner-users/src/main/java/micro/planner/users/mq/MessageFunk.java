package micro.planner.users.mq;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.util.function.Supplier;

//@Configuration
//@Getter
//public class MessageFunk {   // класс для работы с RabbitMQ

//    private Sinks.Many<Message<Long>> innerBus = Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
//
//    @Bean
//    public Supplier<Flux<Message<Long>>> newUserActionProduce(){
//        return () -> innerBus.asFlux();
//    }
//}
