package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnimalGroupNameTests {

        @Test
        public void ProvideKnownAnimalName_ExpectKnownHerdName() {
                // Arrange
                AnimalGroupName animalGroup = new AnimalGroupName();

                // Act
                String herdName = animalGroup.getHerd("giraffe");

                // Assert
                assertEquals("Tower", herdName);
        }

        @Test
        public void ProvideKnowAnimalName_CrazyCase_ExpectKnownHerdName() {
                //Arrange
                AnimalGroupName animalGroup = new AnimalGroupName();

                //Act
                String herdName = animalGroup.getHerd("GiRAffe");

                //Assert
                assertEquals("Tower", herdName);
        }

        @Test
        public void ProvideUnknownAnimalName_ExpectUnknownHerdName() {
                //Arrange
                AnimalGroupName animalGroup = new AnimalGroupName();

                //Act
                String herdName = animalGroup.getHerd("");
                String herdName2 = animalGroup.getHerd("elephants");

                //Assert
                assertEquals("unknown", herdName);
                assertEquals("unknown", herdName2);
        }
        
        @Test
        public void ProvideNull_ExpectUnknownHerdName() {
                //Arrange
                AnimalGroupName animalGroup = new AnimalGroupName();

                //Act
                String herdName = animalGroup.getHerd(null);

                //Assert
                assertEquals("unknown", herdName);
        }

}
