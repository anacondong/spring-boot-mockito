package com.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

    @MockBean
    private NameService nameService;

    @Autowired
    UserService userService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        //Given
        String expectData = "Mock user Anacondong !!!";

        //When
        when(nameService.getUserName(anyString())).thenReturn("Mock user Anacondong !!!");

        //Then
        String testName = userService.getUserName("SomeId");

        Assert.assertEquals(expectData, testName);
    }
}