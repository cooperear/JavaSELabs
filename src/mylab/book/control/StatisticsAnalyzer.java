package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // ���ǹ� Ÿ�Ժ� ��� ���� ���
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

    // ���ǹ� ���� ���� ���
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

    // Ư�� ���� ���ǹ� ���� ���
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
    
    // ���ǹ� Ÿ�� Ȯ�� ���� �޼���
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "�Ҽ�";
        } else if (pub instanceof Magazine) {
            return "����";
        } else if (pub instanceof ReferenceBook) {
            return "����";
        }
        return "��Ÿ";
    }

    // ��� ���� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("====== ���ǹ� ��� ======");

        // Ÿ�Ժ� ��� ���� ���
        Map<String, Double> averagePrices = calculateAveragePriceByType(publications);
        System.out.println("--- Ÿ�Ժ� ��� ���� ---");
        for (Map.Entry<String, Double> entry : averagePrices.entrySet()) {
            System.out.println(entry.getKey() + " ��� ����: " + df.format(entry.getValue()) + "��");
        }

        // ���ǹ� ���� ���� ���
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n--- ���ǹ� ���� ���� ---");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println(entry.getKey() + " ����: " + df.format(entry.getValue()) + "%");
        }

        // 2007�⵵ ���ǹ� ���� ���
        double ratio = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n--- 2007�⵵ ���ǹ� ���� ---");
        System.out.println("����: " + df.format(ratio) + "%");
        
        System.out.println("=======================");
    }
}