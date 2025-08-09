package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

    public static void main(String[] args) {
       
        Publication[] publications = {
            new Magazine("����ũ�μ���Ʈ����", "2007-10-01", 328, 9900, "����"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "����"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������")
        };

        ManageBook mb = new ManageBook();

        mb.printPublishBook(publications);

        int price = 39900;
        int index = 2;
        mb.changePrice(publications, price, index);

        mb.modifyPrice(publications);
        System.out.println("--���� �� ����--");
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
        System.out.println("���� :" + diffPrice + " å ���� :" + pubs[index].toString());
    }

  
    public void printPublishBook(Publication[] pubs) {
        for (Publication p : pubs) {
            System.out.println(p.toString());
        }
    }
    
    
}
