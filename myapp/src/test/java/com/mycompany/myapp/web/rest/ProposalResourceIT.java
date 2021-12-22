package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.Proposal;
import com.mycompany.myapp.repository.ProposalRepository;
import com.mycompany.myapp.service.dto.ProposalDTO;
import com.mycompany.myapp.service.mapper.ProposalMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ProposalResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ProposalResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_TRAVEL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TRAVEL_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TRAVEL_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRAVEL_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRAVEL_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRAVEL_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_TRAVEL_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TRAVEL_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SUGGESTED_AIRLINES = "AAAAAAAAAA";
    private static final String UPDATED_SUGGESTED_AIRLINES = "BBBBBBBBBB";

    private static final String DEFAULT_SUGGESTED_HOTELS = "AAAAAAAAAA";
    private static final String UPDATED_SUGGESTED_HOTELS = "BBBBBBBBBB";

    private static final String DEFAULT_OTHER_SUGGESTED_TRAVEL_SERVICES = "AAAAAAAAAA";
    private static final String UPDATED_OTHER_SUGGESTED_TRAVEL_SERVICES = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_FEEDBACK = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_FEEDBACK = "BBBBBBBBBB";

    private static final String DEFAULT_EXAMPLES_OTHER_TRAVEL_SERVICES = "AAAAAAAAAA";
    private static final String UPDATED_EXAMPLES_OTHER_TRAVEL_SERVICES = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/proposals";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private ProposalMapper proposalMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProposalMockMvc;

    private Proposal proposal;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Proposal createEntity(EntityManager em) {
        Proposal proposal = new Proposal()
            .name(DEFAULT_NAME)
            .customerName(DEFAULT_CUSTOMER_NAME)
            .customerEmail(DEFAULT_CUSTOMER_EMAIL)
            .travelName(DEFAULT_TRAVEL_NAME)
            .travelStartDate(DEFAULT_TRAVEL_START_DATE)
            .travelEndDate(DEFAULT_TRAVEL_END_DATE)
            .travelType(DEFAULT_TRAVEL_TYPE)
            .suggestedAirlines(DEFAULT_SUGGESTED_AIRLINES)
            .suggestedHotels(DEFAULT_SUGGESTED_HOTELS)
            .otherSuggestedTravelServices(DEFAULT_OTHER_SUGGESTED_TRAVEL_SERVICES)
            .state(DEFAULT_STATE)
            .customerFeedback(DEFAULT_CUSTOMER_FEEDBACK)
            .examplesOtherTravelServices(DEFAULT_EXAMPLES_OTHER_TRAVEL_SERVICES);
        return proposal;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Proposal createUpdatedEntity(EntityManager em) {
        Proposal proposal = new Proposal()
            .name(UPDATED_NAME)
            .customerName(UPDATED_CUSTOMER_NAME)
            .customerEmail(UPDATED_CUSTOMER_EMAIL)
            .travelName(UPDATED_TRAVEL_NAME)
            .travelStartDate(UPDATED_TRAVEL_START_DATE)
            .travelEndDate(UPDATED_TRAVEL_END_DATE)
            .travelType(UPDATED_TRAVEL_TYPE)
            .suggestedAirlines(UPDATED_SUGGESTED_AIRLINES)
            .suggestedHotels(UPDATED_SUGGESTED_HOTELS)
            .otherSuggestedTravelServices(UPDATED_OTHER_SUGGESTED_TRAVEL_SERVICES)
            .state(UPDATED_STATE)
            .customerFeedback(UPDATED_CUSTOMER_FEEDBACK)
            .examplesOtherTravelServices(UPDATED_EXAMPLES_OTHER_TRAVEL_SERVICES);
        return proposal;
    }

    @BeforeEach
    public void initTest() {
        proposal = createEntity(em);
    }

    @Test
    @Transactional
    void getAllProposals() throws Exception {
        // Initialize the database
        proposalRepository.saveAndFlush(proposal);

        // Get all the proposalList
        restProposalMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(proposal.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME)))
            .andExpect(jsonPath("$.[*].customerEmail").value(hasItem(DEFAULT_CUSTOMER_EMAIL)))
            .andExpect(jsonPath("$.[*].travelName").value(hasItem(DEFAULT_TRAVEL_NAME)))
            .andExpect(jsonPath("$.[*].travelStartDate").value(hasItem(DEFAULT_TRAVEL_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].travelEndDate").value(hasItem(DEFAULT_TRAVEL_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].travelType").value(hasItem(DEFAULT_TRAVEL_TYPE)))
            .andExpect(jsonPath("$.[*].suggestedAirlines").value(hasItem(DEFAULT_SUGGESTED_AIRLINES)))
            .andExpect(jsonPath("$.[*].suggestedHotels").value(hasItem(DEFAULT_SUGGESTED_HOTELS)))
            .andExpect(jsonPath("$.[*].otherSuggestedTravelServices").value(hasItem(DEFAULT_OTHER_SUGGESTED_TRAVEL_SERVICES)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].customerFeedback").value(hasItem(DEFAULT_CUSTOMER_FEEDBACK)))
            .andExpect(jsonPath("$.[*].examplesOtherTravelServices").value(hasItem(DEFAULT_EXAMPLES_OTHER_TRAVEL_SERVICES)));
    }

    @Test
    @Transactional
    void getProposal() throws Exception {
        // Initialize the database
        proposalRepository.saveAndFlush(proposal);

        // Get the proposal
        restProposalMockMvc
            .perform(get(ENTITY_API_URL_ID, proposal.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(proposal.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME))
            .andExpect(jsonPath("$.customerEmail").value(DEFAULT_CUSTOMER_EMAIL))
            .andExpect(jsonPath("$.travelName").value(DEFAULT_TRAVEL_NAME))
            .andExpect(jsonPath("$.travelStartDate").value(DEFAULT_TRAVEL_START_DATE.toString()))
            .andExpect(jsonPath("$.travelEndDate").value(DEFAULT_TRAVEL_END_DATE.toString()))
            .andExpect(jsonPath("$.travelType").value(DEFAULT_TRAVEL_TYPE))
            .andExpect(jsonPath("$.suggestedAirlines").value(DEFAULT_SUGGESTED_AIRLINES))
            .andExpect(jsonPath("$.suggestedHotels").value(DEFAULT_SUGGESTED_HOTELS))
            .andExpect(jsonPath("$.otherSuggestedTravelServices").value(DEFAULT_OTHER_SUGGESTED_TRAVEL_SERVICES))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.customerFeedback").value(DEFAULT_CUSTOMER_FEEDBACK))
            .andExpect(jsonPath("$.examplesOtherTravelServices").value(DEFAULT_EXAMPLES_OTHER_TRAVEL_SERVICES));
    }

    @Test
    @Transactional
    void getNonExistingProposal() throws Exception {
        // Get the proposal
        restProposalMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
