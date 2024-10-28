package racingcar.race.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동자는_랜덤값이_4이상이면전진_4이하이면_멈춰있는_상태를_나타낸다() {
        assertRandomNumberInRangeTest(
                () -> {
                    //given
                    //when
                    run("mac, book", "1");
                    //then
                    assertThat(output()).contains("mac : -", "book :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자가_2명이상이면_쉼표를_구분자로한다() {
        //given
        List<String> participants = List.of("MAC", "APLLE", "BEST");
        Racer racer = Racer.of(participants);
        String expectedWinners = participants.stream().collect(Collectors.joining(", "));
        //when
        String winners = racer.getWinners();
        //then
        Assertions.assertThat(expectedWinners).isEqualTo(winners);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}