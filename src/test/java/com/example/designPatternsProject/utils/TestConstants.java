package com.example.designPatternsProject.utils;

import com.example.designPatternsProject.dto.InformationHoliday;

public class TestConstants {
    public static final Long ID_ONE = 1L;
    public static final Long ID_TWO = 2L;

    public static final String NAME_ONE = "African Safari Adventure";
    public static final String NAME_TWO = "Discover Italy: Rome, Florence, and Venice";

    public static final InformationHoliday INFORMATION_HOLIDAY_ONE = new InformationHoliday(TestConstants.DESCRIPTION_ONE,
            TestConstants.ACTIVITIES_ONE);


    public static final String DESCRIPTION_ONE = "Embark on an unforgettable journey through the African wilderness " +
            "with this package that includes flights, accommodations, tours, and activities. Get up close with some " +
            "of the world's most amazing animals, learn about local cultures and traditions, and immerse yourself in " +
            "the stunning natural beauty of Africa.";
    public static final String DESCRIPTION_TWO = "Experience the beauty and culture of Italy with this package that " +
            "includes flights, hotels, tours, and transportation to three iconic cities.";

    public static final String ACTIVITIES_ONE = "1.Safari game drives to spot the Big Five, " +
            "2.Guided walks and hikes through national parks and reserves, " +
            "3.Visits to local communities to learn about traditional ways of life and customs, " +
            "4.Hot air balloon rides over the savannah at sunrise, " +
            "5.Nighttime game drives to see nocturnal animals.";
    public static final String ACTIVITIES_TWO = "Take a walking tour of historic landmarks, visit world-class museums, " +
            "sample delicious Italian cuisine, or take a romantic gondola ride in Venice.";

}
