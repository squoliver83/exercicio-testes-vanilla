package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.FinancingFactory;

public class FinancingTest {
    @Test
    public void financingShouldBeCreatedWhenValidData() {
        Financing fin = FinancingFactory.createValidFinancing();
        Assertions.assertEquals(100000, fin.getTotalAmount());
        Assertions.assertEquals(2000, fin.getIncome());
        Assertions.assertEquals(80, fin.getMonths());
    }

    @Test
    public void createFinancingShouldThrowExceptionWhenInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = FinancingFactory.createInvalidFinancing();
        });
    }

    @Test
    public void totalAmountShouldBeUpdatedWhenValidData() {
        double newTotalAmount = 50000.0;
        Financing fin = FinancingFactory.createValidFinancing();
        fin.setTotalAmount(newTotalAmount);
        Assertions.assertEquals(newTotalAmount, fin.getTotalAmount());
    }

    @Test
    public void updateTotalAmountShouldThrowExceptionWhenInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            double newTotalAmount = 150000.0;
            Financing fin = FinancingFactory.createValidFinancing();
            fin.setTotalAmount(newTotalAmount);
        });
    }

    @Test
    public void incomeShouldBeUpdatedWhenValidData() {
        double newIncome = 4000.0;
        Financing fin = FinancingFactory.createValidFinancing();
        fin.setIncome(newIncome);
        Assertions.assertEquals(newIncome, fin.getIncome());
    }

    @Test
    public void updateIncomeShouldThrowExceptionWhenInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            double newIncome = 1500.0;
            Financing fin = FinancingFactory.createValidFinancing();
            fin.setIncome(newIncome);
        });
    }

    @Test
    public void monthsShouldBeUpdatedWhenValidData() {
        Integer NUMBER_OF_MONTHS = 100;
        Financing fin = FinancingFactory.createValidFinancing();
        fin.setMonths(NUMBER_OF_MONTHS);
        Assertions.assertEquals(NUMBER_OF_MONTHS, fin.getMonths());
    }

    @Test
    public void updateMonthsShouldThrowExceptionWhenInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer NUMBER_OF_MONTHS = 79;
            Financing fin = FinancingFactory.createValidFinancing();
            fin.setMonths(NUMBER_OF_MONTHS);
        });
    }

    @Test
    public void validateEntryCalculation() {
        double expectedValue = 20000.0;
        Financing fin = FinancingFactory.createValidFinancing();
        Assertions.assertEquals(expectedValue, fin.entry());
    }

    @Test
    public void validateQuotaCalculation() {
        double expectedValue = 1000.0;
        Financing fin = FinancingFactory.createValidFinancing();
        Assertions.assertEquals(expectedValue, fin.quota());
    }
}
