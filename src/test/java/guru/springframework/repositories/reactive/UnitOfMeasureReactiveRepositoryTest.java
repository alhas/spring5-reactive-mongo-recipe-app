package guru.springframework.repositories.reactive;


import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {

    public static final String GR = "gr";
    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Before
    public void setUp() throws Exception{

        unitOfMeasureReactiveRepository.deleteAll().block();

    }


    @Test
    public void setUOM() throws Exception {

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(GR);

        unitOfMeasureReactiveRepository.save(unitOfMeasure).block();
        Long count = (unitOfMeasureReactiveRepository.count().block());
        assertEquals(Long.valueOf(1L), count);

    }

    @Test
    public void testFindByDescription() throws Exception{

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(GR);


        unitOfMeasureReactiveRepository.save(unitOfMeasure).block();

        UnitOfMeasure fetchUOM = unitOfMeasureReactiveRepository.findByDescription(GR).block();

        assertEquals(GR,fetchUOM.getDescription());

    }

}