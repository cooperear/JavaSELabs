package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

    public static void main(String[] args) {
       
        Publication[] publications = {
            new Magazine("마이크로소프트웨어", "2007-10-01", 328, 9900, "월간"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "월간"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래밍", "2007-01-14", 496, 25000, "소프트웨어공학")
        };

        ManageBook mb = new ManageBook();

        mb.printPublishBook(publications);

        int price = 39900;
        int index = 2;
        mb.changePrice(publications, price, index);

        mb.modifyPrice(publications);
        System.out.println("--할인 후 가격--");
        mb.printPublishBook(publications);
        
        
        StatisticsAnalyzer SAZ = new StatisticsAnalyzer();
        SAZ.printStatistics(publications);
        
           
    }


    public void modifyPrice(Publication[] pubs) {
        for (Publication pub : pubs) {
            int currentPrice = pub.getPrice();

            if (pub instanceof Magazine) {
                pub.setPrice((int) (currentPrice * 0.6));
            } else if (pub instanceof Novel) {
                pub.setPrice((int) (currentPrice * 0.8));
            } else {
                pub.setPrice((int) (currentPrice * 0.9));
            }
        }
    }

    public void changePrice(Publication[] pubs, int price, int index) {
        int diffPrice = price - pubs[index].getPrice();
        pubs[index].setPrice(price);
        System.out.println("차액 :" + diffPrice + " 책 정보 :" + pubs[index].toString());
    }

  
    public void printPublishBook(Publication[] pubs) {
        for (Publication p : pubs) {
            System.out.println(p.toString());
        }
    }
    
    
}
