package com.wbrain.ecommerce.mapper;

import com.wbrain.ecommerce.services.NoteServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotesMapperTest {

    @InjectMocks
    NotesMapper mapper;

    @Test
    public void mapSuccess(){
        Assertions.assertNotNull(mapper.map(new NoteServiceImplTest().createNoteRequest()));
    }
}
