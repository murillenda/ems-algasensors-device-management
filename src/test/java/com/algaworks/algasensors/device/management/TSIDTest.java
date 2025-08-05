package com.algaworks.algasensors.device.management;

import com.algaworks.algasensors.device.management.common.IdGenerator;
import io.hypersistence.tsid.TSID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class TSIDTest {

    @Test
    void shouldGenerateTSID() {
         // var tsid = TSID.Factory.getTsid(); // Instanciando um TSID a partir do factory padrão
        // Assim ele lê as propriedades do tsid.node e tsid.node.count e leva em consideração essas propriedades do sistema

        // TSID tsid = TSID.fast(); // não se deve utilizar em produção ou no mundo real, só é pra usar o fast para testes

        TSID tsid = IdGenerator.generateTSID();

        System.out.println(tsid); // String
        System.out.println(tsid.toLong()); // long
        System.out.println(tsid.getInstant()); // instant

        Assertions.assertThat(tsid.getInstant())
                .isCloseTo(Instant.now(), Assertions.within(1, ChronoUnit.MINUTES));
    }

}
