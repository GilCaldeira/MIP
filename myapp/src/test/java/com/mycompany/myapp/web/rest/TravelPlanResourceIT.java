package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.TravelPlan;
import com.mycompany.myapp.repository.TravelPlanRepository;
import com.mycompany.myapp.service.dto.TravelPlanDTO;
import com.mycompany.myapp.service.mapper.TravelPlanMapper;
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
 * Integration tests for the {@link TravelPlanResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TravelPlanResourceIT {

    private static final String DEFAULT_TRAVEL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TRAVEL_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TRAVEL_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRAVEL_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRAVEL_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRAVEL_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TRAVEL_SERVICES = "AAAAAAAAAA";
    private static final String UPDATED_TRAVEL_SERVICES = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/travel-plans";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TravelPlanRepository travelPlanRepository;

    @Autowired
    private TravelPlanMapper travelPlanMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTravelPlanMockMvc;

    private TravelPlan travelPlan;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TravelPlan createEntity(EntityManager em) {
        TravelPlan travelPlan = new TravelPlan()
            .travelName(DEFAULT_TRAVEL_NAME)
            .travelStartDate(DEFAULT_TRAVEL_START_DATE)
            .travelEndDate(DEFAULT_TRAVEL_END_DATE)
            .customerName(DEFAULT_CUSTOMER_NAME)
            .travelServices(DEFAULT_TRAVEL_SERVICES);
        return travelPlan;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TravelPlan createUpdatedEntity(EntityManager em) {
        TravelPlan travelPlan = new TravelPlan()
            .travelName(UPDATED_TRAVEL_NAME)
            .travelStartDate(UPDATED_TRAVEL_START_DATE)
            .travelEndDate(UPDATED_TRAVEL_END_DATE)
            .customerName(UPDATED_CUSTOMER_NAME)
            .travelServices(UPDATED_TRAVEL_SERVICES);
        return travelPlan;
    }

    @BeforeEach
    public void initTest() {
        travelPlan = createEntity(em);
    }

    @Test
    @Transactional
    void createTravelPlan() throws Exception {
        int databaseSizeBeforeCreate = travelPlanRepository.findAll().size();
        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);
        restTravelPlanMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(travelPlanDTO)))
            .andExpect(status().isCreated());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeCreate + 1);
        TravelPlan testTravelPlan = travelPlanList.get(travelPlanList.size() - 1);
        assertThat(testTravelPlan.getTravelName()).isEqualTo(DEFAULT_TRAVEL_NAME);
        assertThat(testTravelPlan.getTravelStartDate()).isEqualTo(DEFAULT_TRAVEL_START_DATE);
        assertThat(testTravelPlan.getTravelEndDate()).isEqualTo(DEFAULT_TRAVEL_END_DATE);
        assertThat(testTravelPlan.getCustomerName()).isEqualTo(DEFAULT_CUSTOMER_NAME);
        assertThat(testTravelPlan.getTravelServices()).isEqualTo(DEFAULT_TRAVEL_SERVICES);
    }

    @Test
    @Transactional
    void createTravelPlanWithExistingId() throws Exception {
        // Create the TravelPlan with an existing ID
        travelPlan.setId(1L);
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        int databaseSizeBeforeCreate = travelPlanRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTravelPlanMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(travelPlanDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTravelPlans() throws Exception {
        // Initialize the database
        travelPlanRepository.saveAndFlush(travelPlan);

        // Get all the travelPlanList
        restTravelPlanMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(travelPlan.getId().intValue())))
            .andExpect(jsonPath("$.[*].travelName").value(hasItem(DEFAULT_TRAVEL_NAME)))
            .andExpect(jsonPath("$.[*].travelStartDate").value(hasItem(DEFAULT_TRAVEL_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].travelEndDate").value(hasItem(DEFAULT_TRAVEL_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME)))
            .andExpect(jsonPath("$.[*].travelServices").value(hasItem(DEFAULT_TRAVEL_SERVICES)));
    }

    @Test
    @Transactional
    void getTravelPlan() throws Exception {
        // Initialize the database
        travelPlanRepository.saveAndFlush(travelPlan);

        // Get the travelPlan
        restTravelPlanMockMvc
            .perform(get(ENTITY_API_URL_ID, travelPlan.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(travelPlan.getId().intValue()))
            .andExpect(jsonPath("$.travelName").value(DEFAULT_TRAVEL_NAME))
            .andExpect(jsonPath("$.travelStartDate").value(DEFAULT_TRAVEL_START_DATE.toString()))
            .andExpect(jsonPath("$.travelEndDate").value(DEFAULT_TRAVEL_END_DATE.toString()))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME))
            .andExpect(jsonPath("$.travelServices").value(DEFAULT_TRAVEL_SERVICES));
    }

    @Test
    @Transactional
    void getNonExistingTravelPlan() throws Exception {
        // Get the travelPlan
        restTravelPlanMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewTravelPlan() throws Exception {
        // Initialize the database
        travelPlanRepository.saveAndFlush(travelPlan);

        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();

        // Update the travelPlan
        TravelPlan updatedTravelPlan = travelPlanRepository.findById(travelPlan.getId()).get();
        // Disconnect from session so that the updates on updatedTravelPlan are not directly saved in db
        em.detach(updatedTravelPlan);
        updatedTravelPlan
            .travelName(UPDATED_TRAVEL_NAME)
            .travelStartDate(UPDATED_TRAVEL_START_DATE)
            .travelEndDate(UPDATED_TRAVEL_END_DATE)
            .customerName(UPDATED_CUSTOMER_NAME)
            .travelServices(UPDATED_TRAVEL_SERVICES);
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(updatedTravelPlan);

        restTravelPlanMockMvc
            .perform(
                put(ENTITY_API_URL_ID, travelPlanDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(travelPlanDTO))
            )
            .andExpect(status().isOk());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
        TravelPlan testTravelPlan = travelPlanList.get(travelPlanList.size() - 1);
        assertThat(testTravelPlan.getTravelName()).isEqualTo(UPDATED_TRAVEL_NAME);
        assertThat(testTravelPlan.getTravelStartDate()).isEqualTo(UPDATED_TRAVEL_START_DATE);
        assertThat(testTravelPlan.getTravelEndDate()).isEqualTo(UPDATED_TRAVEL_END_DATE);
        assertThat(testTravelPlan.getCustomerName()).isEqualTo(UPDATED_CUSTOMER_NAME);
        assertThat(testTravelPlan.getTravelServices()).isEqualTo(UPDATED_TRAVEL_SERVICES);
    }

    @Test
    @Transactional
    void putNonExistingTravelPlan() throws Exception {
        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();
        travelPlan.setId(count.incrementAndGet());

        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTravelPlanMockMvc
            .perform(
                put(ENTITY_API_URL_ID, travelPlanDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(travelPlanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTravelPlan() throws Exception {
        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();
        travelPlan.setId(count.incrementAndGet());

        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTravelPlanMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(travelPlanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTravelPlan() throws Exception {
        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();
        travelPlan.setId(count.incrementAndGet());

        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTravelPlanMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(travelPlanDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTravelPlanWithPatch() throws Exception {
        // Initialize the database
        travelPlanRepository.saveAndFlush(travelPlan);

        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();

        // Update the travelPlan using partial update
        TravelPlan partialUpdatedTravelPlan = new TravelPlan();
        partialUpdatedTravelPlan.setId(travelPlan.getId());

        partialUpdatedTravelPlan.customerName(UPDATED_CUSTOMER_NAME).travelServices(UPDATED_TRAVEL_SERVICES);

        restTravelPlanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTravelPlan.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTravelPlan))
            )
            .andExpect(status().isOk());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
        TravelPlan testTravelPlan = travelPlanList.get(travelPlanList.size() - 1);
        assertThat(testTravelPlan.getTravelName()).isEqualTo(DEFAULT_TRAVEL_NAME);
        assertThat(testTravelPlan.getTravelStartDate()).isEqualTo(DEFAULT_TRAVEL_START_DATE);
        assertThat(testTravelPlan.getTravelEndDate()).isEqualTo(DEFAULT_TRAVEL_END_DATE);
        assertThat(testTravelPlan.getCustomerName()).isEqualTo(UPDATED_CUSTOMER_NAME);
        assertThat(testTravelPlan.getTravelServices()).isEqualTo(UPDATED_TRAVEL_SERVICES);
    }

    @Test
    @Transactional
    void fullUpdateTravelPlanWithPatch() throws Exception {
        // Initialize the database
        travelPlanRepository.saveAndFlush(travelPlan);

        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();

        // Update the travelPlan using partial update
        TravelPlan partialUpdatedTravelPlan = new TravelPlan();
        partialUpdatedTravelPlan.setId(travelPlan.getId());

        partialUpdatedTravelPlan
            .travelName(UPDATED_TRAVEL_NAME)
            .travelStartDate(UPDATED_TRAVEL_START_DATE)
            .travelEndDate(UPDATED_TRAVEL_END_DATE)
            .customerName(UPDATED_CUSTOMER_NAME)
            .travelServices(UPDATED_TRAVEL_SERVICES);

        restTravelPlanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTravelPlan.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedTravelPlan))
            )
            .andExpect(status().isOk());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
        TravelPlan testTravelPlan = travelPlanList.get(travelPlanList.size() - 1);
        assertThat(testTravelPlan.getTravelName()).isEqualTo(UPDATED_TRAVEL_NAME);
        assertThat(testTravelPlan.getTravelStartDate()).isEqualTo(UPDATED_TRAVEL_START_DATE);
        assertThat(testTravelPlan.getTravelEndDate()).isEqualTo(UPDATED_TRAVEL_END_DATE);
        assertThat(testTravelPlan.getCustomerName()).isEqualTo(UPDATED_CUSTOMER_NAME);
        assertThat(testTravelPlan.getTravelServices()).isEqualTo(UPDATED_TRAVEL_SERVICES);
    }

    @Test
    @Transactional
    void patchNonExistingTravelPlan() throws Exception {
        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();
        travelPlan.setId(count.incrementAndGet());

        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTravelPlanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, travelPlanDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(travelPlanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTravelPlan() throws Exception {
        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();
        travelPlan.setId(count.incrementAndGet());

        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTravelPlanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(travelPlanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTravelPlan() throws Exception {
        int databaseSizeBeforeUpdate = travelPlanRepository.findAll().size();
        travelPlan.setId(count.incrementAndGet());

        // Create the TravelPlan
        TravelPlanDTO travelPlanDTO = travelPlanMapper.toDto(travelPlan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTravelPlanMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(travelPlanDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TravelPlan in the database
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTravelPlan() throws Exception {
        // Initialize the database
        travelPlanRepository.saveAndFlush(travelPlan);

        int databaseSizeBeforeDelete = travelPlanRepository.findAll().size();

        // Delete the travelPlan
        restTravelPlanMockMvc
            .perform(delete(ENTITY_API_URL_ID, travelPlan.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TravelPlan> travelPlanList = travelPlanRepository.findAll();
        assertThat(travelPlanList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
