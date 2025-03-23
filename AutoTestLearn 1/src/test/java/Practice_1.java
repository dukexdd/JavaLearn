import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Practice_1 {

  // Блок с тестами

    @Test
    public void refundMoreThan10 () {
        var percentRefund = getRefundTicketPricePercent(245,false,false);
        Assertions.assertEquals(100, percentRefund);
    }

    @Test
    public void refundFrom6to10 () {
        var percentRefund = getRefundTicketPricePercent(168,false,false);
        Assertions.assertEquals(50, percentRefund);
    }
    @Test
    public void refund6d () {
        var percentRefund = getRefundTicketPricePercent(144,false,false);
        Assertions.assertEquals(50, percentRefund);
    }

    @Test
    public void refund10d () {
        var percentRefund = getRefundTicketPricePercent(240,false,false);
        Assertions.assertEquals(50, percentRefund);
    }

    @Test
    public void refundFrom3to5 () {
        var percentRefund = getRefundTicketPricePercent(96,false,false);
        Assertions.assertEquals(30, percentRefund);
    }
    @Test
    public void refund3d () {
        var percentRefund = getRefundTicketPricePercent(72,false,false);
        Assertions.assertEquals(30, percentRefund);
    }

    @Test
    public void refund5d () {
        var percentRefund = getRefundTicketPricePercent(120,false,false);
        Assertions.assertEquals(30, percentRefund);
    }

    @Test
    public void refundFrom0to3 () {
        var percentRefund = getRefundTicketPricePercent(71,false,false);
        Assertions.assertEquals(0, percentRefund);
    }

    @Test
    public void refund0d () {
        var percentRefund = getRefundTicketPricePercent(0,false,false);
        Assertions.assertEquals(0, percentRefund);
    }

    @Test
    public void refundConcertWasCancelled () {
        var percentRefund = getRefundTicketPricePercent(50,true,false );
        Assertions.assertEquals(100,percentRefund);
    }

    @Test
    public void refundConcertWasRescheduled() {
        var percentRefund = getRefundTicketPricePercent(50,false,true );
        Assertions.assertEquals(100,percentRefund);
    }

    @Test
    public void refundConcertWasRescheduledAndCancelled() {
        var percentRefund = getRefundTicketPricePercent(50,true,true );
        Assertions.assertEquals(100,percentRefund);
    }

    // Основной код программы

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)

    {

        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert>240) return 100;
        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;
        return 0;
    }
}
