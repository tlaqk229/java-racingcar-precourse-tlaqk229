package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Race;

public class RaceTest {

    @Test
    @DisplayName("전진 정지 확인")
    void 전진_테스트() {
        assertThat(Race.goForward(0)).isEqualTo(0);
        assertThat(Race.goForward(3)).isEqualTo(0);
        assertThat(Race.goForward(4)).isEqualTo(1);
    }
}
