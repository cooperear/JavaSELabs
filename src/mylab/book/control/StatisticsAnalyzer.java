package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // 출판물 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> averagePrices = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPrices.put(type, totalPrices.getOrDefault(type, 0.0) + pub.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        for (String type : counts.keySet()) {
            averagePrices.put(type, totalPrices.get(type) / counts.get(type));
        }

        return averagePrices;
    }

    // 출판물 유형 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCounts = new HashMap<>();
        int total = publications.length;

        if (total == 0) {
            return new HashMap<>();
        }

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : typeCounts.keySet()) {
            distribution.put(type, (double) typeCounts.get(type) / total * 100);
        }

        return distribution;
    }

    // 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int total = publications.length;
        int countByYear = 0;

        if (total == 0) {
            return 0.0;
        }

        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                countByYear++;
            }
        }

        return (double) countByYear / total * 100;
    }
    
    // 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        }
        return "기타";
    }

    // 통계 정보 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("====== 출판물 통계 ======");

        // 타입별 평균 가격 출력
        Map<String, Double> averagePrices = calculateAveragePriceByType(publications);
        System.out.println("--- 타입별 평균 가격 ---");
        for (Map.Entry<String, Double> entry : averagePrices.entrySet()) {
            System.out.println(entry.getKey() + " 평균 가격: " + df.format(entry.getValue()) + "원");
        }

        // 출판물 유형 분포 출력
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n--- 출판물 유형 분포 ---");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println(entry.getKey() + " 비율: " + df.format(entry.getValue()) + "%");
        }

        // 2007년도 출판물 비율 출력
        double ratio = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n--- 2007년도 출판물 비율 ---");
        System.out.println("비율: " + df.format(ratio) + "%");
        
        System.out.println("=======================");
    }
}