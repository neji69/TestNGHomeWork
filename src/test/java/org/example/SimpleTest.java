package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class SimpleTest {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);
    private List<String> prof = Arrays.asList("Программист", "Системный администратор", "Вэб Дизайнер", "Проджект менеджер");



    @Test
    public void simpleTest1() {
        Dog fido = new Dog("Fido", 5.25f);
        Dog fidosClone = new Dog("Fido", 5.25f);


        assertThat(fido)
                .as("Проверка")
                .isEqualToComparingFieldByField(fidosClone);
        LOG.info("тест прошел успешно");

    }


    @Test
    public void simpleTest2() {
        LOG.info("Это простой тест и он выполнен успешно");
    }


    @DataProvider(name = "Имена")
    private Object[][] dataProvider() {
        return new Object[][]{
                {"Egor", 29},
                {"Ruslan", 25},
                {"Dima", 25},
                {"Yan", 25},
                {"Lilya", 24},
                {"Olya", 45},
                {"Danil", 19}
        };
    }

    @Test(dataProvider = "Имена")
    public void paramTest1(String name, int age) {
        String output = String.format("Name: '%s | Age: '%d'", name, age);
        LOG.info(output);
    }
}
