package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class SimpleTest {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);
    private List<String> prof = Arrays.asList("Программист", "Системный администратор", "Вэб Дизайнер", "Проджект менеджер");


    // ТЕСТ С ИСПОЛЬЗОВАНИЕМ ASSERTJ
    @Test
    public void simpleTest1() {
        Dog fido = new Dog("Fido", 5.25f);
        Dog fidosClone = new Dog("Fido", 5.25f);


        assertThat(fido)
                .as("Проверка")
                .isEqualToComparingFieldByField(fidosClone);
        LOG.info("тест прошел успешно");

    }

    // ТЕСТ С ИСПОЛЬЗОВАНИЕМ HAMCREST
    @Test
    public void simpleTest1ham() {
        Dog sudo = new Dog("Sudo", 5.25f);
        Dog sudosClone = new Dog("Sudo", 5.25f);

        assertThat(sudo,equalTo(sudosClone));
        LOG.info("тест прошел успешно");

    }



// ПРОСТОЙ ТЕСТ TESTNG
    @Test
    public void simpleTest2() {
        LOG.info("Это простой тест и он выполнен успешно");
    }

    // ПАРАМЕТРИЗОВАННЫЙ ТЕСТ TESTNG
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
