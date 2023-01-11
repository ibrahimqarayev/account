package com.company.account.controller;

import com.company.account.dto.converter.AccountDtoConverter;
import com.company.account.repository.AccountRepository;
import com.company.account.service.AccountService;
import com.company.account.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "server-port=0",
        "command.line.runner.enabled=false"
})

@DirtiesContext
/*

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")

 */
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Clock clock;

    @MockBean
    private Supplier<UUID> uuidSupplier;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountDtoConverter converter;

    private AccountService accountService = new AccountService(accountRepository, customerService, converter, clock, uuidSupplier);
    private ObjectMapper mapper;
    private static  final UUID uuid=UUID.randomUUID();

}
