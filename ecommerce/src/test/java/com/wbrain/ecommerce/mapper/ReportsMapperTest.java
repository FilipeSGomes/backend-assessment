package com.wbrain.ecommerce.mapper;

import com.wbrain.ecommerce.services.NoteServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ReportsMapperTest {

    @InjectMocks
    ReportsMapper mapper;

    @Test
    public void mapSuccess() {
        Assertions.assertNotNull(mapper.map(new NoteServiceImplTest().notesList()));
    }

    @Test
    public void mapNotSuccess() {
        Assertions.assertNull(mapper.map(new ArrayList<>()));
    }
}
