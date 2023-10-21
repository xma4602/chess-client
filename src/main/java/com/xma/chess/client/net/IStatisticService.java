package com.xma.chess.client.net;

import lombok.Value;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public interface IStatisticService {
    StatisticsResult requestStatistics();

    StatisticsData getStatisticsData();

    enum StatisticsResult {
        NOT_EXIST,
        CORRECT,
        DISCONNECT
    }

    @Value
    class StatisticsData {
        double totalTime;
        double wins, losses, draws;
        int gameCount;
        List<GameData> games;

        @Value
        public static class GameData {
            String date;
            String opponentLogin;
            GameResult result;
            Duration duration;

            public enum GameResult {
                WIN("победа"),
                LOSS("поражение"),
                DRAW("ничья");

                private final String result;

                GameResult(String result) {
                    this.result = result;
                }

                public String getResult() {
                    return result;
                }
            }
        }
    }
}
