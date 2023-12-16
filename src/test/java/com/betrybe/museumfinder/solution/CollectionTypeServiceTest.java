package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
public class CollectionTypeServiceTest {

  @MockBean
  MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  CollectionTypeService collectionTypeService;

  @Test
  @DisplayName("Testa museu por tipo")
  public void testCountByCollectionTypes() {

    Mockito.when(museumFakeDatabase.countByCollectionType(any())).thenReturn(387L);

    CollectionTypeCount collectionTypeCount = collectionTypeService.countByCollectionTypes("história");
    String collectionType = collectionTypeCount.collectionTypes()[0];

    assertNotNull(collectionTypeCount);
    assertEquals("história", collectionType);
    assertEquals(387L, collectionTypeCount.count());

    Mockito.verify(museumFakeDatabase).countByCollectionType(eq("história"));
  }
}
