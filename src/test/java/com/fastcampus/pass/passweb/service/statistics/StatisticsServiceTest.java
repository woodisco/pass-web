package com.fastcampus.pass.passweb.service.statistics;

import com.fastcampus.pass.passweb.repository.statistics.StatisticsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceTest {

    @Mock
    private StatisticsRepository statisticsRepository;

    @InjectMocks
    private StatisticsService statisticsService;

    @Nested
    @DisplayName("통계 데이터를 기반으로 차트 만들기")
    class MakeChartData {
        final LocalDateTime to = LocalDateTime.of(2022, 9, 10, 0, 0);

        @Test
        @DisplayName("차트 데이터가 존재할 때")
        void makeChartData_when_hasStatistics() {
            List<AggregatedStatistics> statisticsList = List.of(
                    new AggregatedStatistics(to.minusDays(1), 15, 10, 5),
                    new AggregatedStatistics(to, 10, 8, 2)
            );

            // when
            when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to))).thenReturn(statisticsList);

            final ChartData chartData = statisticsService.makeChartData(to);

            // then
            verify(statisticsRepository, times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to));

            assertNotNull(chartData);
            assertEquals(new ArrayList<>(List.of("09-09", "09-10")), chartData.getLabels());
            assertEquals(new ArrayList<>(List.of(10L, 8L)), chartData.getAttendedCounts());
            assertEquals(new ArrayList<>(List.of(5L, 2L)), chartData.getCancelledCounts());
        }

        @Test
        @DisplayName("차트 데이터가 존재하지 않을 때")
        void makeChartData_when_notHasStatistics() {
            // when
            when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to))).thenReturn(Collections.emptyList());
            final ChartData chartData = statisticsService.makeChartData(to);

            // then
            verify(statisticsRepository, times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to));

            assertNotNull(chartData);
            assertTrue(chartData.getLabels().isEmpty());
            assertTrue(chartData.getAttendedCounts().isEmpty());
            assertTrue(chartData.getCancelledCounts().isEmpty());
        }
    }

    @Test
    @DisplayName("차트 데이터 만들기")
    public void test_makeChartData() {
        // given  to = 2022-09-10 00:00
        final LocalDateTime to = LocalDateTime.of(2022, 9, 10, 0, 0);

        List<AggregatedStatistics> statisticsList = List.of(
                new AggregatedStatistics(to.minusDays(1), 15, 10, 5),
                new AggregatedStatistics(to, 10, 8, 2)
        );

        // when
        // statisticsRepository Mock 객체가 findByStatisticsAtBetweenAndGroupBy()를 실행할 때 statisticsList를 반환합니다.
        when(statisticsRepository.findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to))).thenReturn(statisticsList);

        final ChartData chartData = statisticsService.makeChartData(to);

        // then
        // findByStatisticsAtBetweenAndGroupBy()가 1번 호출되었는지 검증합니다.
        verify(statisticsRepository, times(1)).findByStatisticsAtBetweenAndGroupBy(eq(to.minusDays(10)), eq(to));

        assertNotNull(chartData);
        assertEquals(new ArrayList<>(List.of("09-09", "09-10")), chartData.getLabels());
        assertEquals(new ArrayList<>(List.of(10L, 8L)), chartData.getAttendedCounts());
        assertEquals(new ArrayList<>(List.of(5L, 2L)), chartData.getCancelledCounts());
    }
}