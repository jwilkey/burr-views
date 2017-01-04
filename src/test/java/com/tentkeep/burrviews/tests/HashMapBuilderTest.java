package com.tentkeep.burrviews.tests;

import com.tentkeep.burrviews.HashMapBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HashMapBuilderTest {

    @InjectMocks HashMapBuilder subject;

    @Test
    public void build_clearsKeyValuePairsAndReturnsAConfiguredMap() {
        subject.put("one", 1);
        subject.put("donkeys", "camels");

        Map<String, Object> map = subject.build();
        assertTrue(map.get("one").equals(1));
        assertTrue(map.get("donkeys").equals("camels"));

        map = subject.build();
        assertTrue(map.isEmpty());

        subject.put("fresh", "things");
        map = subject.build();
        assertTrue(map.get("one") == null);
        assertTrue(map.get("fresh").equals("things"));
    }
}